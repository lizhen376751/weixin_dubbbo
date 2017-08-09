package com.dudu.soa.weixindubbo.third.service;


import com.alibaba.fastjson.JSONObject;
import com.dudu.soa.framework.cache.RedisUtil;
import com.dudu.soa.weixindubbo.third.aes.AesException;
import com.dudu.soa.weixindubbo.third.aes.WXBizMsgCrypt;
import com.dudu.soa.weixindubbo.third.api.ApiThird;
import com.dudu.soa.weixindubbo.third.module.AESParams;
import com.dudu.soa.weixindubbo.third.module.AuthorizationInfo;
import com.dudu.soa.weixindubbo.third.module.AuthorizerInfo;
import com.dudu.soa.weixindubbo.third.module.ComponentAccessToken;
import com.dudu.soa.weixindubbo.third.module.ComponentVerifyTicket;
import com.dudu.soa.weixindubbo.third.module.PreAuthCode;
import com.dudu.soa.weixindubbo.weixin.http.service.AllWeiXinService;
import com.dudu.soa.weixindubbo.weixin.http.service.HttpUtils;
import com.dudu.soa.weixindubbo.weixin.weixinconfig.module.WeiXinConfig;
import com.dudu.soa.weixindubbo.weixin.weixinconfig.service.WeiXinConfigService;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 第三方开发平台
 * Created by lizhen on 2017/7/17.
 */
@Service
public class ThirdService implements ApiThird {

    /**
     * 日志打印
     */
    private static Logger log = LoggerFactory.getLogger(ThirdService.class);
    /**
     * redis util
     */
    @Autowired
    private RedisUtil redisUtil;
    /**
     * 引用解析的json字符串的方法
     */
    @Autowired
    private AllWeiXinService allWeiXinService;
    /**
     * 微信配置相关
     */
    @Autowired
    private WeiXinConfigService weiXinConfigService;


    /**
     * 判断是否加密
     *
     * @param signature 前文描述密文消息体
     * @param timestamp URL上原有参数,时间戳
     * @param nonce     URL上原有参数,随机数
     * @return true或者false
     */
    @Override
    public boolean checkSignature(String token, String signature, String timestamp, String nonce) {
        log.info("判断是否加密 token:" + token + ";signature:" + signature + ";timestamp:" + timestamp + "nonce:" + nonce);
        boolean flag = false;
        if (signature != null && !signature.equals("") && timestamp != null && !timestamp.equals("") && nonce != null && !nonce.equals("")) {
            String sha1 = "";
            String[] ss = new String[]{token, timestamp, nonce};
            Arrays.sort(ss);
            for (String s : ss) {
                sha1 += s;
            }

            sha1 = AddSHA1.shi1(sha1);

            if (sha1.equals(signature)) {
                flag = true;
            }
            log.info("判断是否加密=========" + flag);
        }
        return flag;
    }

