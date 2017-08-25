package com.dudu.soa.weixindubbo.electroniccoupon.module;

import java.io.Serializable;
import java.util.Date;

/**
 * 电子优惠券实体类
 *
 * @Author: 郑岭志
 * @Date: 2017年08月24 19:38
 */
public class ElectronicCoupon implements Serializable {
    /**
     * 服务id
     */
    private int id;
    /**
     * 优惠券模板id
     */
    private Integer couponId;
    /**
     * 领取优惠券微信openId
     */
    private String openId;
    /**
     * 被领取优惠券微信openId
     */
    private String belongedOpenId;
    /**
     * 优惠券编码
     */
    private String couponCode;
    /**
     * 领取优惠券有效开始日期
     */
    private Date couponStartTime;
    /**
     * 领取的优惠券失效时间
     */
    private Date couponEndTime;
    /**
     * 优惠券状态:0:已失效,1:已领取 2:未领取
     */
    private String couponState;
    /**
     * 领取时间
     */
    private Date lingquTime;
    /**
     * 店铺编码
     */
    private String shopCode;
    /**
     * 店铺客户id
     */
    private Integer custId;
    /**
     * 优惠券标识(1可使用,0:可转发)
     */
    private Integer couponFlag;
    /**
     * 联盟编码
     */
    private String shopCodeLM;

    /**
     * ElectronicCoupon(电子优惠券实体类) 字符串形式
     *
     * @return ElectronicCoupon(电子优惠券实体类)字符串
     */
    @Override
    public String toString() {
        return "id:" + id + ",couponId:" + couponId + ",openId:" + openId + ",belongedOpenId:" + belongedOpenId + ",couponCode:" + couponCode + ",couponStartTime:" + couponStartTime
                + ",couponEndTime:" + couponEndTime + ",couponState:" + couponState + ",lingquTime:" + lingquTime + ",shopCode:" + shopCode + ",custId:" + custId
                + ",couponFlag:" + couponFlag + ",shopCodeLM:" + shopCodeLM;
    }

    /**
     * 获取 服务id
     *
     * @return id 服务id
     */
    public int getId() {
        return this.id;
    }

    /**
     * 设置 服务id
     *
     * @param id 服务id
     * @return 返回 ElectronicCoupon(电子优惠券实体类)
     */
    public ElectronicCoupon setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 优惠券模板id
     *
     * @return couponId 优惠券模板id
     */
    public Integer getCouponId() {
        return this.couponId;
    }

    /**
     * 设置 优惠券模板id
     *
     * @param couponId 优惠券模板id
     * @return 返回 ElectronicCoupon(电子优惠券实体类)
     */
    public ElectronicCoupon setCouponId(Integer couponId) {
        this.couponId = couponId;
        return this;
    }

    /**
     * 获取 领取优惠券微信openId
     *
     * @return openId 领取优惠券微信openId
     */
    public String getOpenId() {
        return this.openId;
    }

    /**
     * 设置 领取优惠券微信openId
     *
     * @param openId 领取优惠券微信openId
     * @return 返回 ElectronicCoupon(电子优惠券实体类)
     */
    public ElectronicCoupon setOpenId(String openId) {
        this.openId = openId;
        return this;
    }

    /**
     * 获取 被领取优惠券微信openId
     *
     * @return belongedOpenId 被领取优惠券微信openId
     */
    public String getBelongedOpenId() {
        return this.belongedOpenId;
    }

    /**
     * 设置 被领取优惠券微信openId
     *
     * @param belongedOpenId 被领取优惠券微信openId
     * @return 返回 ElectronicCoupon(电子优惠券实体类)
     */
    public ElectronicCoupon setBelongedOpenId(String belongedOpenId) {
        this.belongedOpenId = belongedOpenId;
        return this;
    }

    /**
     * 获取 优惠券编码
     *
     * @return couponCode 优惠券编码
     */
    public String getCouponCode() {
        return this.couponCode;
    }

