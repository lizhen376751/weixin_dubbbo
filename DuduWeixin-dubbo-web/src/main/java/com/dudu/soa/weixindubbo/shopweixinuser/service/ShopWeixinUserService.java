package com.dudu.soa.weixindubbo.shopweixinuser.service;

import com.dudu.soa.weixindubbo.shopweixinuser.api.ApiShopWeixinUser;
import com.dudu.soa.weixindubbo.shopweixinuser.mapper.ShopWeixinUserDao;
import com.dudu.soa.weixindubbo.shopweixinuser.module.ShopWeixinUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

/**
 * 店管家微信的用户中心
 * Created by lizhen on 2017/3/29.
 */
@Service
public class ShopWeixinUserService implements ApiShopWeixinUser {
    /**
     * 引入dao层
     */
    @Autowired
    private ShopWeixinUserDao shopWeixinUserDao;

    /**
     * 查询微信关注的用户
     *
     * @param shopWeixinUser 微信关注的实体
     * @return 微信的关注的集合
     */
    @Override
    public ArrayList<ShopWeixinUser> queryShopWeixinUser(ShopWeixinUser shopWeixinUser) {
        return shopWeixinUserDao.queryShopWeixinUser(shopWeixinUser);
    }

    /**
     * 新增关注用户
     *
     * @param shopWeixinUser 微信关注用户的实体
     * @return 新增的条数
     */
    @Override
    @Transactional
    public Integer addShopWeixinUser(ShopWeixinUser shopWeixinUser) {
        return shopWeixinUserDao.addShopWeixinUser(shopWeixinUser);
    }

    /**
     * 修改微信关注的实体
     *
     * @param shopWeixinUser 微信关注用户的实体
     * @return 修改的条数
     */
    @Override
    @Transactional
    public Integer updateShopWeixinUser(ShopWeixinUser shopWeixinUser) {
        return shopWeixinUserDao.updateShopWeixinUser(shopWeixinUser);
    }

    /**
     * 删除店管家微信关注用户
     *
     * @param shopWeixinUser 微信关注用户的实体
     * @return 修改的条数
     */
    @Override
    @Transactional
    public Integer deleteShopWeixinUser(ShopWeixinUser shopWeixinUser) {
        return shopWeixinUserDao.deleteShopWeixinUser(shopWeixinUser);
    }
}
