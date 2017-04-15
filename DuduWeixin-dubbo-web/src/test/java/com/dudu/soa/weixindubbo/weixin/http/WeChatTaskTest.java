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

    //个人的测试账号生成菜单
    @Test
    public void createMenu() throws Exception {
//        http://4ec43db5.ngrok.io
        String COMMONURL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxd4e76e01e4a6e3b7&redirect_uri=http://4ec43db5.ngrok.io/oauthLoginServlet?lmcode=CS000";

        CommonButton btn11 = new CommonButton();
        btn11.setName("联盟卡包");
        btn11.setType("view");
        btn11.setUrl(COMMONURL + "_lmkInfo" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");

        CommonButton btn12 = new CommonButton();
        btn12.setName("AHI指数");
        btn12.setType("view");
        btn12.setUrl(COMMONURL + "_AHIInfo" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");

//        CommonButton btn13 = new CommonButton();
//        btn13.setName("车辆保养");
//        btn13.setType("view");
//        btn13.setUrl(Constant.COMMONURL + "_baoYangList" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");
//
//        CommonButton btn14 = new CommonButton();
//        btn14.setName("消费记录");
//        btn14.setType("view");
//        btn14.setUrl(Constant.COMMONURL + "_xiaoFeiList" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");

        CommonButton btn15 = new CommonButton();
        btn15.setName("个人中心");
        btn15.setType("view");
        btn15.setUrl(COMMONURL + "_personalCenter" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");


        CommonButton btn21 = new CommonButton();
        btn21.setName("联盟介绍");
        btn21.setType("view");
        btn21.setUrl(COMMONURL + "_lianMengJieShao" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");
//
//        CommonButton btn22 = new CommonButton();
//        btn22.setName("服务导航");
//        btn22.setType("view");
//        btn22.setUrl(Constant.COMMONURL + "_daoHang" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");
//
//        CommonButton btn23 = new CommonButton();
//        btn23.setName("我的预约");
//        btn23.setType("view");
//        btn23.setUrl(Constant.COMMONURL + "_daoHang" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");

        CommonButton btn24 = new CommonButton();
        btn24.setName("车险投保");
        btn24.setType("view");
        btn24.setUrl(COMMONURL + "_cheXianTouBao" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");


        CommonButton btn31 = new CommonButton();
        btn31.setName("养车百科");
        btn31.setType("view");
        btn31.setUrl(COMMONURL + "_YCInfo" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");

        CommonButton btn32 = new CommonButton();
        btn32.setName("优惠促销");
        btn32.setType("view");
        btn32.setUrl(COMMONURL + "_lianMengActivity" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");

//        CommonButton btn33 = new CommonButton();
//        btn33.setName("车友会");
//        btn33.setType("view");
//        btn33.setUrl(Constant.COMMONURL + "_lianMengActivity" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");
//

        CommonButton btn34 = new CommonButton();
        btn34.setName("退出账号");
        btn34.setType("view");
        btn34.setUrl(COMMONURL + "_logout" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");


        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("车管家");
        mainBtn1.setSubbutton(new CommonButton[]{btn11, btn12, btn15});

        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("服务");
        mainBtn2.setSubbutton(new CommonButton[]{btn21, btn24});

        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("活动");
        mainBtn3.setSubbutton(new CommonButton[]{btn31, btn32, btn34});

        Menu menu = new Menu();
        menu.setButton(new Button[]{mainBtn1, mainBtn2, mainBtn3});
        weChatTask.createMenu("wxd4e76e01e4a6e3b7","dd1e044b9208d43a5a31238e5ee053c7",menu);
    }

    //获取开发者的token
    @Test
    public void getTokengetTicket() throws Exception {
        final AccessToken tokengetTicket = weChatTask.getTokengetTicket("wx4f66fde9d3bb2626", "dd1e044b9208d43a5a31238e5ee053c7");
        System.out.println("==========================" + tokengetTicket.toString());
    }

}