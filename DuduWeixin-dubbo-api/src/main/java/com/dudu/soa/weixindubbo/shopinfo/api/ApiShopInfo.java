package com.dudu.soa.weixindubbo.shopinfo.api;

import com.dudu.soa.weixindubbo.shopinfo.module.ShopInfo;

/**
 * 店铺信息接口
 **/
public interface ApiShopInfo {
    /**
     *@param  shopcode 店铺代码
     * @return ShopInfo店铺实体信息
     */
     ShopInfo getShopInfo(String shopcode);
}
