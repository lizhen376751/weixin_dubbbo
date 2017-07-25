package com.dudu.soa.weixindubbo.weixin.http.service;

import com.alibaba.fastjson.JSONObject;
import com.dudu.soa.weixindubbo.thirdmessage.module.CustomerText;
import com.dudu.soa.weixindubbo.weixin.http.module.http.HttpMethod;
import com.dudu.soa.weixindubbo.weixin.http.module.http.WeixinActionMethodDefine;
import com.dudu.soa.weixindubbo.weixin.http.module.http.WeixinBaseParamter;
import com.dudu.soa.weixindubbo.weixin.http.module.menu.Menu;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.AccessToken;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.OauthOpenIdToken;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.SweepPay;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.WeiXinUserInfo;
import com.dudu.soa.weixindubbo.weixin.http.util.MapUtils;
import com.dudu.soa.weixindubbo.weixin.http.util.PayCommonUtil;
import com.dudu.soa.weixindubbo.weixin.http.util.XMLUtil;
import com.dudu.soa.weixindubbo.weixin.weixinmessage.Articles;
import com.dudu.soa.weixindubbo.weixin.weixinmessage.Mpnews;
import com.dudu.soa.weixindubbo.weixin.weixinmessage.ParamSendWeChat;
import com.dudu.soa.weixindubbo.weixin.weixinmessage.SendWeChat;
import com.dudu.soa.weixindubbo.weixin.weixinmessage.TeletextMessage;
import com.dudu.soa.weixindubbo.weixin.weixinmessage.Template;
import org.jdom.JDOMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


/**
 * 微信基本入口的逻辑包装
 * 关于微信的服务
 */
@Service
public class AllWeiXinService {
    /**
     * 日志打印
     */
    private static Logger log = LoggerFactory.getLogger(AllWeiXinService.class);
    /**
     * 引入图片上传和消息素材上传服务
     */
    @Autowired
    private FileUpload fileUpload;
    /**
     * 微信环境url配置
     */
    @Autowired
    private URLConfig urlConfig;

