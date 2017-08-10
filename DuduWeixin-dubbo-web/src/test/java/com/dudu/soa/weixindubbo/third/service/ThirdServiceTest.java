package com.dudu.soa.weixindubbo.third.service;

import com.dudu.soa.framework.cache.RedisUtil;
import com.dudu.soa.weixindubbo.third.module.AESParams;
import com.dudu.soa.weixindubbo.third.module.AuthorizationInfo;
import com.dudu.soa.weixindubbo.third.module.AuthorizerInfo;
import com.dudu.soa.weixindubbo.weixin.http.service.AllWeiXinService;
import com.dudu.soa.wxd.test.TestBase;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/8/5.
 */
public class ThirdServiceTest extends TestBase {


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
    @Autowired
    private ThirdService thirdService;

    @Test
    public void getComponentAccessToken() throws Exception {
        String sendPost = "{\n" +
                "\"authorizer_info\": {\n" +
                "\"nick_name\": \"微信SDK Demo Special\", \n" +
                "\"head_img\": \"http://wx.qlogo.cn/mmopen/GPy\", \n" +
                "\"service_type_info\": { \"id\": 2 }, \n" +
                "\"verify_type_info\": { \"id\": 0 },\n" +
                "\"user_name\":\"gh_eb5e3a772040\",\n" +
                "\"principal_name\":\"腾讯计算机系统有限公司\",\n" +
                "\"business_info\": {\"open_store\": 0, \"open_scan\": 0, \"open_pay\": 0, \"open_card\": 0, \"open_shake\": 0},\n" +
                "\"alias\":\"paytest01\",\n" +
                "\"qrcode_url\":\"URL\"\n" +
                "},     \n" +
                "\"authorization_info\": {\n" +
                "\"appid\": \"wxf8b4f85f3a794e77\", \n" +
                "\"func_info\": [\n" +
                "{ \"funcscope_category\": { \"id\": 1 } }, \n" +
                "{ \"funcscope_category\": { \"id\": 2 } }, \n" +
                "{ \"funcscope_category\": { \"id\": 3 } }\n" +
                "]\n" +
                "}\n" +
                "}";
        AuthorizerInfo authorizerInfo = new AuthorizerInfo();
        AuthorizationInfo authorizationInfo = new AuthorizationInfo();

        String authorizationInfo1 = allWeiXinService.pareJsonDate(sendPost, "authorizer_info");
        String nickName = allWeiXinService.pareJsonDate(authorizationInfo1, "nick_name");
        String headImg = allWeiXinService.pareJsonDate(authorizationInfo1, "head_img");
        String serviceTypeInfo = allWeiXinService.pareJsonDate(authorizationInfo1, "service_type_info");
        String verifyTypeInfo = allWeiXinService.pareJsonDate(authorizationInfo1, "verify_type_info");
        String userName = allWeiXinService.pareJsonDate(authorizationInfo1, "user_name");
        String principalName = allWeiXinService.pareJsonDate(authorizationInfo1, "principal_name");
        String alias = allWeiXinService.pareJsonDate(authorizationInfo1, "alias");
        String businessInfo = allWeiXinService.pareJsonDate(authorizationInfo1, "business_info");
        String qrcodeUrl = allWeiXinService.pareJsonDate(authorizationInfo1, "qrcode_url");
        String authorizerInfo1 = allWeiXinService.pareJsonDate(sendPost, "authorization_info");
        String appid = allWeiXinService.pareJsonDate(authorizerInfo1, "appid");
        String funcInfo = allWeiXinService.pareJsonDate(authorizerInfo1, "func_info");
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
        System.out.println("===============" + authorizerInfo.toString());


//        String sendPost = "{\"authorization_info\":{\"authorizer_appid\":\"wx570bc396a51b8ff8\",\"authorizer_access_token\":\"g773VasgZfOu_bYrbbPNjpRTxSIwAMDFYpODWaGfQW6xwgBprLj_U6ZiNayyilv2ewmt35fKo3byPJOututQ9tPkQ06ieeSNd0wazbz3XcmnnZw8hW2pvEXwjWGElubXJGJbAIDAXA\",\"expires_in\":7200,\"authorizer_refresh_token\":\"refreshtoken@@@8nBUHdj9hKazGwk4BOQoC6l-97b4FeuXZxGuIGgTMX4\",\"func_info\":[{\"funcscope_category\":{\"id\":1}},{\"funcscope_category\":{\"id\":15}},{\"funcscope_category\":{\"id\":4}},{\"funcscope_category\":{\"id\":7}},{\"funcscope_category\":{\"id\":2}},{\"funcscope_category\":{\"id\":3}},{\"funcscope_category\":{\"id\":11}},{\"funcscope_category\":{\"id\":6}},{\"funcscope_category\":{\"id\":5}},{\"funcscope_category\":{\"id\":8}},{\"funcscope_category\":{\"id\":13}},{\"funcscope_category\":{\"id\":9}},{\"funcscope_category\":{\"id\":10}},{\"funcscope_category\":{\"id\":12}},{\"funcscope_category\":{\"id\":22}},{\"funcscope_category\":{\"id\":23}},{\"funcscope_category\":{\"id\":24},\"confirm_info\":{\"need_confirm\":0,\"already_confirm\":0,\"can_confirm\":0}},{\"funcscope_category\":{\"id\":26}}]}}";
//        String authorizationInfo1 = allWeiXinService.pareJsonDate(sendPost, "authorization_info");
//        String authorizerAppid = allWeiXinService.pareJsonDate(authorizationInfo1, "authorizer_appid");
//        String authorizerAccessToken = allWeiXinService.pareJsonDate(authorizationInfo1, "authorizer_access_token");
//        String expiresIn = allWeiXinService.pareJsonDate(authorizationInfo1, "expires_in");
//        String authorizerRefreshToken = allWeiXinService.pareJsonDate(authorizationInfo1, "authorizer_refresh_token");
//        String funcInfo = allWeiXinService.pareJsonDate(authorizationInfo1, "func_info");
//        String sss = "[{\"funcscope_category\":{\"id\":1}},{\"funcscope_category\":{\"id\":15}},{\"funcscope_category\":{\"id\":4}},{\"funcscope_category\":{\"id\":7}},{\"funcscope_category\":{\"id\":2}},{\"funcscope_category\":{\"id\":3}},{\"funcscope_category\":{\"id\":11}},{\"funcscope_category\":{\"id\":6}},{\"funcscope_category\":{\"id\":5}},{\"funcscope_category\":{\"id\":8}},{\"funcscope_category\":{\"id\":13}},{\"funcscope_category\":{\"id\":9}},{\"funcscope_category\":{\"id\":10}},{\"funcscope_category\":{\"id\":12}},{\"funcscope_category\":{\"id\":22}},{\"funcscope_category\":{\"id\":23}},{\"funcscope_category\":{\"id\":24},\"confirm_info\":{\"need_confirm\":0,\"can_confirm\":0,\"already_confirm\":0}},{\"funcscope_category\":{\"id\":26}}]";

    }

