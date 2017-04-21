package com.dudu.soa.weixindubbo.weixin.weixinconfig.service;

import com.dudu.soa.weixindubbo.weixin.weixinconfig.module.WeiXinConfig;
import com.dudu.soa.wxd.test.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lizhen on 2017/4/20.
 */

public class WeiXinConfigServiceTest extends TestBase{
    @Autowired
    private WeiXinConfigService weiXinConfigService;

    @Test
    public void getWeiXinConfig() throws Exception {
        try{
            WeiXinConfig cs000 = weiXinConfigService.getWeiXinConfig("lz000");
            System.out.println("获取实体类为================"+cs000.toString());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void addWeiXinConfig() throws Exception {
        try{
            WeiXinConfig weiXinConfig = new WeiXinConfig()
                    .setCode("LZ000")
                    .setAppid("wxd4e76e01e4a6e3b7")
                    .setAppserect("dd1e044b9208d43a5a31238e5ee053c7");
            Integer integer = weiXinConfigService.addWeiXinConfig(weiXinConfig);
            System.out.println("==================================="+integer);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void updateWeiXinConfig() throws Exception {
        try{
            WeiXinConfig weiXinConfig = new WeiXinConfig()
                    .setCode("CS000")
                    .setAppid("wxf0af72edbe855d28")
                    .setAppserect("fa12f20abeabc7c8ca3ebe777ceb2229");
            Integer integer = weiXinConfigService.updateWeiXinConfig(weiXinConfig);
            System.out.println("================"+integer);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void deleteWeiXinConfig() throws Exception {
        try{
        WeiXinConfig weiXinConfig = new WeiXinConfig()
                .setCode("CS000")
                .setAppid("wxf0af72edbe855d28")
                .setAppserect("fa12f20abeabc7c8ca3ebe777ceb2229");
            Integer integer = weiXinConfigService.deleteWeiXinConfig(weiXinConfig);
            System.out.println("================"+integer);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}