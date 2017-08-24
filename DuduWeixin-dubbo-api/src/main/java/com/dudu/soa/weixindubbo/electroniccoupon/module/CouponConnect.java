package com.dudu.soa.weixindubbo.electroniccoupon.module;

import java.io.Serializable;

/**
 * 优惠券和项目或商品关联表操作实体类
 *
 * @Author: 郑岭志
 * @Date: 2017年08月24 13:08
 */
public class CouponConnect implements Serializable {
    /**
     * id
     */
    private int id;
    /**
     * 优惠券模板id
     */
    private int couponId;
    /**
     * 项目或商品code
     */
    private String serviceCode;
    /**
     * 区分项目和商品
     */
    private String serviceFlag;
    /**
     * 店铺编码
     */
    private String shopCode;
    /**
     * 联盟编码
     */
    private String shopCodeLM;


    /**
     *  CouponConnect(优惠券和项目或商品关联表操作实体类) 字符串形式
     * @return CouponConnect(优惠券和项目或商品关联表操作实体类)字符串
     */
    @Override
    public String toString() {
        return "id:" + id + ",couponId:" + couponId + ",serviceCode:" + serviceCode + ",serviceFlag:" + serviceFlag + ",shopCode:" + shopCode + ",shopCodeLM:" + shopCodeLM;
    }

    /**
     * 获取 id
     * @return id id
     */
    public int getId() {
        return this.id;
    }

    /**
     * 设置 id
     * @param id id
     * @return 返回 CouponConnect(优惠券和项目或商品关联表操作实体类)
     */
    public CouponConnect setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 优惠券模板id
     * @return couponId 优惠券模板id
     */
    public int getCouponId() {
        return this.couponId;
    }

    /**
     * 设置 优惠券模板id
     * @param couponId 优惠券模板id
     * @return 返回 CouponConnect(优惠券和项目或商品关联表操作实体类)
     */
    public CouponConnect setCouponId(int couponId) {
        this.couponId = couponId;
        return this;
    }

    /**
     * 获取 项目或商品code
     * @return serviceCode 项目或商品code
     */
    public String getServiceCode() {
        return this.serviceCode;
    }

    /**
     * 设置 项目或商品code
     * @param serviceCode 项目或商品code
     * @return 返回 CouponConnect(优惠券和项目或商品关联表操作实体类)
     */
    public CouponConnect setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
        return this;
    }

    /**
     * 获取 区分项目和商品
     * @return serviceFlag 区分项目和商品
     */
    public String getServiceFlag() {
        return this.serviceFlag;
    }

    /**
     * 设置 区分项目和商品
     * @param serviceFlag 区分项目和商品
     * @return 返回 CouponConnect(优惠券和项目或商品关联表操作实体类)
     */
    public CouponConnect setServiceFlag(String serviceFlag) {
        this.serviceFlag = serviceFlag;
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
     * @return 返回 CouponConnect(优惠券和项目或商品关联表操作实体类)
     */
    public CouponConnect setShopCode(String shopCode) {
        this.shopCode = shopCode;
        return this;
    }

    /**
     * 获取 联盟编码
     * @return shopCodeLM 联盟编码
     */
    public String getShopCodeLM() {
        return this.shopCodeLM;
    }

    /**
     * 设置 联盟编码
     * @param shopCodeLM 联盟编码
     * @return 返回 CouponConnect(优惠券和项目或商品关联表操作实体类)
     */
    public CouponConnect setShopCodeLM(String shopCodeLM) {
        this.shopCodeLM = shopCodeLM;
        return this;
    }
}