    /**
     * 十分钟推送一次,不需要解密直接获取appid
     * 获取密文的授权的Appid
     *
     * @param xml 内容
     * @return appid
     */
    @Override
    public String getAuthorizerAppidFromXml(String xml) {
        Document doc;
        try {
            doc = DocumentHelper.parseText(xml);
            Element rootElt = doc.getRootElement();
            String toUserName = rootElt.elementText("ToUserName");
            log.info("十分钟推送一次,不需要解密直接获取appid=" + toUserName);
            return toUserName;
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 消息解密
     *
     * @param aesParams 解密所需要的参数
     * @return 解密后的xml
     */
    @Override
    public String decrypt(AESParams aesParams) {
        log.info("解密传过来的参数为=" + aesParams.toString());
        WXBizMsgCrypt pc = null;
        String xml = "";
        try {
            pc = new WXBizMsgCrypt(aesParams.getToken(), aesParams.getEncodingAesKey(), aesParams.getAppId());
            //解密
            xml = pc.decryptMsg(aesParams.getMsgSignature(), aesParams.getTimestamp(), aesParams.getNonce(), aesParams.getXml());
        } catch (AesException e) {
            e.printStackTrace();
            log.info("消息解密失败原因:" + e.getMessage());
            xml = e.getMessage();
        }
        return xml;
    }

    /**
     * 消息加密
     *
     * @param aesParams 解密所需要的参数
     * @return 解密后的xml
     */
    @Override
    public String encrypt(AESParams aesParams) {
        log.info("加密传过来的参数为=" + aesParams.toString());
        WXBizMsgCrypt pc = null;
        String xml = "";
        try {

            pc = new WXBizMsgCrypt(aesParams.getToken(), aesParams.getEncodingAesKey(), aesParams.getAppId());
            //加密
            xml = pc.encryptMsg(aesParams.getXml(), aesParams.getTimestamp(), aesParams.getNonce());
        } catch (AesException e) {
            e.printStackTrace();
            log.info("消息加密失败原因:" + e.getMessage());
            xml = e.getMessage();
        }
        return xml;
    }

    /**
     * 在解密后的xml中获取ticket,并保存Ticket
     *
     * @param xml 解密后的xml
     * @return 协议的ticket
     */
    @Override
    public ComponentVerifyTicket processAuthorizationEvent(String xml) {
        log.info("十分钟发过来协议 在解密后的xml中获取ticket,xml = " + xml);
        Document doc;
        ComponentVerifyTicket entity = new ComponentVerifyTicket();
        try {
            WeiXinConfig third = weiXinConfigService.getWeiXinConfig("third");
            doc = DocumentHelper.parseText(xml);
            Element rootElt = doc.getRootElement();
            String ticket = rootElt.elementText("ComponentVerifyTicket");
            String appId = rootElt.elementText("AppId");
            String createTime = rootElt.elementText("CreateTime");
            String infoType = rootElt.elementText("InfoType");
            log.info("ticket解析后 ticket=" + ticket + ",appId=" + appId + ",createTime=" + createTime + ",infoType=" + infoType);
            if (ticket != null && !"".equals(ticket) && !"null".equals(ticket)) {
                entity.setAppId(appId).setComponentVerifyTicket(ticket).setCreateTime(createTime).setInfoType(infoType).setAppsecret(third.getAppserect());
                log.info("redis保存ticket...");
                saveTicket(entity);
                return entity;
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        log.info("十分钟发过来协议 在解密后的xml中获取ticket,并保存Ticket = " + entity.toString());
        return null;
    }

    /**
     * ticket缓存
     *
     * @param ticket ticket
     */
    private void saveTicket(ComponentVerifyTicket ticket) {
        String appId = ticket.getAppId();
        String key = appId + ":ticket";
        // 10分钟时间
        int seconds = 60 * 10;

        redisUtil.set(key, seconds, JSONObject.toJSONString(ticket));
    }

    /**
     * 获取Ticket
     *
     * @param appId appId
     * @return 返回ticket
     */
    private ComponentVerifyTicket getTicket(String appId) {
        String key = appId + ":ticket";
        String ticketStr = redisUtil.get(key);
        return ticketStr == null ? null : JSONObject.parseObject(redisUtil.get("ticket:" + appId), ComponentVerifyTicket.class);
    }

    /**
     * 获取第三方开发平台的token
     *
     * @param componentVerifyTicket ticket协议的实体类
     * @return 第三方token的实体类
     */
    @Override
    public ComponentAccessToken getComponentAccessToken(ComponentVerifyTicket componentVerifyTicket) {
        String appId = componentVerifyTicket.getAppId();
        String appSecret = componentVerifyTicket.getAppsecret();
        //token 2小时有效期
        int seconds = 2 * 60 * 60;

        String key =  appId + ":token";
        String tokenStr = redisUtil.get(key);

        if (tokenStr != null) {
            ComponentAccessToken componentAccessToken = JSONObject.parseObject(tokenStr, ComponentAccessToken.class);
            log.info("不为空的情况下redis缓存中获取token" + componentAccessToken.toString());
            return componentAccessToken;
        }

        log.info("获取第三方开发平台的token 传过来的Ticket = " + componentVerifyTicket.toString());
        String url = "https://api.weixin.qq.com/cgi-bin/component/api_component_token";
        String jsonData = "";
        if (null != componentVerifyTicket) {
            jsonData += "{";
            jsonData += "\"component_appid\":" + "\"" + componentVerifyTicket.getAppId() + "\",";
            jsonData += "\"component_appsecret\":" + "\"" + componentVerifyTicket.getAppsecret() + "\",";
            jsonData += "\"component_verify_ticket\":" + "\"" + componentVerifyTicket.getComponentVerifyTicket() + "\",}";
            log.debug("获取token时json的数据封装======" + jsonData);
        }

        ComponentAccessToken componentAccessToken = new ComponentAccessToken();
        try {
            String token = HttpUtils.sendPostJson(url, jsonData);
            log.info("获取第三方的token返回的结果为====" + token);
            String componentAccessToken1 = allWeiXinService.pareJsonDate(token, "component_access_token");
            String expiresIn = allWeiXinService.pareJsonDate(token, "expires_in");
            componentAccessToken.setAppid(componentVerifyTicket.getAppId());
            componentAccessToken.setComponentAccessToken(componentAccessToken1);
            componentAccessToken.setExpiresIn(expiresIn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("获取第三方开发平台的token = " + componentAccessToken.toString());
        String accessToken = componentAccessToken.getComponentAccessToken();
        if (accessToken != null && !"".equals(accessToken) && !"null".equals(accessToken)) {
            log.debug("redis保存第三方token开始 = ");
            redisUtil.set(key, seconds, JSONObject.toJSONString(componentAccessToken));
        }
        return componentAccessToken;
    }

    /**
     * 获取预授权码
     *
     * @param componentAccessToken token实体类
     * @return 预授权码
     */
    @Override
    public PreAuthCode getPreAuthCode(ComponentAccessToken componentAccessToken) {
        log.info("获取预授权码 参数第三方开发平台的token = " + componentAccessToken.toString());
        PreAuthCode preAuthCode = new PreAuthCode();
        String appId = componentAccessToken.getAppid();
        String token = componentAccessToken.getComponentAccessToken();
        //token 20分钟有效期
        int seconds = 20 * 60;

        String key = appId + ":preauthcode";
        String authStr = redisUtil.get(key);

        if (null != authStr) {
            preAuthCode = JSONObject.parseObject(authStr, PreAuthCode.class);
            log.debug("不为空的情况下在redis里面获取预授权码" + preAuthCode.toString());
            return preAuthCode;
        }


        String url = "https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token=" + componentAccessToken.getComponentAccessToken();

        String jsonData = "";
        if (null != componentAccessToken) {
            jsonData += "{";
            jsonData += "\"component_appid\":" + "\"" + appId + "\",}";
            log.debug("獲取預授權時封裝的json數據為======" + jsonData);
        }
        String preAuthCode1 = "";
        try {
            String sendPost = HttpUtils.sendPostJson(url, jsonData);
            preAuthCode1 = allWeiXinService.pareJsonDate(sendPost, "pre_auth_code");
            String expiresIn = allWeiXinService.pareJsonDate(sendPost, "expires_in");
            preAuthCode.setAppid(componentAccessToken.getAppid());
            preAuthCode.setPreAuthCode(preAuthCode1);
            preAuthCode.setExpiresIn(expiresIn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (preAuthCode1 != null && !"".equals(preAuthCode1) && !"null".equals(preAuthCode1)) {
            log.debug("redis保存预授权码开始 .... ");
            redisUtil.set(key, seconds, JSONObject.toJSONString(preAuthCode));
        }

        log.info("获取预授权码 = " + preAuthCode.toString());
        return preAuthCode;
    }

    /**
     * 使用授权码换取公众号或小程序的接口调用凭据和授权信息
     *
     * @param componentAccessToken 第三方appid及token相关信息
     * @param authorizationCode    授权的公众的授权码
     * @return 授权相关的信息
     */
    @Override
    public AuthorizationInfo getAuthorizationInfo(ComponentAccessToken componentAccessToken, String authorizationCode) {
        log.info("获取授权信息 参数获取第三方ComponentAccessToken=" + componentAccessToken.toString() + ",授权码authorizationCode=" + authorizationCode);
        AuthorizationInfo authorizationInfo = new AuthorizationInfo();
        String url = "https://api.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token=" + componentAccessToken.getComponentAccessToken();
        Map<String, String> params = new HashMap<String, String>();
        params.put("component_appid", componentAccessToken.getAppid());
        params.put("authorization_code", authorizationCode);
        try {
            String sendPost = HttpUtils.sendPost(url, params);
            String authorizationInfo1 = allWeiXinService.pareJsonDate(sendPost, "authorization_info");
            String authorizerAppid = allWeiXinService.pareJsonDate(sendPost, "authorizer_appid");
            String authorizerAccessToken = allWeiXinService.pareJsonDate(sendPost, "authorizer_access_token");
            String expiresIn = allWeiXinService.pareJsonDate(sendPost, "expires_in");
            String authorizerRefreshToken = allWeiXinService.pareJsonDate(sendPost, "authorizer_refresh_token");
            String funcInfo = allWeiXinService.pareJsonDate(sendPost, "func_info");
            authorizationInfo.setAuthorizationInfo(authorizationInfo1).setAuthorizerAppid(authorizerAppid).setAuthorizerRefreshToken(authorizerRefreshToken)
                    .setAuthorizerAccessToken(authorizerAccessToken).setExpiresIn(expiresIn).setFuncInfo(funcInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("获取授权信息  = " + authorizationInfo.toString());
        return authorizationInfo;
    }

    /**
     * 获取（刷新）授权公众号或小程序的接口调用凭据（令牌）
     *
     * @param componentAccessToken 第三方平台的token
     * @param authorizationInfo    公众号的授权信息
     * @return 公众号的授权信息
     */
    @Override
    public AuthorizationInfo refreshToken(ComponentAccessToken componentAccessToken, AuthorizationInfo authorizationInfo) {
        log.info("获取（刷新）授权公众号或小程序的接口调用凭据（令牌）componentAccessToken =" + componentAccessToken.toString()
                + ",AuthorizationInfo=" + authorizationInfo.toString());
        String url = "https:// api.weixin.qq.com /cgi-bin/component/api_authorizer_token?component_access_token=" + componentAccessToken.getComponentAccessToken();
        Map<String, String> params = new HashMap<String, String>();
        params.put("component_appid", componentAccessToken.getAppid());
        params.put("authorizer_appid", authorizationInfo.getAuthorizerAppid());
        params.put("authorizer_refresh_token", authorizationInfo.getAuthorizerRefreshToken());
        try {
            String sendPost = HttpUtils.sendPost(url, params);
            String authorizerAccessToken = allWeiXinService.pareJsonDate(sendPost, "authorizer_access_token");
            String expiresIn = allWeiXinService.pareJsonDate(sendPost, "expires_in");
            String authorizerRefreshToken = allWeiXinService.pareJsonDate(sendPost, "authorizer_refresh_token");
            authorizationInfo.setAuthorizerRefreshToken(authorizerRefreshToken).setAuthorizerAccessToken(authorizerAccessToken).setExpiresIn(expiresIn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("获取（刷新）授权公众号或小程序的接口调用凭据" + authorizationInfo.toString());
        return authorizationInfo;
    }

    /**
     * 获取授权方的帐号基本信息
     *
     * @param componentAccessToken 第三方的token实体类
     * @param authorizerAppid      appid
     * @return 授权方的帐号基本信息
     */
    @Override
    public AuthorizerInfo getAuthorizerInfo(ComponentAccessToken componentAccessToken, String authorizerAppid) {
        log.info("获取授权方的帐号基本信息ComponentAccessToken=" + componentAccessToken.toString() + ",授权方的appid=" + authorizerAppid);
        AuthorizerInfo authorizerInfo = new AuthorizerInfo();
        AuthorizationInfo authorizationInfo = new AuthorizationInfo();
        String url = "https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_info?component_access_token=" + componentAccessToken.getComponentAccessToken();
        Map<String, String> params = new HashMap<String, String>();
        params.put("component_appid", componentAccessToken.getAppid());
        params.put("authorizer_appid", authorizerAppid);
        try {
            String sendPost = HttpUtils.sendPost(url, params);
            String nickName = allWeiXinService.pareJsonDate(sendPost, "nick_name");
            String headImg = allWeiXinService.pareJsonDate(sendPost, "head_img");
            String serviceTypeInfo = allWeiXinService.pareJsonDate(sendPost, "service_type_info");
            String verifyTypeInfo = allWeiXinService.pareJsonDate(sendPost, "verify_type_info");
            String userName = allWeiXinService.pareJsonDate(sendPost, "user_name");
            String principalName = allWeiXinService.pareJsonDate(sendPost, "principal_name");
            String alias = allWeiXinService.pareJsonDate(sendPost, "alias");
            String businessInfo = allWeiXinService.pareJsonDate(sendPost, "business_info");
            String qrcodeUrl = allWeiXinService.pareJsonDate(sendPost, "qrcode_url");
            String authorizationInfo1 = allWeiXinService.pareJsonDate(sendPost, "authorization_info");
            String appid = allWeiXinService.pareJsonDate(sendPost, "appid");
            String funcInfo = allWeiXinService.pareJsonDate(sendPost, "func_info");
            authorizerInfo.setNickName(nickName);
            authorizerInfo.setAlias(alias);
            authorizerInfo.setBusinessInfo(businessInfo);
            authorizerInfo.setHeadImg(headImg);
            authorizerInfo.setPrincipalName(principalName);
            authorizerInfo.setQrcodeUrl(qrcodeUrl);
            authorizerInfo.setServiceTypeInfo(serviceTypeInfo);
            authorizerInfo.setUserName(userName);
            authorizerInfo.setVerifyTypeInfo(verifyTypeInfo);
            authorizationInfo.setAuthorizerAppid(appid);
            authorizationInfo.setFuncInfo(funcInfo);
            authorizerInfo.setAuthorizationInfo(authorizationInfo);

        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("获取授权方的帐号基本信息authorizerInfo=" + authorizerInfo.toString());
        return authorizerInfo;
    }

}
