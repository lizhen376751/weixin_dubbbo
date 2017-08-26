package com.dudu.soa.weixindubbo.electroniccoupon.module;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 优惠券详情实体类
 *
 * @Author: 郑岭志
 * @Date: 2017年08月25 15:59
 */
public class WeiXinCouponInfo implements Serializable {
    /**
     * 可抵消金额
     */
    private BigDecimal diXiaoJinE;
    /**
     * 另需付费
     */
    private BigDecimal anotherJinE;
    /**
     * 领取优惠券有效开始日期
     */
    private Date couponStartTime;
    /**
     * 领取的优惠券失效时间
     */
    private Date couponEndTime;
    /**
     * 优惠券编码
     */
    private String couponCode;
    /**
     * 使用详情
     */
    private String details;
    /**
     * 领取优惠券微信openId
     */
    private String openId;
    /**
     * 被领取优惠券微信openId
     */
    private String belongedOpenId;
    /**
     * 优惠券状态:0:已失效,1:已领取 2:未领取
     */
    private String couponState;
    /**
     * 店铺编码
     */
    private String shopCode;
    /**
     * 优惠券标识(1可使用,0:可转发)
     */
    private Integer couponFlag;
    /**
     * 优惠券名称
     */
    private String couponName;
    /**
     * 领取记录列表
     */
    private List<ReceiveRecords> list;
    /**
     * 图片路径
     */
    private String imageUrl;

    /**
     *  WeiXinCouponInfo(优惠券详情实体类) 字符串形式
     * @return WeiXinCouponInfo(优惠券详情实体类)字符串
     */
    @Override
    public String toString() {
        return "diXiaoJinE:" + diXiaoJinE + ",anotherJinE:" + anotherJinE + ",couponStartTime:" + couponStartTime + ",couponEndTime:" + couponEndTime
                + ",couponCode:" + couponCode + ",details:" + details + ",openId:" + openId + ",belongedOpenId:" + belongedOpenId + ",couponState:" + couponState
                + ",shopCode:" + shopCode + ",couponFlag:" + couponFlag + ",couponName:" + couponName + ",list:" + list + ",imageUrl:" + imageUrl;
    }

    /**
     * 获取 可抵消金额
     * @return diXiaoJinE 可抵消金额
     */
    public BigDecimal getDiXiaoJinE() {
        return this.diXiaoJinE;
    }

    /**
     * 设置 可抵消金额
     * @param diXiaoJinE 可抵消金额
     * @return 返回 WeiXinCouponInfo(优惠券详情实体类)
     */
    public WeiXinCouponInfo setDiXiaoJinE(BigDecimal diXiaoJinE) {
        this.diXiaoJinE = diXiaoJinE;
        return this;
    }

    /**
     * 获取 另需付费
     * @return anotherJinE 另需付费
     */
    public BigDecimal getAnotherJinE() {
        return this.anotherJinE;
    }

    /**
     * 设置 另需付费
     * @param anotherJinE 另需付费
     * @return 返回 WeiXinCouponInfo(优惠券详情实体类)
     */
    public WeiXinCouponInfo setAnotherJinE(BigDecimal anotherJinE) {
        this.anotherJinE = anotherJinE;
        return this;
    }

    /**
     * 获取 领取优惠券有效开始日期
     * @return couponStartTime 领取优惠券有效开始日期
     */
    public Date getCouponStartTime() {
        return this.couponStartTime;
    }

    /**
     * 设置 领取优惠券有效开始日期
     * @param couponStartTime 领取优惠券有效开始日期
     * @return 返回 WeiXinCouponInfo(优惠券详情实体类)
     */
    public WeiXinCouponInfo setCouponStartTime(Date couponStartTime) {
        this.couponStartTime = couponStartTime;
        return this;
    }

    /**
     * 获取 领取的优惠券失效时间
     * @return couponEndTime 领取的优惠券失效时间
     */
    public Date getCouponEndTime() {
        return this.couponEndTime;
    }

    /**
     * 设置 领取的优惠券失效时间
     * @param couponEndTime 领取的优惠券失效时间
     * @return 返回 WeiXinCouponInfo(优惠券详情实体类)
     */
    public WeiXinCouponInfo setCouponEndTime(Date couponEndTime) {
        this.couponEndTime = couponEndTime;
        return this;
    }

    /**
     * 获取 优惠券编码
     * @return couponCode 优惠券编码
     */
    public String getCouponCode() {
        return this.couponCode;
    }

