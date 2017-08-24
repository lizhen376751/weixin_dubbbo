package com.dudu.soa.weixindubbo.electroniccoupon.module;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 电子优惠券参数类
 *
 * @Author: 郑岭志
 * @Date: 2017年08月24 14:21
 */
public class CouponTemplateParam implements Serializable {
    /**
     * 优惠券id
     */
    private int couponId;
    /**
     * 优惠券名称
     */
    private String couponName;
    /**
     * 店铺编码
     */
    private String shopCode;
    /**
     * 使用详情
     */
    private String details;
    /**
     * 创建该券人名称
     */
    private String createUser;
    /**
     * 优惠券有效开始时间
     */
    private Date validStartTime;
    /**
     * 优惠券失效时间
     */
    private Date validEndTime;
    /**
     * 可使用数量
     */
    private int usedNum;
    /**
     * 可转发数量
     */
    private int forwardedNum;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 可抵消金额
     */
    private BigDecimal diXiaoJinE;
    /**
     * 另需付费
     */
    private BigDecimal anotherJinE;
    /**
     * 图片
     */
    private String imageCode;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 修改人人
     */
    private String updateUser;
    /**
     * 1为正常使用,0为作废
     */
    private Integer state;
    /**
     * 联盟编码
     */
    private String shopCodeLM;
    /**
     * 商品或项目编码
     */
    private String serviceCode;
    /**
     * 项目和商品标识(1为项目,0为商品)
     */
    private String serviceFlag;
    /**
     * 查询开始时间
     */
    private Date queryStartTime;
    /**
     * 查询结束时间
     */
    private Date queryEndTime;

    /**
     * CouponTemplateParam(电子优惠券参数类) 字符串形式
     *
     * @return CouponTemplateParam(电子优惠券参数类)字符串
     */
    @Override
    public String toString() {
        return "couponId:" + couponId + ",couponName:" + couponName + ",shopCode:" + shopCode + ",details:" + details + ",createUser:" + createUser
                + ",validStartTime:" + validStartTime + ",validEndTime:" + validEndTime + ",usedNum:" + usedNum + ",forwardedNum:" + forwardedNum
                + ",createTime:" + createTime + ",diXiaoJinE:" + diXiaoJinE + ",anotherJinE:" + anotherJinE + ",imageCode:" + imageCode + ",updateTime:" + updateTime
                + ",updateUser:" + updateUser + ",state:" + state + ",shopCodeLM:" + shopCodeLM + ",serviceCode:" + serviceCode + ",serviceFlag:" + serviceFlag
                + ",queryStartTime:" + queryStartTime + ",queryEndTime:" + queryEndTime;
    }

    /**
     * 获取 优惠券id
     *
     * @return couponId 优惠券id
     */
    public int getCouponId() {
        return this.couponId;
    }

