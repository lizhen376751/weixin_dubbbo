package com.dudu.soa.weixindubbo.alipay.module;

import java.io.Serializable;

/**
 * Created by Shinelon on 2017/6/6.
 */
public class AlipayRequestModule implements Serializable {

    private String service = "create_direct_pay_by_user";

    private String partner = "";
    /**
     * 邮件
     */
    private String sellerEmail;
    /**
     * 编码
     */
    private String inputCharset;
    /**
     * 付款类型
     */
    private String payMentType="1";
    /**
     * 唤醒url
     */
    private String notifyUrl;
    /**
     * 返回url
     */
    private String returnUrl;
    /**
     * 单号
     */
    private String outTradeNo;
    /**
     * 项目名称
     */
    private String subject;
    /**
     * 费用
     */
    private String totalFee;

    private String body="";

    private String showUrl="";

    private String antiPhishingKey="";

    private String exterInvokeIp="";
    /**
     * 定义返回参数
     */
    private String extraCommonParam="";

    /**
     *  AlipayRequestModule(Created by Shinelon on 201766.) 字符串形式
     * @return AlipayRequestModule(Created by Shinelon on 201766.)字符串
     */
    @Override
    public String toString() {
        return "service:" + service + ",partner:" + partner + ",sellerEmail:" + sellerEmail + ",inputCharset:" + inputCharset + ",payMentType:" + payMentType
                + ",notifyUrl:" + notifyUrl + ",returnUrl:" + returnUrl + ",outTradeNo:" + outTradeNo + ",subject:" + subject + ",totalFee:" + totalFee
                + ",body:" + body + ",showUrl:" + showUrl + ",antiPhishingKey:" + antiPhishingKey + ",exterInvokeIp:" + exterInvokeIp + ",extraCommonParam:" + extraCommonParam;
    }

    public String getService() {
        return this.service;
    }

    public AlipayRequestModule setService(String service) {
        this.service = service;
        return this;
    }

    public String getPartner() {
        return this.partner;
    }

    public AlipayRequestModule setPartner(String partner) {
        this.partner = partner;
        return this;
    }

    /**
     * 获取 邮件
     * @return sellerEmail 邮件
     */
    public String getSellerEmail() {
        return this.sellerEmail;
    }

    /**
     * 设置 邮件
     * @param sellerEmail 邮件
     * @return 返回 AlipayRequestModule(Created by Shinelon on 201766.)
     */
    public AlipayRequestModule setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
        return this;
    }

    /**
     * 获取 编码
     * @return inputCharset 编码
     */
    public String getInputCharset() {
        return this.inputCharset;
    }

    /**
     * 设置 编码
     * @param inputCharset 编码
     * @return 返回 AlipayRequestModule(Created by Shinelon on 201766.)
     */
    public AlipayRequestModule setInputCharset(String inputCharset) {
        this.inputCharset = inputCharset;
        return this;
    }

    /**
     * 获取 付款类型
     * @return payMentType 付款类型
     */
    public String getPayMentType() {
        return this.payMentType;
    }

    /**
     * 设置 付款类型
     * @param payMentType 付款类型
     * @return 返回 AlipayRequestModule(Created by Shinelon on 201766.)
     */
    public AlipayRequestModule setPayMentType(String payMentType) {
        this.payMentType = payMentType;
        return this;
    }

    /**
     * 获取 唤醒url
     * @return notifyUrl 唤醒url
     */
    public String getNotifyUrl() {
        return this.notifyUrl;
    }

    /**
     * 设置 唤醒url
     * @param notifyUrl 唤醒url
     * @return 返回 AlipayRequestModule(Created by Shinelon on 201766.)
     */
    public AlipayRequestModule setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
        return this;
    }

    /**
     * 获取 返回url
     * @return returnUrl 返回url
     */
    public String getReturnUrl() {
        return this.returnUrl;
    }

    /**
     * 设置 返回url
     * @param returnUrl 返回url
     * @return 返回 AlipayRequestModule(Created by Shinelon on 201766.)
     */
    public AlipayRequestModule setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
        return this;
    }

    /**
     * 获取 单号
     * @return outTradeNo 单号
     */
    public String getOutTradeNo() {
        return this.outTradeNo;
    }

    /**
     * 设置 单号
     * @param outTradeNo 单号
     * @return 返回 AlipayRequestModule(Created by Shinelon on 201766.)
     */
    public AlipayRequestModule setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
        return this;
    }

    /**
     * 获取 项目名称
     * @return subject 项目名称
     */
    public String getSubject() {
        return this.subject;
    }

    /**
     * 设置 项目名称
     * @param subject 项目名称
     * @return 返回 AlipayRequestModule(Created by Shinelon on 201766.)
     */
    public AlipayRequestModule setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    /**
     * 获取 费用
     * @return totalFee 费用
     */
    public String getTotalFee() {
        return this.totalFee;
    }

    /**
     * 设置 费用
     * @param totalFee 费用
     * @return 返回 AlipayRequestModule(Created by Shinelon on 201766.)
     */
    public AlipayRequestModule setTotalFee(String totalFee) {
        this.totalFee = totalFee;
        return this;
    }

    public String getBody() {
        return this.body;
    }

    public AlipayRequestModule setBody(String body) {
        this.body = body;
        return this;
    }

    public String getShowUrl() {
        return this.showUrl;
    }

    public AlipayRequestModule setShowUrl(String showUrl) {
        this.showUrl = showUrl;
        return this;
    }

    public String getAntiPhishingKey() {
        return this.antiPhishingKey;
    }

    public AlipayRequestModule setAntiPhishingKey(String antiPhishingKey) {
        this.antiPhishingKey = antiPhishingKey;
        return this;
    }

    public String getExterInvokeIp() {
        return this.exterInvokeIp;
    }

    public AlipayRequestModule setExterInvokeIp(String exterInvokeIp) {
        this.exterInvokeIp = exterInvokeIp;
        return this;
    }

    /**
     * 获取 定义返回参数
     * @return extraCommonParam 定义返回参数
     */
    public String getExtraCommonParam() {
        return this.extraCommonParam;
    }

    /**
     * 设置 定义返回参数
     * @param extraCommonParam 定义返回参数
     * @return 返回 AlipayRequestModule(Created by Shinelon on 201766.)
     */
    public AlipayRequestModule setExtraCommonParam(String extraCommonParam) {
        this.extraCommonParam = extraCommonParam;
        return this;
    }
}
