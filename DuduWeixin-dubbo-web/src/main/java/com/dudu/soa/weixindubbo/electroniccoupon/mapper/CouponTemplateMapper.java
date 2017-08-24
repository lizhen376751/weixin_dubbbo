package com.dudu.soa.weixindubbo.electroniccoupon.mapper;

import com.dudu.soa.weixindubbo.electroniccoupon.module.ElectronicCoupon;
import com.dudu.soa.weixindubbo.electroniccoupon.module.ElectronicCouponParam;

import java.util.List;

/**
 * 电子优惠券模板mapper
 *
 * @Author: 郑岭志
 * @Date: 2017年08月24 10:32
 */
public interface CouponTemplateMapper {
    /**
     * 添加优惠券模板
     *
     * @param electronicCoupon electronicCoupon
     * @return 返回模板id
     */
    Integer addCouponTemplate(ElectronicCoupon electronicCoupon);

    /**
     * 修改电子优惠券模板
     *
     * @param electronicCoupon electronicCoupon
     * @return Integer
     */
    Integer updateCouponTemplate(ElectronicCoupon electronicCoupon);

    /**
     * 查询优惠券模板列表
     *
     * @param electronicCouponParam electronicCouponParam
     * @return List<ElectronicCoupon>
     */
    List<ElectronicCoupon> queryCouponTemplateList(ElectronicCouponParam electronicCouponParam);

    /**
     * 根据id查询电子优惠券模板
     *
     * @param couponId couponId
     * @return ElectronicCoupon
     */
    ElectronicCoupon getCouponById(int couponId);
}
