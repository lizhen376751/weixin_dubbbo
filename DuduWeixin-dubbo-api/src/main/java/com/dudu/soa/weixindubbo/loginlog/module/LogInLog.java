package com.dudu.soa.weixindubbo.loginlog.module;

import java.io.Serializable;

/**
 * Created by lizhen on 2017/3/30.
 */
public class LogInLog implements Serializable {
    /**
     * 主键id
     */
    private int id;
    /**
     * weixin的id
     */
    private String openid;
    /**
     * 车牌号
     */
    private String plateNumber;
    /**
     * 联盟code
     */
    private String lmcode;
    /**
     * 用户id与联盟的用户表的id对应
     */
    private int userid;
    /**
     * 微信昵称
     */
    private String nickname;

    /**
     *  LogInLog(Created by lizhen on 2017330.) 字符串形式
     * @return LogInLog(Created by lizhen on 2017330.)字符串
     */
    @Override
    public String toString() {
        return "id:" + id + ",openid:" + openid + ",plateNumber:" + plateNumber + ",lmcode:" + lmcode + ",userid:" + userid + ",nickname:" + nickname;
    }

    /**
     * 获取 主键id
     *
     * @return id 主键id
     */
    public int getId() {
        return this.id;
    }

    /**
     * 设置 主键id
     *
     * @param id 主键id
     * @return 返回 LogInLog(Created by lizhen on 2017330.)
     */
    public LogInLog setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 weixin的id
     *
     * @return openid weixin的id
     */
    public String getOpenid() {
        return this.openid;
    }

    /**
     * 设置 weixin的id
     *
     * @param openid weixin的id
     * @return 返回 LogInLog(Created by lizhen on 2017330.)
     */
    public LogInLog setOpenid(String openid) {
        this.openid = openid;
        return this;
    }

    /**
     * 获取 车牌号
     *
     * @return plateNumber 车牌号
     */
    public String getPlateNumber() {
        return this.plateNumber;
    }

    /**
     * 设置 车牌号
     *
     * @param plateNumber 车牌号
     * @return 返回 LogInLog(Created by lizhen on 2017330.)
     */
    public LogInLog setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
        return this;
    }

    /**
     * 获取 联盟code
     *
     * @return lmcode 联盟code
     */
    public String getLmcode() {
        return this.lmcode;
    }

    /**
     * 设置 联盟code
     *
     * @param lmcode 联盟code
     * @return 返回 LogInLog(Created by lizhen on 2017330.)
     */
    public LogInLog setLmcode(String lmcode) {
        this.lmcode = lmcode;
        return this;
    }

    /**
     * 获取 用户id与联盟的用户表的id对应
     *
     * @return userid 用户id与联盟的用户表的id对应
     */
    public int getUserid() {
        return this.userid;
    }

    /**
     * 设置 用户id与联盟的用户表的id对应
     *
     * @param userid 用户id与联盟的用户表的id对应
     * @return 返回 LogInLog(Created by lizhen on 2017330.)
     */
    public LogInLog setUserid(int userid) {
        this.userid = userid;
        return this;
    }

    /**
     * 获取 微信昵称
     *
     * @return nickname 微信昵称
     */
    public String getNickname() {
        return this.nickname;
    }

    /**
     * 设置 微信昵称
     *
     * @param nickname 微信昵称
     * @return 返回 LogInLog(Created by lizhen on 2017330.)
     */
    public LogInLog setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }
}
