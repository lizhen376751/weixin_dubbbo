package com.dudu.soa.weixindubbo.module;

import java.io.Serializable;

/**
 * 店铺信息
 */
public class ShopInfo implements Serializable {
    /**
     * shopcode
     */
    private String id;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     *
     */
    private String lat;
    /**
     *
     */
    private String lon;
    /**
     *
     */
    private String state;
    /**
     * 地址
     */
    private String address;
    /**
     * 城市区号
     */
    private String city;
    /**
     * 电话
     */
    private String tel;
    /**
     * 手机
     */
    private String mobile;
    /**
     *
     */
    private String serviceContent;
    /**
     *
     */
    private Float hardware;
    /**
     *
     */
    private Float environment;
    /**
     *
     */
    private Float artificer;
    /**
     *
     */
    private Float service;
    /**
     * 店铺介绍
     */
    private String introduction;
    /**
     * 图片
     */
    private String imgListView;
    /**
     *
     */
    private String imgBig;
    /**
     * 图片介绍
     */
    private String imgIntroduct;
    /**
     *
     */
    private String shopStrength;
    /**
     * 人气
     */
    private int renqi;
    /**
     * 评价
     */
    private int pingjia;
    /**
     * 微信token
     */
    private String wXtoken;
    /**
     * 微信wXAppId
     */
    private String wXAppId;
    /**
     *
     */
    private String wXAppSecret;
    /**
     * 欢迎图片
     */
    private String welcomeImg;
    /**
     * 欢迎文字
     */
    private String welcomeTxt;
    /**
     * 路径
     */
    private String url;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return shopName
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * @param shopName shopName
     */
    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    /**
     * @return lat
     */
    public String getLat() {
        return lat;
    }

    /**
     * @param lat lat
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * @return lon
     */
    public String getLon() {
        return lon;
    }

    /**
     * @param lon lon
     */
    public void setLon(String lon) {
        this.lon = lon;
    }

    /**
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return serviceContent
     */
    public String getServiceContent() {
        return serviceContent;
    }

    /**
     * @param serviceContent serviceContent
     */
    public void setServiceContent(String serviceContent) {
        this.serviceContent = serviceContent;
    }

    /**
     * @return hardware
     */
    public Float getHardware() {
        return hardware;
    }

    /**
     * @param hardware hardware
     */
    public void setHardware(Float hardware) {
        this.hardware = hardware;
    }

    /**
     * @return environment
     */
    public Float getEnvironment() {
        return environment;
    }

    /**
     * @param environment environment
     */
    public void setEnvironment(Float environment) {
        this.environment = environment;
    }

    /**
     * @return artificer
     */
    public Float getArtificer() {
        return artificer;
    }

    /**
     * @param artificer artificer
     */
    public void setArtificer(Float artificer) {
        this.artificer = artificer;
    }

    /**
     * @return service
     */
    public Float getService() {
        return service;
    }

    /**
     * @param service service
     */
    public void setService(Float service) {
        this.service = service;
    }

    /**
     * @return introduction
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * @param introduction introduction
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * @return imgListView
     */
    public String getImgListView() {
        return imgListView;
    }

    /**
     * @param imgListView imgListView
     */
    public void setImgListView(String imgListView) {
        this.imgListView = imgListView;
    }

    /**
     * @return imgBig
     */
    public String getImgBig() {
        return imgBig;
    }

    /**
     * @param imgBig imgBig
     */
    public void setImgBig(String imgBig) {
        this.imgBig = imgBig;
    }

    /**
     * @return imgIntroduct
     */
    public String getImgIntroduct() {
        return imgIntroduct;
    }

    /**
     * @param imgIntroduct imgIntroduct
     */
    public void setImgIntroduct(String imgIntroduct) {
        this.imgIntroduct = imgIntroduct;
    }

    /**
     * @return shopStrength
     */
    public String getShopStrength() {
        return shopStrength;
    }

    /**
     * @param shopStrength shopStrength
     */
    public void setShopStrength(String shopStrength) {
        this.shopStrength = shopStrength;
    }

    /**
     * @return renqi
     */
    public int getRenqi() {
        return renqi;
    }

    /**
     * @param renqi renqi
     */
    public void setRenqi(int renqi) {
        this.renqi = renqi;
    }

    /**
     * @return pingjia
     */
    public int getPingjia() {
        return pingjia;
    }

    /**
     * @param pingjia pingjia
     */
    public void setPingjia(int pingjia) {
        this.pingjia = pingjia;
    }

    /**
     * @return wXtoken
     */
    public String getwXtoken() {
        return wXtoken;
    }

    /**
     * @param wXtoken wXtoken
     */
    public void setwXtoken(String wXtoken) {
        this.wXtoken = wXtoken;
    }

    /**
     * @return wXAppId
     */
    public String getwXAppId() {
        return wXAppId;
    }

    /**
     * @param wXAppId wXAppId
     */
    public void setwXAppId(String wXAppId) {
        this.wXAppId = wXAppId;
    }

    /**
     * @return wXAppSecret
     */
    public String getwXAppSecret() {
        return wXAppSecret;
    }

    /**
     * @param wXAppSecret wXAppSecret
     */
    public void setwXAppSecret(String wXAppSecret) {
        this.wXAppSecret = wXAppSecret;
    }

    /**
     * @return welcomeImg
     */
    public String getWelcomeImg() {
        return welcomeImg;
    }

    /**
     * @param welcomeImg welcomeImg
     */
    public void setWelcomeImg(String welcomeImg) {
        this.welcomeImg = welcomeImg;
    }

    /**
     * @return welcomeTxt
     */
    public String getWelcomeTxt() {
        return welcomeTxt;
    }

    /**
     * @param welcomeTxt welcomeTxt
     */
    public void setWelcomeTxt(String welcomeTxt) {
        this.welcomeTxt = welcomeTxt;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return 实体类以字符串的形式输出
     */
    @Override
    public String toString() {
        return "ShopInfo{"
                + "id='" + id + '\''
                + ", shopName='" + shopName + '\''
                + ", lat='" + lat + '\''
                + ", lon='" + lon + '\''
                + ", state='" + state + '\''
                + ", address='" + address + '\''
                + ", city='" + city + '\''
                + ", tel='" + tel + '\''
                + ", mobile='" + mobile + '\''
                + ", serviceContent='" + serviceContent + '\''
                + ", hardware=" + hardware
                + ", environment=" + environment
                + ", artificer=" + artificer
                + ", service=" + service
                + ", introduction='" + introduction + '\''
                + ", imgListView='" + imgListView + '\''
                + ", imgBig='" + imgBig + '\''
                + ", imgIntroduct='" + imgIntroduct + '\''
                + ", shopStrength='" + shopStrength + '\''
                + ", renqi=" + renqi
                + ", pingjia=" + pingjia
                + ", wXtoken='" + wXtoken + '\''
                + ", wXAppId='" + wXAppId + '\''
                + ", wXAppSecret='" + wXAppSecret + '\''
                + ", welcomeImg='" + welcomeImg + '\''
                + ", welcomeTxt='" + welcomeTxt + '\''
                + ", url='" + url + "}";
    }
}
