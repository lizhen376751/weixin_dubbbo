package com.dudu.soa.weixindubbo.electroniccoupon.module;

import java.io.Serializable;

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
     * ElectronicCoupon(电子优惠券实体类) 字符串形式
     *
     * @return ElectronicCoupon(电子优惠券实体类)字符串
     */
    @Override
    public String toString() {
        return "id:" + id;
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
}
