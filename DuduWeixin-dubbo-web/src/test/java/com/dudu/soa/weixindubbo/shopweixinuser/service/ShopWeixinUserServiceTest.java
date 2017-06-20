package com.dudu.soa.weixindubbo.shopweixinuser.service;

import com.dudu.soa.weixindubbo.shopweixinuser.module.ShopWeixinUser;
import com.dudu.soa.wxd.test.TestBase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * Created by lizhen on 2017/5/4.
 */
public class ShopWeixinUserServiceTest extends TestBase {
    private static Logger log = LoggerFactory.getLogger(ShopWeixinUserServiceTest.class);
    @Autowired
    private ShopWeixinUserService shopWeixinUserService;

    @Test
    public void queryShopWeixinUser() throws Exception {

        ShopWeixinUser shopWeixinUser = new ShopWeixinUser();
        shopWeixinUser.setUserName("鲁A2032");
        shopWeixinUser.setShopcode("0533001");
        ArrayList<ShopWeixinUser> shopWeixinUsers = shopWeixinUserService.queryShopWeixinUser(shopWeixinUser);
        if (shopWeixinUsers.size() > 0) {
            log.info("查询结果=========================" + shopWeixinUsers.get(0).toString());
        }
    }

    @Test
    public void addShopWeixinUser() throws Exception {
        ShopWeixinUser shopWeixinUser = new ShopWeixinUser();
        shopWeixinUser.setUserName("鲁A2032")
                .setShopcode("0533001")
                .setMobile("18560042032");
        Integer integer = shopWeixinUserService.addShopWeixinUser(shopWeixinUser);
        log.info("查询结果=========================" + integer);
    }

    @Test
    public void updateShopWeixinUser() throws Exception {
        ShopWeixinUser shopWeixinUser = new ShopWeixinUser();
        shopWeixinUser.setUserName("鲁A2032")
                .setShopcode("0533001")
                .setMobile("18560042032")
               .setNickname("李振好")
                .setOpenId("djjdjjdjdj");
        Integer integer = shopWeixinUserService.updateShopWeixinUser(shopWeixinUser);
        log.info("查询结果=========================" + integer);

    }

    @Test
    public void deleteShopWeixinUser() throws Exception {

    }

}