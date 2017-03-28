package com.dudu.soa.wxd.test;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.dudu.soa.weixindubbo.module.ShopInfo;
import com.dudu.soa.weixindubbo.service.ShopInfoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by Administrator on 2017/3/28.
 */

public class ShopInfoTest extends TestBase{
    private static Logger logger = LoggerFactory.getLogger(ShopInfoTest.class);

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
