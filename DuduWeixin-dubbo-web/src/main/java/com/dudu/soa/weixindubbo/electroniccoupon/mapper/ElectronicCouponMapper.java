package com.dudu.soa.weixindubbo.electroniccoupon.mapper;

import com.dudu.soa.weixindubbo.electroniccoupon.module.ElectronicCoupon;
import com.dudu.soa.weixindubbo.electroniccoupon.module.ElectronicCouponParam;

import java.util.List;

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
     * @param electronicCouponList electronicCouponList
     * @return Integer
     */
    Integer addCouponCode(List<ElectronicCoupon> electronicCouponList);

    /**
     * 查询当天店铺所有产生的couponCode
     *
     * @param electronicCouponParam electronicCouponParam
     * @return Integer
     */
    Integer getCouponCountInshopOneDay(ElectronicCouponParam electronicCouponParam);

    /**
     * 微信客户优惠券统计
     *
     * @param electronicCouponParam electronicCouponParam
     * @return 优惠券数目
     */
    Integer getWeiXinConponCount(ElectronicCouponParam electronicCouponParam);
}
