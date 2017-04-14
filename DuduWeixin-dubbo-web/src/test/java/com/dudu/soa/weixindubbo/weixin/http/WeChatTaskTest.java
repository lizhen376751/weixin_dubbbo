package com.dudu.soa.weixindubbo.weixin.http;

import com.dudu.soa.weixindubbo.weixin.base.AccessToken;
import com.dudu.soa.weixindubbo.weixin.module.Button;
import com.dudu.soa.weixindubbo.weixin.module.CommonButton;
import com.dudu.soa.weixindubbo.weixin.module.ComplexButton;
import com.dudu.soa.weixindubbo.weixin.module.Menu;
import com.dudu.soa.weixindubbo.weixin.module.OauthOpenIdToken;
import com.dudu.soa.wxd.test.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/4/14.
 */
public class WeChatTaskTest extends TestBase {


    @Autowired
    private WeChatTask weChatTask;

    //
    @Test
    public void getOauthAccessToken() throws Exception {
        OauthOpenIdToken oauthAccessToken = weChatTask.getOauthAccessToken("wxf0af72edbe855d28","fa12f20abeabc7c8ca3ebe777ceb2229","041IMCGG0yZ9oi2EeuIG0zzzGG0IMCGM");
        System.out.println("获取openid========================"+oauthAccessToken);
    }

    //生成菜单
    @Test
    public void createMenu() throws Exception {
        String COMMONURL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxd4e76e01e4a6e3b7&redirect_uri=http://218e6dd5.ngrok.io/oauthLoginServlet?lmcode=CS00";

        CommonButton btn11 = new CommonButton();
        btn11.setName("联盟卡包");
        btn11.setType("view");
        btn11.setUrl(COMMONURL + "_lmkInfo" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");

        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("车管家");
        mainBtn1.setSubbutton(new CommonButton[]{btn11});

        Menu menu = new Menu();
        menu.setButton(new Button[]{mainBtn1});
        System.out.println(menu.toString());
        weChatTask.createMenu("wxd4e76e01e4a6e3b7","dd1e044b9208d43a5a31238e5ee053c7",menu);
    }

    //获取开发者的token
    @Test
    public void getTokengetTicket() throws Exception {
        final AccessToken tokengetTicket = weChatTask.getTokengetTicket("wx4f66fde9d3bb2626", "dd1e044b9208d43a5a31238e5ee053c7");
        System.out.println("==========================" + tokengetTicket.toString());
    }

}