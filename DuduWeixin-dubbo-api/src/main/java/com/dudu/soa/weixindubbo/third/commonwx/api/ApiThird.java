package com.dudu.soa.weixindubbo.third.commonwx.api;

import com.dudu.soa.weixindubbo.third.authorizationinfo.module.AuthorizationInfo;
import com.dudu.soa.weixindubbo.third.commonwx.module.AESParams;
import com.dudu.soa.weixindubbo.third.commonwx.module.AuthorizerInfo;
import com.dudu.soa.weixindubbo.third.commonwx.module.ComponentAccessToken;
import com.dudu.soa.weixindubbo.third.commonwx.module.ComponentVerifyTicket;
import com.dudu.soa.weixindubbo.third.commonwx.module.PreAuthCode;


/**
 * 第三方开发的相关接口
 * Created by lizhen on 2017/7/25.
 */

public interface ApiThird {


    /**
     * 消息解密
     *
     * @param aesParams 解密所需要的参数
     * @return 解密后的xml
     */
    String decrypt(AESParams aesParams);

    /**
     * 消息加密
     *
     * @param aesParams 解密所需要的参数
     * @return 加密后的xml
     */
    String encrypt(AESParams aesParams);

    /**
     * 在解密后的xml中获取ticket,并保存Ticket
     *
     * @param xml 解密后的xml
     * @return 协议的ticket
     */
    ComponentVerifyTicket processAuthorizationEvent(String xml);

    /**
     * 获取第三方开发平台的token
     *
     * @param componentVerifyTicket ticket协议的实体类
     * @return 第三方token的实体类
     */
    ComponentAccessToken getComponentAccessToken(ComponentVerifyTicket componentVerifyTicket);

    /**
     * 获取预授权码
     *
     * @param componentAccessToken token实体类
     * @return 预授权码
     */
    PreAuthCode getPreAuthCode(ComponentAccessToken componentAccessToken);

    /**
     * 使用授权码换取公众号或小程序的接口调用凭据和授权信息
     *
     * @param componentVerifyTicket 第三方appid
     * @param authorizationCode     授权的公众的授权码
     * @return 授权相关的信息
     */
    AuthorizationInfo getAuthorizationInfo(ComponentVerifyTicket componentVerifyTicket, String authorizationCode);
    /**
     * 获取授权方的帐号基本信息
     *
     * @param componentAccessToken 第三方的token实体类
     * @param authorizerAppid      appid
     * @return 授权方的帐号基本信息
     */
    AuthorizerInfo getAuthorizerInfo(ComponentAccessToken componentAccessToken, String authorizerAppid);


    /**
     * 获取公众号的授权信息
     *
     * @param appid                公众号的appid
     * @param componentAccessToken 第三方的token
     * @return 授权信息
     */
    AuthorizationInfo getWeiXinToken(String appid, ComponentAccessToken componentAccessToken);
}