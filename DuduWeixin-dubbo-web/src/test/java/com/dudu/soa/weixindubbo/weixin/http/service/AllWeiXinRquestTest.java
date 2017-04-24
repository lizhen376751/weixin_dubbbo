package com.dudu.soa.weixindubbo.weixin.http.service;


import com.dudu.soa.weixindubbo.weixin.http.module.menu.Button;
import com.dudu.soa.weixindubbo.weixin.http.module.menu.CommonButton;
import com.dudu.soa.weixindubbo.weixin.http.module.menu.ComplexButton;
import com.dudu.soa.weixindubbo.weixin.http.module.menu.Menu;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.AccessToken;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.OauthOpenIdToken;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.WeiXinUserInfo;
import com.dudu.soa.wxd.test.TestBase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 微信基础通讯测试
 * Created by lizhen on 2017/4/22.
 */
public class AllWeiXinRquestTest extends TestBase {

    private static Logger log = LoggerFactory.getLogger(AllWeiXinRquestTest.class);
    @Autowired
    private AllWeiXinRquest allWeiXinRquest;

    //个人的测试账号生成菜单
    @Test
    public void liZhenMenu() throws Exception {
//        http://lizhen12.tunnel.2bdata.com
        String COMMONURL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxd4e76e01e4a6e3b7&redirect_uri=http://lizhen12.tunnel.2bdata.com/oauthLoginServlet?lmcode=FL000";

        CommonButton btn11 = new CommonButton();
        btn11.setName("联盟卡包");
        btn11.setType("view");
        btn11.setUrl(COMMONURL + "_lmkInfo" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");

        CommonButton btn12 = new CommonButton();
        btn12.setName("AHI指数");
        btn12.setType("view");
        btn12.setUrl(COMMONURL + "_AHIInfo" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");

        CommonButton btn13 = new CommonButton();
        btn13.setName("车辆保养");
        btn13.setType("view");
        btn13.setUrl(COMMONURL + "_baoYangList" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");

        CommonButton btn14 = new CommonButton();
        btn14.setName("消费记录");
        btn14.setType("view");
        btn14.setUrl(COMMONURL + "_xiaoFeiList" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");

        CommonButton btn15 = new CommonButton();
        btn15.setName("个人中心");
        btn15.setType("view");
        btn15.setUrl(COMMONURL + "_personalCenter" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");


        CommonButton btn21 = new CommonButton();
        btn21.setName("联盟介绍");
        btn21.setType("view");
        btn21.setUrl(COMMONURL + "_lianMengJieShao" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");

        CommonButton btn22 = new CommonButton();
        btn22.setName("服务导航");
        btn22.setType("view");
        btn22.setUrl(COMMONURL + "_daoHang" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");

        CommonButton btn23 = new CommonButton();
        btn23.setName("我的预约");
        btn23.setType("view");
        btn23.setUrl(COMMONURL + "_daoHang" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");

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

        CommonButton btn33 = new CommonButton();
        btn33.setName("车友会");
        btn33.setType("view");
        btn33.setUrl("http://wx.duduchewang.cn/weixincore/daoHang/service/daohangindex.jsp?shopcode=CS000&openid=oSsYXwMun4NrZE8b_OQi6kMaPyg4");

        CommonButton btn25 = new CommonButton();
        btn25.setName("快商通");
        btn25.setType("view");
        btn25.setUrl("http://kefu6.kuaishang.cn/bs/im.htm?cas=56463___619761&fi=58696&from=9");

        CommonButton btn35 = new CommonButton();
        btn35.setName("服务导航");
        btn35.setType("view");
        btn35.setUrl("http://4ec43db5.ngrok.io/fuwudaohang");

        CommonButton btn34 = new CommonButton();
        btn34.setName("退出账号");
        btn34.setType("view");
        btn34.setUrl(COMMONURL + "_logout" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");


        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("车管家");
        mainBtn1.setSubbutton(new CommonButton[]{btn11, btn12, btn15});

        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("服务");
        mainBtn2.setSubbutton(new CommonButton[]{btn21, btn33, btn24, btn25});

        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("活动123");
        mainBtn3.setSubbutton(new CommonButton[]{btn31, btn32, btn34});

        Menu menu = new Menu();
        menu.setButton(new Button[]{mainBtn1, mainBtn2, mainBtn3});
        allWeiXinRquest.createMenu(menu, "wxd4e76e01e4a6e3b7", "dd1e044b9208d43a5a31238e5ee053c7");
    }

    @Test
    public void duDuMenu() throws Exception {
        //wx.pre.duduchewang.cn
        String COMMONURL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxd4e76e01e4a6e3b7&redirect_uri=http://wx.pre.duduchewang.cn/oauthLoginServlet?lmcode=CS000";
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
        allWeiXinRquest.createMenu(menu, "wxf0af72edbe855d28", "fa12f20abeabc7c8ca3ebe777ceb2229");
    }

    //易璐邦账号生成菜单
    @Test
    public void yiLuBangMenu() throws Exception {
//        http://4ec43db5.ngrok.io
        String COMMONURL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx91ee3b29615c49c7&redirect_uri=http://wx.pre.duduchewang.cn/oauthLoginServlet?lmcode=FL000";

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
        CommonButton btn16 = new CommonButton();
        btn16.setName("服务客服");
        btn16.setType("view");
        btn16.setUrl("http://kefu6.kuaishang.cn/bs/im.htm?cas=56463___619761&fi=58696&ism=1");

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

        CommonButton btn25 = new CommonButton();
        btn25.setName("服务导航");
        btn25.setType("view");
        btn25.setUrl("http://wx.duduchewang.cn/weixincore/daoHang/service/daohangindex.jsp?shopcode=FL000" +
                "&openid=oSsYXwMun4NrZE8b_OQi6kMaPyg4");

        CommonButton btn26 = new CommonButton();
        btn26.setName("一键洗车");
        btn26.setType("view");
        btn26.setUrl("http://wx.duduchewang.cn/weixincore/daoHang/service/daohangindex.jsp?shopcode=FL000" +
                "&shopType_appoint=xc&openid=oSsYXwMun4NrZE8b_OQi6kMaPyg4");
        CommonButton btn27 = new CommonButton();
        btn27.setName("一键救援");
        btn27.setType("view");
        btn27.setUrl("http://wx-c.auto-sos.net/?sos_cid=791&sos_sig=5rHgU1");

        CommonButton btn31 = new CommonButton();
        btn31.setName("养车百科");
        btn31.setType("view");
        btn31.setUrl(COMMONURL + "_YCInfo" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");

        CommonButton btn32 = new CommonButton();
        btn32.setName("优惠促销");
        btn32.setType("view");
        btn32.setUrl(COMMONURL + "_lianMengActivity" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");


//        CommonButton btn35 = new CommonButton();
//        btn35.setName("服务导航");
//        btn35.setType("view");
//        btn35.setUrl("http://4ec43db5.ngrok.io/fuwudaohang");

        CommonButton btn34 = new CommonButton();
        btn34.setName("退出账号");
        btn34.setType("view");
        btn34.setUrl(COMMONURL + "_logout" + "&response_type=code&scope=snsapi_base&state=1#wechat_redirect");


        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("车管家");
        mainBtn1.setSubbutton(new CommonButton[]{btn11, btn12, btn16, btn15});

        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("服务");
        mainBtn2.setSubbutton(new CommonButton[]{btn21, btn25, btn26, btn27});

        ComplexButton mainBtn3 = new ComplexButton();
        mainBtn3.setName("活动");
        mainBtn3.setSubbutton(new CommonButton[]{btn31, btn32, btn34});

        Menu menu = new Menu();
        menu.setButton(new Button[]{mainBtn1, mainBtn2, mainBtn3});
        allWeiXinRquest.createMenu(menu, "wx91ee3b29615c49c7", "2e2a94909cf9fca29cccc111bf7896f5");
    }

    //配置验证
    @Test
    public void checkSignature() throws Exception {
        boolean b = allWeiXinRquest.checkSignature("signature", "timestamp", "nonce", "token");
        log.info("=====================================" + b);
    }

    //获取开发者的token
    @Test
    public void getTokengetTicket() throws Exception {
        try {
            AccessToken tokengetTicket = allWeiXinRquest.getTokengetTicket("wxd4e76e01e4a6e3b7", "dd1e044b9208d43a5a31238e5ee053c7");
            log.info("获取开发者的token==========================" + tokengetTicket.toString());
            System.out.println("获取开发者的token==========================" + tokengetTicket.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取openid以及网页授权的token
    @Test
    public void getOauthAccessToken() throws Exception {
        OauthOpenIdToken oauthAccessToken = allWeiXinRquest.getOauthAccessToken("041yWDoP0dffG92gsToP0cqyoP0yWDox", "wxd4e76e01e4a6e3b7", "dd1e044b9208d43a5a31238e5ee053c7");
        log.info("获取网页授权以及openid==========================" + oauthAccessToken.toString());
        System.out.println("获取网页授权以及openid==========================" + oauthAccessToken.toString());
    }

    //获取用户的基本信息
    @Test
    public void getWeiXinUserInfo() throws Exception {
        WeiXinUserInfo weiXinUserInfo = allWeiXinRquest.getWeiXinUserInfo("041yWHoa1Y6PdT1QMura1caioa1yWHoS", "wxd4e76e01e4a6e3b7", "dd1e044b9208d43a5a31238e5ee053c7");
        log.info("用户的别名为:==========================" + weiXinUserInfo);
    }
    @Test
    public void receivemessage() throws Exception {
//        allWeiXinRquest.receivemessage();
    }

}