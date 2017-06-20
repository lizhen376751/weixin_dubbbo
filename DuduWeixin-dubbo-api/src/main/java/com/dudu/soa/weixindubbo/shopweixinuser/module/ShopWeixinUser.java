package com.dudu.soa.weixindubbo.shopweixinuser.module;

import java.io.Serializable;

/**
 * 店管家微信的用户列表
 * Created by lizhen on 2017/3/29.
 */
public class ShopWeixinUser implements Serializable {
    /**
     * 主键id
     */
    private int id;
    /**
     * 用户姓名(车牌号)
     */
    private String userName;
    /**
     * 用户的密码
     */
    private String userPass;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 地址
     */
    private String address;
    /**
     * 发动机
     */
    private String engine;
    /**
     * 用户的id
     */
    private String iDCode;
    /**
     * 注册时间
     */
    private String registCode;
    /**
     * 记录时间
     */
    private String recordDate;
    /**
     * 车辆品牌
     */
    private String brand;
    /**
     * 车系
     */
    private String serise;
    /**
     * 城市
     */
    private String city;
    /**
     * 状态
     */
    private String state;
    /**
     * 注册时间
     */
    private String registerTime;
    /**
     * 城市邮编
     */
    private String citycode;
    /**
     * 微信的openid
     */
    private String openId;
    /**
     * 未知字段
     */
    private String openU;
    /**
     * 店铺编码
     */
    private String shopcode;
    /**
     * 姓名
     */
    private String xingMing;
    /**
     * 性别
     */
    private String xingBie;
    /**
     * 车排量
     */
    private String carPaiLiang;
    /**
     * 微信昵称
     */
    private String nickname;
    /**
     * 修改时间
     */
    private String updateTime;

    /**
     *  ShopWeixinUser(店管家微信的用户列表) 字符串形式
     * @return ShopWeixinUser(店管家微信的用户列表)字符串
     */
    @Override
    public String toString() {
        return "id:" + id + ",userName:" + userName + ",userPass:" + userPass + ",mobile:" + mobile + ",address:" + address + ",engine:" + engine
                + ",iDCode:" + iDCode + ",registCode:" + registCode + ",recordDate:" + recordDate + ",brand:" + brand + ",serise:" + serise + ",city:" + city
                + ",state:" + state + ",registerTime:" + registerTime + ",citycode:" + citycode + ",openId:" + openId + ",openU:" + openU + ",shopcode:" + shopcode
                + ",xingMing:" + xingMing + ",xingBie:" + xingBie + ",carPaiLiang:" + carPaiLiang + ",nickname:" + nickname + ",updateTime:" + updateTime;
    }

    /**
     * 获取 主键id
     * @return id 主键id
     */
    public int getId() {
        return this.id;
    }

    /**
     * 设置 主键id
     * @param id 主键id
     * @return 返回 ShopWeixinUser(店管家微信的用户列表)
     */
    public ShopWeixinUser setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 用户姓名(车牌号)
     * @return userName 用户姓名(车牌号)
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * 设置 用户姓名(车牌号)
     * @param userName 用户姓名(车牌号)
     * @return 返回 ShopWeixinUser(店管家微信的用户列表)
     */
    public ShopWeixinUser setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * 获取 用户的密码
     * @return userPass 用户的密码
     */
    public String getUserPass() {
        return this.userPass;
    }

    /**
     * 设置 用户的密码
     * @param userPass 用户的密码
     * @return 返回 ShopWeixinUser(店管家微信的用户列表)
     */
    public ShopWeixinUser setUserPass(String userPass) {
        this.userPass = userPass;
        return this;
    }

    /**
     * 获取 手机号
     * @return mobile 手机号
     */
    public String getMobile() {
        return this.mobile;
    }

    /**
     * 设置 手机号
     * @param mobile 手机号
     * @return 返回 ShopWeixinUser(店管家微信的用户列表)
     */
    public ShopWeixinUser setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    /**
     * 获取 地址
     * @return address 地址
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * 设置 地址
     * @param address 地址
     * @return 返回 ShopWeixinUser(店管家微信的用户列表)
     */
    public ShopWeixinUser setAddress(String address) {
        this.address = address;
        return this;
    }

    /**
     * 获取 发动机
     * @return engine 发动机
     */
    public String getEngine() {
        return this.engine;
    }

    /**
     * 设置 发动机
     * @param engine 发动机
     * @return 返回 ShopWeixinUser(店管家微信的用户列表)
     */
    public ShopWeixinUser setEngine(String engine) {
        this.engine = engine;
        return this;
    }

    /**
     * 获取 用户的id
     * @return iDCode 用户的id
     */
    public String getIDCode() {
        return this.iDCode;
    }

    /**
     * 设置 用户的id
     * @param iDCode 用户的id
     * @return 返回 ShopWeixinUser(店管家微信的用户列表)
     */
    public ShopWeixinUser setIDCode(String iDCode) {
        this.iDCode = iDCode;
        return this;
    }

    /**
     * 获取 注册时间
     * @return registCode 注册时间
     */
    public String getRegistCode() {
        return this.registCode;
    }

    /**
     * 设置 注册时间
     * @param registCode 注册时间
     * @return 返回 ShopWeixinUser(店管家微信的用户列表)
     */
    public ShopWeixinUser setRegistCode(String registCode) {
        this.registCode = registCode;
        return this;
    }

    /**
     * 获取 记录时间
     * @return recordDate 记录时间
     */
    public String getRecordDate() {
        return this.recordDate;
    }

