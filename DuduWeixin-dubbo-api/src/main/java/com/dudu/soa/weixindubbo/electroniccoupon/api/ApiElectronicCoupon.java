package com.dudu.soa.weixindubbo.electroniccoupon.api;

import com.dudu.soa.weixindubbo.electroniccoupon.module.CouponCountResult;
import com.dudu.soa.weixindubbo.electroniccoupon.module.CouponTemplate;
import com.dudu.soa.weixindubbo.electroniccoupon.module.CouponTemplateParam;
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
     * @param couponTemplate couponTemplate
     * @return 返回电子优惠券模板的id
     */
    Integer installCoupon(CouponTemplate couponTemplate);

    /**
     * 查询优惠券模板列表
     *
     * @param couponTemplateParam couponTemplateParam
     * @return 返回优惠券模板列表
     */
    List<CouponTemplate> queryCouponList(CouponTemplateParam couponTemplateParam);

    /**
     * 根据id获取电子优惠券模板
     *
     * @param couponTemplateParam electronicCoupon
     * @return CouponTemplate
     */
    CouponTemplate getCouponById(CouponTemplateParam couponTemplateParam);

    /**
     * 更新电子优惠券
     *
     * @param couponTemplate couponTemplate
     * @return Integer
     */
    Integer updateElectronicCoupon(CouponTemplate couponTemplate);

    /**
     * 领取电子优惠券
     * @param electronicCoupon electronicCoupon
     * @return 电子优惠券id
     */
    Integer addCouponCode(ElectronicCoupon electronicCoupon);

    /**
     * 微信客户优惠券统计
     * @param electronicCouponParam electronicCouponParam
     * @return 可使用数量 可转发数量
     */
    CouponCountResult getWeiXinConponCount(ElectronicCouponParam electronicCouponParam);
}