    /**
     * 设置 优惠券编码
     * @param couponCode 优惠券编码
     * @return 返回 WeiXinCouponInfo(优惠券详情实体类)
     */
    public WeiXinCouponInfo setCouponCode(String couponCode) {
        this.couponCode = couponCode;
        return this;
    }

    /**
     * 获取 使用详情
     * @return details 使用详情
     */
    public String getDetails() {
        return this.details;
    }

    /**
     * 设置 使用详情
     * @param details 使用详情
     * @return 返回 WeiXinCouponInfo(优惠券详情实体类)
     */
    public WeiXinCouponInfo setDetails(String details) {
        this.details = details;
        return this;
    }

    /**
     * 获取 领取优惠券微信openId
     * @return openId 领取优惠券微信openId
     */
    public String getOpenId() {
        return this.openId;
    }

    /**
     * 设置 领取优惠券微信openId
     * @param openId 领取优惠券微信openId
     * @return 返回 WeiXinCouponInfo(优惠券详情实体类)
     */
    public WeiXinCouponInfo setOpenId(String openId) {
        this.openId = openId;
        return this;
    }

    /**
     * 获取 被领取优惠券微信openId
     * @return belongedOpenId 被领取优惠券微信openId
     */
    public String getBelongedOpenId() {
        return this.belongedOpenId;
    }

    /**
     * 设置 被领取优惠券微信openId
     * @param belongedOpenId 被领取优惠券微信openId
     * @return 返回 WeiXinCouponInfo(优惠券详情实体类)
     */
    public WeiXinCouponInfo setBelongedOpenId(String belongedOpenId) {
        this.belongedOpenId = belongedOpenId;
        return this;
    }

    /**
     * 获取 优惠券状态:0:已失效1:已领取 2:未领取
     * @return couponState 优惠券状态:0:已失效1:已领取 2:未领取
     */
    public String getCouponState() {
        return this.couponState;
    }

    /**
     * 设置 优惠券状态:0:已失效1:已领取 2:未领取
     * @param couponState 优惠券状态:0:已失效1:已领取 2:未领取
     * @return 返回 WeiXinCouponInfo(优惠券详情实体类)
     */
    public WeiXinCouponInfo setCouponState(String couponState) {
        this.couponState = couponState;
        return this;
    }

    /**
     * 获取 店铺编码
     * @return shopCode 店铺编码
     */
    public String getShopCode() {
        return this.shopCode;
    }

    /**
     * 设置 店铺编码
     * @param shopCode 店铺编码
     * @return 返回 WeiXinCouponInfo(优惠券详情实体类)
     */
    public WeiXinCouponInfo setShopCode(String shopCode) {
        this.shopCode = shopCode;
        return this;
    }

    /**
     * 获取 优惠券标识(1可使用0:可转发)
     * @return couponFlag 优惠券标识(1可使用0:可转发)
     */
    public Integer getCouponFlag() {
        return this.couponFlag;
    }

    /**
     * 设置 优惠券标识(1可使用0:可转发)
     * @param couponFlag 优惠券标识(1可使用0:可转发)
     * @return 返回 WeiXinCouponInfo(优惠券详情实体类)
     */
    public WeiXinCouponInfo setCouponFlag(Integer couponFlag) {
        this.couponFlag = couponFlag;
        return this;
    }

    /**
     * 获取 优惠券名称
     * @return couponName 优惠券名称
     */
    public String getCouponName() {
        return this.couponName;
    }

    /**
     * 设置 优惠券名称
     * @param couponName 优惠券名称
     * @return 返回 WeiXinCouponInfo(优惠券详情实体类)
     */
    public WeiXinCouponInfo setCouponName(String couponName) {
        this.couponName = couponName;
        return this;
    }

    /**
     * 获取 领取记录列表
     * @return list 领取记录列表
     */
    public List<ReceiveRecords> getList() {
        return this.list;
    }

    /**
     * 设置 领取记录列表
     * @param list 领取记录列表
     * @return 返回 WeiXinCouponInfo(优惠券详情实体类)
     */
    public WeiXinCouponInfo setList(List<ReceiveRecords> list) {
        this.list = list;
        return this;
    }

    /**
     * 获取 图片路径
     * @return imageUrl 图片路径
     */
    public String getImageUrl() {
        return this.imageUrl;
    }

    /**
     * 设置 图片路径
     * @param imageUrl 图片路径
     * @return 返回 WeiXinCouponInfo(优惠券详情实体类)
     */
    public WeiXinCouponInfo setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
