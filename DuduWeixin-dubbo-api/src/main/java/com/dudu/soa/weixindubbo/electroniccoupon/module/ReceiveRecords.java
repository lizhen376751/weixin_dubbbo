package com.dudu.soa.weixindubbo.electroniccoupon.module;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 领取记录详情参数类
 *
 * @Author: 郑岭志
 * @Date: 2017年08月25 15:37
 */
public class ReceiveRecords implements Serializable {
    /**
     * 领取人
     */
    private String openId;
    /**
     * 领取人微信信息
     */
    private String weiXinUserName;
    /**
     * 领取时间
     */
    private String lingQuTime;
    /**
     * 领取优惠券code
     */
    private String couponCode;
    /**
     * 店铺编码
     */
    private String shopCode;
    /**
     * 可抵消金额
     */
    private BigDecimal diXiaoJinE;
    /**
     * 另需付费
     */
    private BigDecimal anotherJinE;
    /**
     * 优惠券名称
     */
    private String couponName;

    /**
     * ReceiveRecords(领取记录详情参数类) 字符串形式
     *
     * @return ReceiveRecords(领取记录详情参数类)字符串
     */
    @Override
    public String toString() {
        return "openId:" + openId + ",weiXinUserName:" + weiXinUserName + ",lingQuTime:" + lingQuTime + ",couponCode:" + couponCode + ",shopCode:" + shopCode
                + ",diXiaoJinE:" + diXiaoJinE + ",anotherJinE:" + anotherJinE + ",couponName:" + couponName;
    }

    /**
     * 获取 领取人
     *
     * @return openId 领取人
     */
    public String getOpenId() {
        return this.openId;
    }

    /**
     * 设置 领取人
     *
     * @param openId 领取人
     * @return 返回 ReceiveRecords(领取记录详情参数类)
     */
    public ReceiveRecords setOpenId(String openId) {
        this.openId = openId;
        return this;
    }

    /**
     * 获取 领取人微信信息
     *
     * @return weiXinUserName 领取人微信信息
     */
    public String getWeiXinUserName() {
        return this.weiXinUserName;
    }

    /**
     * 设置 领取人微信信息
     *
     * @param weiXinUserName 领取人微信信息
     * @return 返回 ReceiveRecords(领取记录详情参数类)
     */
    public ReceiveRecords setWeiXinUserName(String weiXinUserName) {
        this.weiXinUserName = weiXinUserName;
        return this;
    }

    /**
     * 获取 领取时间
     *
     * @return lingQuTime 领取时间
     */
    public String getLingQuTime() {
        return this.lingQuTime;
    }

    /**
     * 设置 领取时间
     *
     * @param lingQuTime 领取时间
     * @return 返回 ReceiveRecords(领取记录详情参数类)
     */
    public ReceiveRecords setLingQuTime(String lingQuTime) {
        this.lingQuTime = lingQuTime;
        return this;
    }

    /**
     * 获取 领取优惠券code
     *
     * @return couponCode 领取优惠券code
     */
    public String getCouponCode() {
        return this.couponCode;
    }

    /**
     * 设置 领取优惠券code
     *
     * @param couponCode 领取优惠券code
     * @return 返回 ReceiveRecords(领取记录详情参数类)
     */
    public ReceiveRecords setCouponCode(String couponCode) {
        this.couponCode = couponCode;
        return this;
    }

    /**
     * 获取 店铺编码
     *
     * @return shopCode 店铺编码
     */
    public String getShopCode() {
        return this.shopCode;
    }

    /**
     * 设置 店铺编码
     *
     * @param shopCode 店铺编码
     * @return 返回 ReceiveRecords(领取记录详情参数类)
     */
    public ReceiveRecords setShopCode(String shopCode) {
        this.shopCode = shopCode;
        return this;
    }

    /**
     * 获取 可抵消金额
     *
     * @return diXiaoJinE 可抵消金额
     */
    public BigDecimal getDiXiaoJinE() {
        return this.diXiaoJinE;
    }

    /**
     * 设置 可抵消金额
     *
     * @param diXiaoJinE 可抵消金额
     * @return 返回 ReceiveRecords(领取记录详情参数类)
     */
    public ReceiveRecords setDiXiaoJinE(BigDecimal diXiaoJinE) {
        this.diXiaoJinE = diXiaoJinE;
        return this;
    }

    /**
     * 获取 另需付费
     *
     * @return anotherJinE 另需付费
     */
    public BigDecimal getAnotherJinE() {
        return this.anotherJinE;
    }

    /**
     * 设置 另需付费
     *
     * @param anotherJinE 另需付费
     * @return 返回 ReceiveRecords(领取记录详情参数类)
     */
    public ReceiveRecords setAnotherJinE(BigDecimal anotherJinE) {
        this.anotherJinE = anotherJinE;
        return this;
    }

    /**
     * 获取 优惠券名称
     *
     * @return couponName 优惠券名称
     */
    public String getCouponName() {
        return this.couponName;
    }

    /**
     * 设置 优惠券名称
     *
     * @param couponName 优惠券名称
     * @return 返回 ReceiveRecords(领取记录详情参数类)
     */
    public ReceiveRecords setCouponName(String couponName) {
        this.couponName = couponName;
        return this;
    }
}
