package com.dudu.soa.weixindubbo.electroniccoupon.mapper;

import com.dudu.soa.weixindubbo.electroniccoupon.module.ElectronicCoupon;

/**
 * 电子优惠券操作mapper
 *
 * @Author: 郑岭志
 * @Date: 2017年08月24 20:04
 */
public interface ElectronicCouponMapper {

    /**
     * 添加电子优惠券
     *
     * @param electronicCoupon electronicCoupon
     * @return Integer
     */
    Integer addCouponCode(ElectronicCoupon electronicCoupon);
}
