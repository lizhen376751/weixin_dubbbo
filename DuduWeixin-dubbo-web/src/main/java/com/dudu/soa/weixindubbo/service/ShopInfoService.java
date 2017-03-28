package com.dudu.soa.weixindubbo.service;

import com.dudu.soa.weixindubbo.api.ApiShopInfo;
import com.dudu.soa.weixindubbo.mapper.ShopInfoDao;
import com.dudu.soa.weixindubbo.module.ShopInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/3/28.
 */
@Service
public class ShopInfoService implements ApiShopInfo {
    /**
     * 注入dao层
     */
    @Autowired
    private ShopInfoDao shopInfoDao;
    @Override
    public ShopInfo getShopInfo(String shopcode) {
        return shopInfoDao.getShopInfo(shopcode);
    }
}
