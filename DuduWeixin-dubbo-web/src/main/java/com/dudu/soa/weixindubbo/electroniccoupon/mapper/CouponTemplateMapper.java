package com.dudu.soa.weixindubbo.electroniccoupon.mapper;

import com.dudu.soa.weixindubbo.electroniccoupon.module.CouponTemplate;
import com.dudu.soa.weixindubbo.electroniccoupon.module.CouponTemplateParam;

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
     * @param couponTemplate couponTemplate
     * @return 返回模板id
     */
    Integer addCouponTemplate(CouponTemplate couponTemplate);

    /**
     * 修改电子优惠券模板
     *
     * @param couponTemplate couponTemplate
     * @return Integer
     */
    Integer updateCouponTemplate(CouponTemplate couponTemplate);

    /**
     * 查询优惠券模板列表
     *
     * @param couponTemplateParam couponTemplateParam
     * @return List<CouponTemplate>
     */
    List<CouponTemplate> queryCouponTemplateList(CouponTemplateParam couponTemplateParam);

    /**
     * 根据id查询电子优惠券模板
     *
     * @param couponId couponId
     * @return CouponTemplate
     */
    CouponTemplate getCouponById(int couponId);
}