    /**
     * 设置 优惠券id
     *
     * @param couponId 优惠券id
     * @return 返回 CouponTemplateParam(电子优惠券参数类)
     */
    public CouponTemplateParam setCouponId(int couponId) {
        this.couponId = couponId;
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
     * @return 返回 CouponTemplateParam(电子优惠券参数类)
     */
    public CouponTemplateParam setCouponName(String couponName) {
        this.couponName = couponName;
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
     * @return 返回 CouponTemplateParam(电子优惠券参数类)
     */
    public CouponTemplateParam setShopCode(String shopCode) {
        this.shopCode = shopCode;
        return this;
    }

    /**
     * 获取 使用详情
     *
     * @return details 使用详情
     */
    public String getDetails() {
        return this.details;
    }

    /**
     * 设置 使用详情
     *
     * @param details 使用详情
     * @return 返回 CouponTemplateParam(电子优惠券参数类)
     */
    public CouponTemplateParam setDetails(String details) {
        this.details = details;
        return this;
    }

    /**
     * 获取 创建该券人名称
     *
     * @return createUser 创建该券人名称
     */
    public String getCreateUser() {
        return this.createUser;
    }

    /**
     * 设置 创建该券人名称
     *
     * @param createUser 创建该券人名称
     * @return 返回 CouponTemplateParam(电子优惠券参数类)
     */
    public CouponTemplateParam setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    /**
     * 获取 优惠券有效开始时间
     *
     * @return validStartTime 优惠券有效开始时间
     */
    public Date getValidStartTime() {
        return this.validStartTime;
    }

    /**
     * 设置 优惠券有效开始时间
     *
     * @param validStartTime 优惠券有效开始时间
     * @return 返回 CouponTemplateParam(电子优惠券参数类)
     */
    public CouponTemplateParam setValidStartTime(Date validStartTime) {
        this.validStartTime = validStartTime;
        return this;
    }

    /**
     * 获取 优惠券失效时间
     *
     * @return validEndTime 优惠券失效时间
     */
    public Date getValidEndTime() {
        return this.validEndTime;
    }

    /**
     * 设置 优惠券失效时间
     *
     * @param validEndTime 优惠券失效时间
     * @return 返回 CouponTemplateParam(电子优惠券参数类)
     */
    public CouponTemplateParam setValidEndTime(Date validEndTime) {
        this.validEndTime = validEndTime;
        return this;
    }

    /**
     * 获取 可使用数量
     *
     * @return usedNum 可使用数量
     */
    public int getUsedNum() {
        return this.usedNum;
    }

    /**
     * 设置 可使用数量
     *
     * @param usedNum 可使用数量
     * @return 返回 CouponTemplateParam(电子优惠券参数类)
     */
    public CouponTemplateParam setUsedNum(int usedNum) {
        this.usedNum = usedNum;
        return this;
    }

    /**
     * 获取 可转发数量
     *
     * @return forwardedNum 可转发数量
     */
    public int getForwardedNum() {
        return this.forwardedNum;
    }

    /**
     * 设置 可转发数量
     *
     * @param forwardedNum 可转发数量
     * @return 返回 CouponTemplateParam(电子优惠券参数类)
     */
    public CouponTemplateParam setForwardedNum(int forwardedNum) {
        this.forwardedNum = forwardedNum;
        return this;
    }

    /**
     * 获取 创建时间
     *
     * @return createTime 创建时间
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 设置 创建时间
     *
     * @param createTime 创建时间
     * @return 返回 CouponTemplateParam(电子优惠券参数类)
     */
    public CouponTemplateParam setCreateTime(Date createTime) {
        this.createTime = createTime;
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
     * @return 返回 CouponTemplateParam(电子优惠券参数类)
     */
    public CouponTemplateParam setDiXiaoJinE(BigDecimal diXiaoJinE) {
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
     * @return 返回 CouponTemplateParam(电子优惠券参数类)
     */
    public CouponTemplateParam setAnotherJinE(BigDecimal anotherJinE) {
        this.anotherJinE = anotherJinE;
        return this;
    }

    /**
     * 获取 图片
     *
     * @return imageCode 图片
     */
    public String getImageCode() {
        return this.imageCode;
    }

    /**
     * 设置 图片
     *
     * @param imageCode 图片
     * @return 返回 CouponTemplateParam(电子优惠券参数类)
     */
    public CouponTemplateParam setImageCode(String imageCode) {
        this.imageCode = imageCode;
        return this;
    }

    /**
     * 获取 修改时间
     *
     * @return updateTime 修改时间
     */
    public Date getUpdateTime() {
        return this.updateTime;
    }

    /**
     * 设置 修改时间
     *
     * @param updateTime 修改时间
     * @return 返回 CouponTemplateParam(电子优惠券参数类)
     */
    public CouponTemplateParam setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    /**
     * 获取 修改人人
     *
     * @return updateUser 修改人人
     */
    public String getUpdateUser() {
        return this.updateUser;
    }

    /**
     * 设置 修改人人
     *
     * @param updateUser 修改人人
     * @return 返回 CouponTemplateParam(电子优惠券参数类)
     */
    public CouponTemplateParam setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
        return this;
    }

    /**
     * 获取 1为正常使用0为作废
     *
     * @return state 1为正常使用0为作废
     */
    public Integer getState() {
        return this.state;
    }

    /**
     * 设置 1为正常使用0为作废
     *
     * @param state 1为正常使用0为作废
     * @return 返回 CouponTemplateParam(电子优惠券参数类)
     */
    public CouponTemplateParam setState(Integer state) {
        this.state = state;
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
     * @return 返回 CouponTemplateParam(电子优惠券参数类)
     */
    public CouponTemplateParam setShopCodeLM(String shopCodeLM) {
        this.shopCodeLM = shopCodeLM;
        return this;
    }

    /**
     * 获取 商品或项目编码
     *
     * @return serviceCode 商品或项目编码
     */
    public String getServiceCode() {
        return this.serviceCode;
    }

    /**
     * 设置 商品或项目编码
     *
     * @param serviceCode 商品或项目编码
     * @return 返回 CouponTemplateParam(电子优惠券参数类)
     */
    public CouponTemplateParam setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
        return this;
    }

    /**
     * 获取 项目和商品标识(1为项目0为商品)
     *
     * @return serviceFlag 项目和商品标识(1为项目0为商品)
     */
    public String getServiceFlag() {
        return this.serviceFlag;
    }

    /**
     * 设置 项目和商品标识(1为项目0为商品)
     *
     * @param serviceFlag 项目和商品标识(1为项目0为商品)
     * @return 返回 CouponTemplateParam(电子优惠券参数类)
     */
    public CouponTemplateParam setServiceFlag(String serviceFlag) {
        this.serviceFlag = serviceFlag;
        return this;
    }

    /**
     * 获取 查询开始时间
     *
     * @return queryStartTime 查询开始时间
     */
    public Date getQueryStartTime() {
        return this.queryStartTime;
    }

    /**
     * 设置 查询开始时间
     *
     * @param queryStartTime 查询开始时间
     * @return 返回 CouponTemplateParam(电子优惠券参数类)
     */
    public CouponTemplateParam setQueryStartTime(Date queryStartTime) {
        this.queryStartTime = queryStartTime;
        return this;
    }

    /**
     * 获取 查询结束时间
     *
     * @return queryEndTime 查询结束时间
     */
    public Date getQueryEndTime() {
        return this.queryEndTime;
    }

    /**
     * 设置 查询结束时间
     *
     * @param queryEndTime 查询结束时间
     * @return 返回 CouponTemplateParam(电子优惠券参数类)
     */
    public CouponTemplateParam setQueryEndTime(Date queryEndTime) {
        this.queryEndTime = queryEndTime;
        return this;
    }
}
