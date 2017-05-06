package com.dudu.soa.weixindubbo.shopinfo.service;


import com.dudu.soa.weixindubbo.shopinfo.module.ShopInfo;
import com.dudu.soa.wxd.test.TestBase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lizhen on 2017/5/5.
 */

public class ShopInfoServiceTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger(ShopInfoServiceTest.class);

    @Autowired
    private ShopInfoService shopInfoService;
    @Test
    public void getShopInfo(){
        try{
            ShopInfo shopInfo = shopInfoService.getShopInfo("0533001");
            logger.info("测试==========================================="+shopInfo.toString());
        }catch (Exception e){
            logger.debug("=====================报错======================");
            e.printStackTrace();
        }

    }
}