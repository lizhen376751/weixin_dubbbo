package com.dudu.soa.weixindubbo.electroniccoupon.api;

import com.dudu.soa.weixindubbo.electroniccoupon.module.ElectronicCoupon;
import com.dudu.soa.weixindubbo.electroniccoupon.module.ElectronicCouponParam;

import java.util.List;

/**
 * 电子优惠券api接口
 *
 * @Author: 郑岭志
 * @Date: 2017年08月24 9:48
 */
public interface ApiElectronicCoupon {
    /**
     * 设置模板
     *
     * @param electronicCoupon electronicCoupon
     * @return 返回电子优惠券模板的id
     */
    Integer installCoupon(ElectronicCoupon electronicCoupon);

    /**
     * 查询优惠券模板列表
     *
     * @param electronicCouponParam electronicCouponParam
     * @return 返回优惠券模板列表
     */
    List<ElectronicCoupon> queryCouponList(ElectronicCouponParam electronicCouponParam);

    /**
     * 根据id获取电子优惠券模板
     *
     * @param electronicCouponParam electronicCoupon
     * @return ElectronicCoupon
     */
    ElectronicCoupon getCouponById(ElectronicCouponParam electronicCouponParam);

    /**
     * 更新电子优惠券
     *
     * @param electronicCoupon electronicCoupon
     * @return Integer
     */
    Integer updateElectronicCoupon(ElectronicCoupon electronicCoupon);


}
