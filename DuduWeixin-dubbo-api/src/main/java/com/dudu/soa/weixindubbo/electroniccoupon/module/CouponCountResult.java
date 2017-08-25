package com.dudu.soa.weixindubbo.electroniccoupon.module;

/**
 * 优惠券统计类
 * @Author: 郑岭志
 * @Date: 2017年08月25 11:53
 */
public class CouponCountResult {
    /**
     * 可转发数量
     */
    private Integer userNum;
    /**
     * 可使用数量
     */
    private Integer forwardNum;

    /**
     *  CouponCountResult(优惠券统计类) 字符串形式
     * @return CouponCountResult(优惠券统计类)字符串
     */
    @Override
    public String toString() {
        return "userNum:" + userNum + ",forwardNum:" + forwardNum;
    }

    /**
     * 获取 可转发数量
     * @return userNum 可转发数量
     */
    public Integer getUserNum() {
        return this.userNum;
    }

    /**
     * 设置 可转发数量
     * @param userNum 可转发数量
     * @return 返回 CouponCountResult(优惠券统计类)
     */
    public CouponCountResult setUserNum(Integer userNum) {
        this.userNum = userNum;
        return this;
    }

    /**
     * 获取 可使用数量
     * @return forwardNum 可使用数量
     */
    public Integer getForwardNum() {
        return this.forwardNum;
    }

    /**
     * 设置 可使用数量
     * @param forwardNum 可使用数量
     * @return 返回 CouponCountResult(优惠券统计类)
     */
    public CouponCountResult setForwardNum(Integer forwardNum) {
        this.forwardNum = forwardNum;
        return this;
    }
}
