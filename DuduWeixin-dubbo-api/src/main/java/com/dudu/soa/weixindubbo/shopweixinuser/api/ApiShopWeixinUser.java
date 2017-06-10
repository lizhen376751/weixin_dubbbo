package com.dudu.soa.weixindubbo.shopweixinuser.api;

import com.dudu.soa.weixindubbo.shopweixinuser.module.ShopWeixinUser;

import java.util.ArrayList;

/**
 * 店管家微信用户的接口
 * Created by lizhen on 2017/3/29.
 */
public interface ApiShopWeixinUser {


    /**
     * 查询微信关注的用户
     *
     * @param shopWeixinUser 微信关注的实体
     * @return 微信的关注的集合 array list
     */
    ArrayList<ShopWeixinUser> queryShopWeixinUser(ShopWeixinUser shopWeixinUser);

    /**
     * 新增关注用户
     *
     * @param shopWeixinUser 微信关注用户的实体
     * @return 新增的条数 integer
     */
    Integer addShopWeixinUser(ShopWeixinUser shopWeixinUser);

    /**
     * 修改微信关注的实体
     *
     * @param shopWeixinUser 微信关注用户的实体
     * @return 修改的条数 integer
     */
    Integer updateShopWeixinUser(ShopWeixinUser shopWeixinUser);

    /**
     * 删除店管家微信关注用户
     *
     * @param shopWeixinUser 微信关注用户的实体
     * @return 修改的条数 integer
     */
    Integer deleteShopWeixinUser(ShopWeixinUser shopWeixinUser);
}