    @Test
    public void decrypt() throws Exception {
        String xml = "<xml>    <ToUserName><![CDATA[gh_3c884a361561]]></ToUserName>    <Encrypt><![CDATA[2DJmn6cI2gwkJO6Etv0dpGie8rwwkUXEj54WzdQRDNVG8arolzvMhfm7WnewPgaEujvei1SyOueg24J6b6GGNWIKU76ZfUedbLaNSJevb1Qvih0pE3QbnHucnA3Rr9O6IyToTEv+X0F5+NMzbdefcoz2E2wanIymVLx7iNa4tSBzKYEM+IYkdRDRVV/oydcjblhZ6MXLvR4vCfsSW2vVG+1NNtbG4JJ9VaNASs1IYXqM/heRax+6vFm4FIeYckrxwMDMieKil2nxgWxf24x5fIETu+8RqTztHaR2qYpT2iBQUH/xOiw50W4MGygc4SJLKkX+tMaGefXyjsmB/6GNyDIeg92aL9xEiGG89ajxaYkX5PVfNkJQKHXljFfk7HUF1rYw81yzt8lZ+1/Vf4zdoB74VHxnPCIx0xLvsrYZAw1PhjAxwJY9BjK+54X5/AEohBPSftJIjbyGG9fC9bDijQ==]]></Encrypt></xml>";

//        String xml = "<xml>    <ToUserName><![CDATA[wx77ea274ef9f3e504]]></ToUserName>    <Encrypt><![CDATA[bwudS/KOO3X54B+BlNiSSKcGjCKWD4XGImYxn03E65T3vtKvpDNciNFtMU8zknmiSF8dP0sEUyZ8acFfhGqBdWagu3nk+KvBO7+YkSmx2K0HfE9Urtmf5tuL8D2mA6Yo9psDsVTnxQmdO7/Iwax3W8+iZGbZ5Tjey0rsFs3dPCMPaXSoKCBka89MnRb5OraVIiEOtynxvxSbg3/Itmi8qRj/+jDinLo/nr+du9muR/RuqXUcuEXINTojqur7ATNvLhugtOllMaUDEFE/tpaCPJy2p9Obvm/Qk6dMMc4ysRwQubWL6QkDQvkn2tc5ncyyQb4wpomVr0Z/MI7o7TXVHmukaURL9TyhQhZ48r9syBnrVFBDOUMtlk7WLUNQz6lAbgh/ujvqdN7reZaGRs8PaygWv51WEHqTqr3G4wdFMz61JMadGD0Oa73kegEmy5Kd/QJbUHa4ue5x1UhlrArxJA==]]></Encrypt></xml>";
//        String xml1 ="<xml>    <AppId><![CDATA[wx77ea274ef9f3e504]]></AppId>    <Encrypt><![CDATA[BL7//7xq0DmeUdDfZiVkdMuFCgyOI+yPW+j+Sozn1v/Xo3SOM8zSz/B2DcaWGBTkYZf7HYEgQBPKi+Q195TmFFr7Oe19A/VNeQ8d6313m+7dr6zvUsVQu7ApiL1VpJdZzrrYC4swctLUAYa+KU3dYjrg0s0JwM47vr+T1JwRQ3GvdH4QSW+midOksAjotov4xPTgFpMCIh7YZH7f7njlkIVLrRLX2QEDupG/VO3nPidvTntTz5VcVLbCfq2q5BTmsoJQQNaJSrMyD03tklJKzP1Ji5sZhXnOD0Rf3xNrOaTfPtL6N6TC7M9nAKMoD2fuQOXqanV2IQPMf1Zj/T//+IWQsbKljEOYa+E8vhmWao7o+BStB7jvTJ6GO7dve/rhYtdEgO5Imqx1wxpX6N9GwD0eI2h6ZrWlaEaxd0Ne7vk/Im0dI1o598dpkFDxa4mL7z0/CleyTxc9relHyItSQ6IKcFPzEJhkZgi7nzaEQMmyeGHLRbKJRlMDFmLM+6Oz3BPbETZY0+PzbbEXj/A8QvwrVWDCJpUXkNZJYsKznXcgio60FJNbB2RzBR3/F/XToTDLBcIFFlkRpeuzMhJyurdjyoNeYBa3kpF74oO5iSU1+0fGmdoDN9OoD2a2zNCS]]></Encrypt></xml>";
//        if (xml1.indexOf("AppId") != -1) {
//            xml1 = xml1.replace("AppId", "ToUserName");
//        }
//        System.out.println(xml1);
        Document doc;
        try {
            doc = DocumentHelper.parseText(xml);
            Element rootElt = doc.getRootElement();
            String toUserName = rootElt.elementText("ToUserName");
            System.out.println("+++" + toUserName);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        /**
         * 解密
         */
        AESParams aesParams = new AESParams();
        aesParams.setToken("yirenyiche").setAppId("wx77ea274ef9f3e504").setEncodingAesKey("6o24ph2raAINvT45jKLeruT59sPsJ9QXCwXFXUK4Vhr").
                setMsgSignature("78755a32c82925037478adc9b2b2e41d65f023b1").setNonce("736775398").setTimestamp("1502333968").setXml(xml);
        String decrypt = thirdService.decrypt(aesParams);
        System.out.println("========================\r\n" + decrypt);
    }

    @Test
    public void encrypt() throws Exception {


        String xml = "<xml> <ToUserName><![CDATA[ozy4qt5QUADNXORxCVipKMV9dss0]]></ToUserName> <FromUserName><![CDATA[gh_3c884a361561]]></FromUserName> <CreateTime>1502335639</CreateTime> <MsgType><![CDATA[text]]></MsgType> <Content><![CDATA[TESTCOMPONENT_MSG_TYPE_TEXT_callback]]></Content> </xml>";

        AESParams aesParams = new AESParams();
        aesParams.setToken("yirenyiche").setAppId("wx77ea274ef9f3e504").setEncodingAesKey("6o24ph2raAINvT45jKLeruT59sPsJ9QXCwXFXUK4Vhr").
                setMsgSignature("110aa6104615f4ba9b2489a13427f316549f8c39").setNonce("476758655").setTimestamp("1502335638").setXml(xml);
        String encrypt = thirdService.encrypt(aesParams);
        System.out.println("加密后====" + encrypt);

    }

}