    /**
     * 设置 记录时间
     * @param recordDate 记录时间
     * @return 返回 ShopWeixinUser(店管家微信的用户列表)
     */
    public ShopWeixinUser setRecordDate(String recordDate) {
        this.recordDate = recordDate;
        return this;
    }

    /**
     * 获取 车辆品牌
     * @return brand 车辆品牌
     */
    public String getBrand() {
        return this.brand;
    }

    /**
     * 设置 车辆品牌
     * @param brand 车辆品牌
     * @return 返回 ShopWeixinUser(店管家微信的用户列表)
     */
    public ShopWeixinUser setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    /**
     * 获取 车系
     * @return serise 车系
     */
    public String getSerise() {
        return this.serise;
    }

    /**
     * 设置 车系
     * @param serise 车系
     * @return 返回 ShopWeixinUser(店管家微信的用户列表)
     */
    public ShopWeixinUser setSerise(String serise) {
        this.serise = serise;
        return this;
    }

    /**
     * 获取 城市
     * @return city 城市
     */
    public String getCity() {
        return this.city;
    }

    /**
     * 设置 城市
     * @param city 城市
     * @return 返回 ShopWeixinUser(店管家微信的用户列表)
     */
    public ShopWeixinUser setCity(String city) {
        this.city = city;
        return this;
    }

    /**
     * 获取 状态
     * @return state 状态
     */
    public String getState() {
        return this.state;
    }

    /**
     * 设置 状态
     * @param state 状态
     * @return 返回 ShopWeixinUser(店管家微信的用户列表)
     */
    public ShopWeixinUser setState(String state) {
        this.state = state;
        return this;
    }

    /**
     * 获取 注册时间
     * @return registerTime 注册时间
     */
    public String getRegisterTime() {
        return this.registerTime;
    }

    /**
     * 设置 注册时间
     * @param registerTime 注册时间
     * @return 返回 ShopWeixinUser(店管家微信的用户列表)
     */
    public ShopWeixinUser setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
        return this;
    }

    /**
     * 获取 城市邮编
     * @return citycode 城市邮编
     */
    public String getCitycode() {
        return this.citycode;
    }

    /**
     * 设置 城市邮编
     * @param citycode 城市邮编
     * @return 返回 ShopWeixinUser(店管家微信的用户列表)
     */
    public ShopWeixinUser setCitycode(String citycode) {
        this.citycode = citycode;
        return this;
    }

    /**
     * 获取 微信的openid
     * @return openId 微信的openid
     */
    public String getOpenId() {
        return this.openId;
    }

    /**
     * 设置 微信的openid
     * @param openId 微信的openid
     * @return 返回 ShopWeixinUser(店管家微信的用户列表)
     */
    public ShopWeixinUser setOpenId(String openId) {
        this.openId = openId;
        return this;
    }

    /**
     * 获取 未知字段
     * @return openU 未知字段
     */
    public String getOpenU() {
        return this.openU;
    }

    /**
     * 设置 未知字段
     * @param openU 未知字段
     * @return 返回 ShopWeixinUser(店管家微信的用户列表)
     */
    public ShopWeixinUser setOpenU(String openU) {
        this.openU = openU;
        return this;
    }

    /**
     * 获取 店铺编码
     * @return shopcode 店铺编码
     */
    public String getShopcode() {
        return this.shopcode;
    }

    /**
     * 设置 店铺编码
     * @param shopcode 店铺编码
     * @return 返回 ShopWeixinUser(店管家微信的用户列表)
     */
    public ShopWeixinUser setShopcode(String shopcode) {
        this.shopcode = shopcode;
        return this;
    }

    /**
     * 获取 姓名
     * @return xingMing 姓名
     */
    public String getXingMing() {
        return this.xingMing;
    }

    /**
     * 设置 姓名
     * @param xingMing 姓名
     * @return 返回 ShopWeixinUser(店管家微信的用户列表)
     */
    public ShopWeixinUser setXingMing(String xingMing) {
        this.xingMing = xingMing;
        return this;
    }

    /**
     * 获取 性别
     * @return xingBie 性别
     */
    public String getXingBie() {
        return this.xingBie;
    }

    /**
     * 设置 性别
     * @param xingBie 性别
     * @return 返回 ShopWeixinUser(店管家微信的用户列表)
     */
    public ShopWeixinUser setXingBie(String xingBie) {
        this.xingBie = xingBie;
        return this;
    }

    /**
     * 获取 车排量
     * @return carPaiLiang 车排量
     */
    public String getCarPaiLiang() {
        return this.carPaiLiang;
    }

    /**
     * 设置 车排量
     * @param carPaiLiang 车排量
     * @return 返回 ShopWeixinUser(店管家微信的用户列表)
     */
    public ShopWeixinUser setCarPaiLiang(String carPaiLiang) {
        this.carPaiLiang = carPaiLiang;
        return this;
    }

    /**
     * 获取 微信昵称
     * @return nickname 微信昵称
     */
    public String getNickname() {
        return this.nickname;
    }

    /**
     * 设置 微信昵称
     * @param nickname 微信昵称
     * @return 返回 ShopWeixinUser(店管家微信的用户列表)
     */
    public ShopWeixinUser setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    /**
     * 获取 修改时间
     * @return updateTime 修改时间
     */
    public String getUpdateTime() {
        return this.updateTime;
    }

    /**
     * 设置 修改时间
     * @param updateTime 修改时间
     * @return 返回 ShopWeixinUser(店管家微信的用户列表)
     */
    public ShopWeixinUser setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
        return this;
    }
}