    /**
     * 设置 优惠券编码
     *
     * @param couponCode 优惠券编码
     * @return 返回 ElectronicCoupon(电子优惠券实体类)
     */
    public ElectronicCoupon setCouponCode(String couponCode) {
        this.couponCode = couponCode;
        return this;
    }

    /**
     * 获取 领取优惠券有效开始日期
     *
     * @return couponStartTime 领取优惠券有效开始日期
     */
    public Date getCouponStartTime() {
        return this.couponStartTime;
    }

    /**
     * 设置 领取优惠券有效开始日期
     *
     * @param couponStartTime 领取优惠券有效开始日期
     * @return 返回 ElectronicCoupon(电子优惠券实体类)
     */
    public ElectronicCoupon setCouponStartTime(Date couponStartTime) {
        this.couponStartTime = couponStartTime;
        return this;
    }

    /**
     * 获取 领取的优惠券失效时间
     *
     * @return couponEndTime 领取的优惠券失效时间
     */
    public Date getCouponEndTime() {
        return this.couponEndTime;
    }

    /**
     * 设置 领取的优惠券失效时间
     *
     * @param couponEndTime 领取的优惠券失效时间
     * @return 返回 ElectronicCoupon(电子优惠券实体类)
     */
    public ElectronicCoupon setCouponEndTime(Date couponEndTime) {
        this.couponEndTime = couponEndTime;
        return this;
    }

    /**
     * 获取 优惠券状态:0:已失效1:已领取 2:未领取
     *
     * @return couponState 优惠券状态:0:已失效1:已领取 2:未领取
     */
    public String getCouponState() {
        return this.couponState;
    }

    /**
     * 设置 优惠券状态:0:已失效1:已领取 2:未领取
     *
     * @param couponState 优惠券状态:0:已失效1:已领取 2:未领取
     * @return 返回 ElectronicCoupon(电子优惠券实体类)
     */
    public ElectronicCoupon setCouponState(String couponState) {
        this.couponState = couponState;
        return this;
    }

    /**
     * 获取 领取时间
     *
     * @return lingquTime 领取时间
     */
    public Date getLingquTime() {
        return this.lingquTime;
    }

    /**
     * 设置 领取时间
     *
     * @param lingquTime 领取时间
     * @return 返回 ElectronicCoupon(电子优惠券实体类)
     */
    public ElectronicCoupon setLingquTime(Date lingquTime) {
        this.lingquTime = lingquTime;
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
     * @return 返回 ElectronicCoupon(电子优惠券实体类)
     */
    public ElectronicCoupon setShopCode(String shopCode) {
        this.shopCode = shopCode;
        return this;
    }

    /**
     * 获取 店铺客户id
     *
     * @return custId 店铺客户id
     */
    public Integer getCustId() {
        return this.custId;
    }

    /**
     * 设置 店铺客户id
     *
     * @param custId 店铺客户id
     * @return 返回 ElectronicCoupon(电子优惠券实体类)
     */
    public ElectronicCoupon setCustId(Integer custId) {
        this.custId = custId;
        return this;
    }

    /**
     * 获取 优惠券标识(1可使用0:可转发)
     *
     * @return couponFlag 优惠券标识(1可使用0:可转发)
     */
    public Integer getCouponFlag() {
        return this.couponFlag;
    }

    /**
     * 设置 优惠券标识(1可使用0:可转发)
     *
     * @param couponFlag 优惠券标识(1可使用0:可转发)
     * @return 返回 ElectronicCoupon(电子优惠券实体类)
     */
    public ElectronicCoupon setCouponFlag(Integer couponFlag) {
        this.couponFlag = couponFlag;
        return this;
    }

    /**
     * 获取 联盟编码
     *
     * @return shopCodeLM 联盟编码
     */
    public String getShopCodeLM() {
        return this.shopCodeLM;
    }

    /**
     * 设置 联盟编码
     *
     * @param shopCodeLM 联盟编码
     * @return 返回 ElectronicCoupon(电子优惠券实体类)
     */
    public ElectronicCoupon setShopCodeLM(String shopCodeLM) {
        this.shopCodeLM = shopCodeLM;
        return this;
    }
}
