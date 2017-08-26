package com.dudu.soa.weixindubbo.electroniccoupon.mapper;

import com.dudu.soa.weixindubbo.electroniccoupon.module.CouponConnect;

/**
 * 优惠券和项目或商品关联表操作
 *
 * @Author: 郑岭志
 * @Date: 2017年08月24 13:06
 */
public interface CouponConnectItem {

    /**
     * 添加优惠券和项目或商品的关联关系
     *
     * @param couponConnect couponConnect
     * @return Integer
     */
    Integer addConnectWithItem(CouponConnect couponConnect);

}