    /**
     * 获取开发者的token和jssdk的jsapiticket
     *
     * @param appid     appid
     * @param appSecret appSecret
     * @return 开发者的token
     * @throws IOException        网络异常
     * @throws URISyntaxException 异常
     */
    public static AccessToken getTokengetTicket(String appid, String appSecret) {
        AccessToken accessToken = new AccessToken();
        WeixinActionMethodDefine weixinActionMethodDefine = new WeixinActionMethodDefine()
                .setIsNeedAccssToken(false)
                .setHttpMethod(HttpMethod.GET)
                .setUri("/cgi-bin/token")
                .setWeixinBaseParamter(new WeixinBaseParamter().setAppid(appid).setSecret(appSecret))
                .putActionConfigParamter("grant_type", "client_credential");
        String jstoken = null;
        //调用微信JS接口的临时票据
        String jsticket = null;
        //token
        String accesstoken = null;
        try {
            jstoken = HttpUtils.request(weixinActionMethodDefine);
            accesstoken = JSONObject.parseObject(jstoken).getString("access_token");
            WeixinActionMethodDefine weixinActionMethodDefine2 = new WeixinActionMethodDefine()
                    .setHttpMethod(HttpMethod.GET)
                    .setIsNeedAppid(false)
                    .setUri("/cgi-bin/ticket/getticket")
                    .putActionConfigParamter("type", "jsapi")
                    .setWeixinBaseParamter(new WeixinBaseParamter().setToken(accesstoken));
            jsticket = HttpUtils.request(weixinActionMethodDefine2);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String jsapiticket = JSONObject.parseObject(jsticket).getString("ticket");
        String expiresin1 = JSONObject.parseObject(jstoken).getString("expires_in");
        int expiresin = 0;
        if (null != expiresin1 && !"".equals(expiresin1)) {
            expiresin = Integer.parseInt(expiresin1);
        }
        // 获取到token并赋值保存
        accessToken.setCreateTime(System.currentTimeMillis() / 1000)
                .setToken(accesstoken)
                .setExpiresIn(expiresin)
                .setTicket(jsapiticket);
        log.info(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
                + "token为==============================" + accesstoken
                + "jsticket为==============================" + jsapiticket);


        return accessToken;
    }

    /**
     * 利用redis获取token
     *
     * @param appid     微信的appid
     * @param appSecret 微信的appsecret
     * @return token
     */
    public static AccessToken getTokenTicket(String appid, String appSecret) {
        //1.首先在redis查询是否存有token(直接查询店铺编码)
        //2.如果没有直接获取存放在redis里面
        //3.如果有的话直接判断时间,是否过期,
        // 3.1过期的话重新获取,将之前的删除,并重新存入
        //3.2如果没有过期直接取出来用
        AccessToken tokengetTicket = new AccessToken();
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        List<String> rsmap = jedis.hmget(appid, "token", "ticket", "expiresIn", "createTime");
        String token = rsmap.get(0);
        String ticket = rsmap.get(1);
        if (token == null || token.equals("")) {
            tokengetTicket = getTokenTicket(appid, appSecret);
            Map map = MapUtils.toMap(tokengetTicket);
            jedis.hmset(appid, map);
        } else {
            int expiresIn = Integer.parseInt(rsmap.get(2));
            Long createTime = Long.parseLong(rsmap.get(3));
            //获取当前时间
            long time = new Date().getTime() / 1000;
            //判断是否在有效时间之内
            if (time - createTime > expiresIn) {
                //大于有效时间需要重新获取,首先删除记录,然后存储
                jedis.hlen(appid);
                tokengetTicket = getTokenTicket(appid, appSecret);
                Map map = MapUtils.toMap(tokengetTicket);
                jedis.hmset(appid, map);
            } else {
                tokengetTicket.setExpiresIn(expiresIn);
                tokengetTicket.setTicket(ticket);
                tokengetTicket.setToken(token);
            }

        }
        return tokengetTicket;
    }

    /**
     * 生成菜单
     *
     * @param menu      菜单
     * @param appid     appid
     * @param appSecret appSecret
     * @return 成功或者失败
     */
    public String createMenu(Menu menu, String appid, String appSecret) {
        //需要token,(appid,sercert)
        String flag = "";
        AccessToken tokengetTicket = null;
        try {
            tokengetTicket = this.getTokengetTicket(appid, appSecret);
            String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", tokengetTicket.getToken());
            String jsonMenu = JSONObject.toJSONString(menu);
            String jsonResult = HttpUtils.sendPostJson(url, jsonMenu);
            if (jsonResult != null) {
                int errorCode = Integer.parseInt(pareJsonDate(jsonResult, "errcode"));
                String errorMessage = pareJsonDate(jsonResult, "errmsg");
                if (errorCode == 0) {
                    flag = "创建成功";
                } else {
                    log.info("创建菜单成功:" + errorCode + "," + errorMessage);
                    flag = "创建菜单失败:" + errorCode + "," + errorMessage;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 模板消息的发送
     *
     * @param appid     微信appid
     * @param appSecret appsecret
     * @param template  微信的消息模板
     * @return template
     */
    public String sendTemplateMsg(String appid, String appSecret, Template template) {
        String url = template.getUrl();
        if (null != url && !"".equals(url) && !"null".equals(url)) {
            int ahiTiXing = url.indexOf("ahiTiXing");
            if (ahiTiXing >= 0) {
                url = urlConfig.getWeixinURL() + url;
                log.info("ahi检车的报告详情url为======" + url);
                template.setUrl(url);
            }
        }
        //获取token
        AccessToken tokengetTicket = this.getTokengetTicket(appid, appSecret);
        String flag = "";
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", tokengetTicket.getToken());

        try {
            String jsonResult = HttpUtils.sendPostJson(requestUrl, template.toJSON());
            //TODO 模板消息的处理
            if (jsonResult != null) {
                int errorCode = Integer.parseInt(pareJsonDate(jsonResult, "errcode"));
                String errorMessage = pareJsonDate(jsonResult, "errmsg");
                if (errorCode == 0) {
                    flag = "模板消息发送成功";
                } else {
                    log.info("模板消息发送失败:" + errorCode + "," + errorMessage);
                    flag = "模板消息发送失败:" + errorCode + "," + errorMessage;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            flag = e.getMessage();
        }
        return flag;

    }

    /**
     * 获取网页授权access_token及用户的openID
     *
     * @param appid     appid
     * @param appSecret appSecret
     * @param code      微信code
     * @return WeixinOauth2Token
     * @throws Exception Exception
     */
//    @Override
    public OauthOpenIdToken getOauthAccessToken(String code, String appid, String appSecret) {
        try {
            WeixinActionMethodDefine weixinActionMethodDefine = new WeixinActionMethodDefine()
                    .setHttpMethod(HttpMethod.GET)
                    .setIsNeedAccssToken(false)
                    .setUri("/sns/oauth2/access_token")
                    .putActionConfigParamter("grant_type", "authorization_code")
                    .putActionConfigParamter("code", code)
                    .setWeixinBaseParamter(new WeixinBaseParamter().setAppid(appid).setSecret(appSecret));
            String request = HttpUtils.request(weixinActionMethodDefine);
            log.info("获取openid=========================" + request);
            OauthOpenIdToken oauthOpenIdTokennew = new OauthOpenIdToken();
            String expiresin = pareJsonDate(request, "expires_in");
            if (null != expiresin && !"".equals(expiresin)) {
                oauthOpenIdTokennew.setExpiresIn(Integer.parseInt(expiresin));
            }
            oauthOpenIdTokennew.setOpenId(pareJsonDate(request, "openid"));
            oauthOpenIdTokennew.setScope(pareJsonDate(request, "scope"));
            oauthOpenIdTokennew.setRefreshToken(pareJsonDate(request, "refresh_token"));
            oauthOpenIdTokennew.setAccessToken(pareJsonDate(request, "access_token"));
            return oauthOpenIdTokennew;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //TODO 获取基本信息
        return null;
    }

    /**
     * 获取用户的基本信息
     *
     * @param code   权限code
     * @param appid  微信appId
     * @param secret 微信appSecret
     * @return 微信用户的基本信息
     * @throws Exception 异常
     */
    public WeiXinUserInfo getWeiXinUserInfo(String code, String appid, String secret) {
        //1.获取开发者的access_token
        AccessToken tokengetTicket = null;
        try {
            tokengetTicket = this.getTokengetTicket(appid, secret);
            String token = tokengetTicket.getToken();
            //2.获取openid
            OauthOpenIdToken oauthAccessToken = this.getOauthAccessToken(code, appid, secret);
            String openId = oauthAccessToken.getOpenId();
            WeixinActionMethodDefine weixinActionMethodDefine = new WeixinActionMethodDefine()
                    .setHttpMethod(HttpMethod.GET)
                    .setIsNeedAppid(false)
                    .setUri("/cgi-bin/user/info")
                    .putActionConfigParamter("lang", "zh_CN")
                    .putActionConfigParamter("openid", openId)
                    .setWeixinBaseParamter(new WeixinBaseParamter().setAppid(appid).setSecret(secret).setToken(token));
            String s = HttpUtils.request(weixinActionMethodDefine);
            //获取用户的昵称
            WeiXinUserInfo weiXinUserInfo = new WeiXinUserInfo()
                    .setCity(pareJsonDate(s, "city"))
                    .setCountry(pareJsonDate(s, "country"))
                    .setGroupid(pareJsonDate(s, "groupid"))
                    .setHeadimgurl(pareJsonDate(s, "headimgurl"))
                    .setLanguage(pareJsonDate(s, "language"))
                    .setNickname(pareJsonDate(s, "nickname"))
                    .setOpenid(pareJsonDate(s, "openid"))
                    .setProvince(pareJsonDate(s, "province"))
                    .setRemark(pareJsonDate(s, "remark"))
                    .setSex(pareJsonDate(s, "sex"))
                    .setSubscribe(pareJsonDate(s, "subscribe"))
                    .setSubscribetime(pareJsonDate(s, "subscribe_time"))
                    .setUnionid(pareJsonDate(s, "unionid"));
            return weiXinUserInfo;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

//    /**
//     * 获取jsticket
//     *
//     * @param appid     微信的appid
//     * @param appSecret 微信的 appSecret
//     */
//    public void getTicket(String appid, String appSecret) {
//        //获取token实体
//        AccessToken tokengetTicket = getTokengetTicket(appid, appSecret);
//        //在token实体中获取日期戳
//        long createTime = tokengetTicket.getCreateTime();
//        //在token实体中获取token
//        String token = tokengetTicket.getToken();
//        WeixinActionMethodDefine weixinActionMethodDefine = new WeixinActionMethodDefine()
//                .setHttpMethod(HttpMethod.GET)
//                .setIsNeedAppid(false)
//                .setUri("/cgi-bin/ticket/getticket")
//                .putActionConfigParamter("type", "jsapi")
//                .setWeixinBaseParamter(new WeixinBaseParamter().setToken(token));
//
//        //获取jsticket的执行体
//        String jsticket = null;
//        try {
//            jsticket = HttpUtils.request(weixinActionMethodDefine);
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        // 获取到js-SDK的ticket并赋值保存
//        String jsapiticket = pareJsonDate(jsticket, "ticket");
//        log.info("jsapi_ticket================================================" + jsapiticket);
//    }

    /**
     * 在返回的json字符串中获取想要的属性
     *
     * @param jsonData json字符串
     * @param param    想要获取的属性参数
     * @return 得到的参数
     */
    public String pareJsonDate(String jsonData, String param) {
        String params = JSONObject.parseObject(jsonData).getString(param);
        return params;
    }

    /**
     * 微信消息群发
     *
     * @param paramSendWeChat 微信消息群发所需要的参数
     * @return 返回发送的结果
     */
    public String sendGroupMessage(ParamSendWeChat paramSendWeChat) {

        //需要token,(appid,sercert)
        AccessToken tokengetTicket = this.getTokengetTicket(paramSendWeChat.getAppid(), paramSendWeChat.getAppSecret());
        String accessToken = tokengetTicket.getToken();
        String url = "https://api.weixin.qq.com/cgi-bin/message/mass/send?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", accessToken);
        String jsonResult = null;
        try {
            //获取图片上传的id
            String mediaid = fileUpload.uploadImage(accessToken, paramSendWeChat.getFilePath());
            TeletextMessage teletextMessage = new TeletextMessage();
            Articles article = new Articles();
            article.setThumbmediaid(mediaid);
            article.setContent(paramSendWeChat.getContent());
            article.setTitle(paramSendWeChat.getTitle());
            teletextMessage.setArticles(new Articles[]{article});
            //获取上传图文消息素材的id
            String textMessageId = fileUpload.uploadTextMessage(accessToken, teletextMessage);
            SendWeChat sendWeChat = new SendWeChat();
            sendWeChat.setTouser(paramSendWeChat.getTouser());
            sendWeChat.setMsgtype("mpnews");
            sendWeChat.setMpnews(new Mpnews().setMediaid(textMessageId));
            String jsonteletextMessage = JSONObject.toJSONString(sendWeChat);
            jsonResult = HttpUtils.sendPostJson(url, jsonteletextMessage);
        } catch (IOException e) {
            e.printStackTrace();
            jsonResult = e.getMessage();
        }
        log.info("微信消息群发返回结果======================================" + jsonResult);
        return jsonResult;

    }

    /**
     * 微信支付统一下单接口
     *
     * @param sweepPay 请求生成微信二维码的url
     * @return 微信二维码的url
     */
    public String weixinpay(SweepPay sweepPay) {
        SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
        packageParams.put("appid", sweepPay.getAppid());
        packageParams.put("mch_id", sweepPay.getMchid());
        // 随机字符串，长度要求在32位以内。推荐随机数生成算法
        String currTime = PayCommonUtil.getCurrTime();
        String strTime = currTime.substring(8, currTime.length());
        String strRandom = PayCommonUtil.buildRandom(4) + "";
        packageParams.put("nonce_str", strTime + strRandom);
        packageParams.put("body", sweepPay.getBody());
        packageParams.put("out_trade_no", sweepPay.getOuttradeno());
        packageParams.put("total_fee", sweepPay.getTotalfee());
        packageParams.put("spbill_create_ip", sweepPay.getSpbillcreateip());
        packageParams.put("notify_url", sweepPay.getNotifyurl());
        packageParams.put("trade_type", sweepPay.getTradetype());
        //签名 sign 通过签名算法计算得出的签名值，详见签名生成算法()
        String sign = PayCommonUtil.createSign("UTF-8", packageParams, sweepPay.getKey());
        packageParams.put("sign", sign);

        String requestXML = PayCommonUtil.getRequestXml(packageParams);
        log.info("第一步:微信扫码支付发送请求的post数据为=========" + requestXML);
        String resXml = HttpUtils.sendXmlPost("https://api.mch.weixin.qq.com/pay/unifiedorder", requestXML);
        log.info("第二步:微信扫码支付返回数据为=========" + resXml);
        Map map = null;
        try {
            map = XMLUtil.doXMLParse(resXml);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String returncode = (String) map.get("return_code"); //此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
        String returnmsg = (String) map.get("return_msg"); //返回信息，如非空，为错误原因签名失败 参数格式校验错误
        log.info("返回通讯标识为=========" + returncode + "错误原因为=========" + returnmsg);
        if ("OK".equals(returnmsg)) {
            String errcodedes = (String) map.get("err_code_des");
            log.info("返回业务错误原因为=========" + errcodedes);
        }

        String urlCode = (String) map.get("code_url");
        log.info("第三步:微信扫码支付返回的url数据为=========" + urlCode);
        return urlCode;
    }


    /**
     * 客服接口-发消息
     *
     * @param token        第三方开发平台的token
     * @param customerText 文本消息
     * @return 发送成功后的回调
     */
    public String customerSmsSend(String token, CustomerText customerText) {
        String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + token;
        String json = JSONObject.toJSONString(customerText);
        String jsonResult = "";
        try {
            jsonResult = HttpUtils.sendPostJson(url, json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonResult;
    }

}