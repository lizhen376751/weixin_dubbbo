package com.dudu.soa.weixindubbo.mapper;


import com.dudu.soa.weixindubbo.module.ShopInfo;

/**
 * Created by Administrator on 2017/3/28.
 */

public interface ShopInfoDao {
    /**
     *
     * @param id 店铺代码
     * @return ShopInfo实体类
     */
    ShopInfo getShopInfo(String id);
}
