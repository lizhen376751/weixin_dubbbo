package com.dudu.soa.weixindubbo.third.service;

import com.dudu.soa.framework.cache.RedisUtil;
import com.dudu.soa.weixindubbo.third.module.AESParams;
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
public class ThirdServiceTest extends TestBase{
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
    @Test
    public void getComponentAccessToken() throws Exception {
        String sendPost = "{\"authorization_info\":{\"authorizer_appid\":\"wx570bc396a51b8ff8\",\"authorizer_access_token\":\"g773VasgZfOu_bYrbbPNjpRTxSIwAMDFYpODWaGfQW6xwgBprLj_U6ZiNayyilv2ewmt35fKo3byPJOututQ9tPkQ06ieeSNd0wazbz3XcmnnZw8hW2pvEXwjWGElubXJGJbAIDAXA\",\"expires_in\":7200,\"authorizer_refresh_token\":\"refreshtoken@@@8nBUHdj9hKazGwk4BOQoC6l-97b4FeuXZxGuIGgTMX4\",\"func_info\":[{\"funcscope_category\":{\"id\":1}},{\"funcscope_category\":{\"id\":15}},{\"funcscope_category\":{\"id\":4}},{\"funcscope_category\":{\"id\":7}},{\"funcscope_category\":{\"id\":2}},{\"funcscope_category\":{\"id\":3}},{\"funcscope_category\":{\"id\":11}},{\"funcscope_category\":{\"id\":6}},{\"funcscope_category\":{\"id\":5}},{\"funcscope_category\":{\"id\":8}},{\"funcscope_category\":{\"id\":13}},{\"funcscope_category\":{\"id\":9}},{\"funcscope_category\":{\"id\":10}},{\"funcscope_category\":{\"id\":12}},{\"funcscope_category\":{\"id\":22}},{\"funcscope_category\":{\"id\":23}},{\"funcscope_category\":{\"id\":24},\"confirm_info\":{\"need_confirm\":0,\"already_confirm\":0,\"can_confirm\":0}},{\"funcscope_category\":{\"id\":26}}]}}";
        String authorizationInfo1 = allWeiXinService.pareJsonDate(sendPost, "authorization_info");
        String authorizerAppid = allWeiXinService.pareJsonDate(authorizationInfo1, "authorizer_appid");
        String authorizerAccessToken = allWeiXinService.pareJsonDate(authorizationInfo1, "authorizer_access_token");
        String expiresIn = allWeiXinService.pareJsonDate(authorizationInfo1, "expires_in");
        String authorizerRefreshToken = allWeiXinService.pareJsonDate(authorizationInfo1, "authorizer_refresh_token");
        String funcInfo = allWeiXinService.pareJsonDate(authorizationInfo1, "func_info");
        String sss = "[{\"funcscope_category\":{\"id\":1}},{\"funcscope_category\":{\"id\":15}},{\"funcscope_category\":{\"id\":4}},{\"funcscope_category\":{\"id\":7}},{\"funcscope_category\":{\"id\":2}},{\"funcscope_category\":{\"id\":3}},{\"funcscope_category\":{\"id\":11}},{\"funcscope_category\":{\"id\":6}},{\"funcscope_category\":{\"id\":5}},{\"funcscope_category\":{\"id\":8}},{\"funcscope_category\":{\"id\":13}},{\"funcscope_category\":{\"id\":9}},{\"funcscope_category\":{\"id\":10}},{\"funcscope_category\":{\"id\":12}},{\"funcscope_category\":{\"id\":22}},{\"funcscope_category\":{\"id\":23}},{\"funcscope_category\":{\"id\":24},\"confirm_info\":{\"need_confirm\":0,\"can_confirm\":0,\"already_confirm\":0}},{\"funcscope_category\":{\"id\":26}}]";

    }

    @Autowired
    private ThirdService thirdService;
    @Test
    public void decrypt() throws Exception {
        String xml = "<xml>    <ToUserName><![CDATA[wx77ea274ef9f3e504]]></ToUserName>    <Encrypt><![CDATA[SAwCUX03UxOEmLr/oc4mu086kjN/0BB7Is6Jb1G2gAVea+E9zQSEv9al5vgjLYXFXnAK/3WS/1ZCurUsJ8DtM7I/cM48G+M9doED9rGDYNGAuwRYcdNGgyOZO1A3en5PRDBa2rQr4dx66b28wYUWINEif0o9X808M5+tMewyXu275T+ewKbLmrctOAUDVFWnFsCbEtm1rkDaoKqk9+5lCh1Qnwlzb2BLTZ3oJKrTkAvNCytSgSvt8+H6OMVNr0oRdeWwlTKnmS1mRiJHBQ7wL4SZDnGZwmOty7wUvY96ad55eMNT12dIi4Q3E+Pb3GYAz8XyUuYI9oVe2DlHq51RcaTmtYAQpnjLMlXIlNNObXRqPplGIWf7N64ridEx24y5LQt2IY8ClmFZppL/LUZ9sOdArNrN9IJIzub4DzCCUWmCjKBbH1rAi0lMcPvj1ta+mpXfNHbiNcYKHQTQp7+3Jg==]]></Encrypt></xml>";

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
                System.out.println("+++"+toUserName);
            } catch (DocumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        AESParams aesParams = new AESParams();
        aesParams.setToken("yirenyiche").setAppId("wx77ea274ef9f3e504").setEncodingAesKey("6o24ph2raAINvT45jKLeruT59sPsJ9QXCwXFXUK4Vhr").
                setMsgSignature("8889bed16290511562c2081b4137e13e19bf7719").setNonce("439701149").setTimestamp("1501996049").setXml(xml);
        String decrypt = thirdService.decrypt(aesParams);
        System.out.println("========================"+decrypt);
    }

}