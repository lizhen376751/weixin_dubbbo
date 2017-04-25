package com.dudu.soa.weixindubbo.weixin.http.old;

import com.alibaba.fastjson.JSONObject;
import com.dudu.soa.framework.commons.logger.LogUtil;
import com.dudu.soa.weixindubbo.weixin.http.module.http.HttpMethod;
import com.dudu.soa.weixindubbo.weixin.http.module.http.ParamterContentType;
import com.dudu.soa.weixindubbo.weixin.http.module.http.WeixinActionMethodDefine;
import com.dudu.soa.weixindubbo.weixin.http.module.http.WeixinExceptionHandler;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.AccessToken;

/**
 * Created by Administrator on 2017/4/13.
 */
public final class WeixinActionFactory {
    /**
     * 微信基础URL
     */
    private static final String BASE_URL = "https://api.weixin.qq.com";
    /**
     * apid
     */
    private static final String APPID = "wxf0af72edbe855d28";
    /**
     * sercert
     */
    private static final String APPSECRET = "fa12f20abeabc7c8ca3ebe777ceb2229";


    private WeixinActionFactory() {

    }

    /**
     * 获取业务接口请求URL
     *
     * @param actionMethodDefine 业务接口定义
     * @return 请求URL
     */
    public static String getActionURL(WeixinActionMethodDefine actionMethodDefine) {
        StringBuilder sb = new StringBuilder();
        sb.append(BASE_URL);
        sb.append(actionMethodDefine.getUri());
        sb.append("?");
        sb.append("appid").append("=").append(APPID).append("&");
        sb.append("secret").append("=").append(APPSECRET).append("&");
        for (String key : actionMethodDefine.getActionConfigParamter().keySet()) {
            sb.append(key).append("=").append(actionMethodDefine.getActionConfigParamter().get(key)).append("&");
        }
        if (actionMethodDefine.isIsNeedAccssToken()) {
            sb.append("access_token").append("=").append(WeixinActionFactory.getAccessToken().getToken());
            return sb.toString();
        } else {
            return sb.substring(0, sb.length() - 1);
        }
    }

    /**
     * 获取Token  兼容判断token失效情况
     *
     * @return token实体类
     */
    public static AccessToken getAccessToken() {
        //TODO accessToken首先从第三方缓存获取 此处为mock 判断兼容mock
        AccessToken token = new AccessToken();
        if (null == token || null == token.getToken() || System.currentTimeMillis() - token.getCreateTime() > token.getExpiresIn() * 1000) {
            JSONObject data = WeixinServer.requestforJSON(WeixinActionFactory.getAccessTokenAction(null), new JSONObject());
            LogUtil.getLogger().debug("token:{}", data.toJSONString());
            return JSONObject.toJavaObject(data, AccessToken.class);
        } else {
            return token;
        }
    }

    /**
     * 获取微信Token 接口封装
     *
     * @param exceptionHandler 异常处理器
     * @return 微信Token接口
     */
    public static WeixinActionMethodDefine getAccessTokenAction(WeixinExceptionHandler exceptionHandler) {
        return new WeixinActionMethodDefine()
                .setHttpMethod(HttpMethod.GET)
                .setParamterContentType(ParamterContentType.JSON)
                .setIsNeedAccssToken(false)
                .setUri("/cgi-bin/token")
                .putActionConfigParamter("grant_type", "client_credential");
    }


}
