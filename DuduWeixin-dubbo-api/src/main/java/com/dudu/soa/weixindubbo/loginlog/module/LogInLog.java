package com.dudu.soa.weixindubbo.loginlog.module;

import java.io.Serializable;

/**
 * Created by lizhen on 2017/3/30.
 */

public class LogInLog implements Serializable{
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
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     *
     * @param openid openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     *
     * @return plateNumber
     */
    public String getPlateNumber() {
        return plateNumber;
    }

    /**
     *
     * @param plateNumber plateNumber
     */
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    /**
     *
     * @return lmcode
     */
    public String getLmcode() {
        return lmcode;
    }

    /**
     *
     * @param lmcode lmcode
     */
    public void setLmcode(String lmcode) {
        this.lmcode = lmcode;
    }

    /**
     *
     * @return userid
     */
    public int getUserid() {
        return userid;
    }

    /**
     *
     * @param userid userid
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }

    /**
     *
     * @return 实体类以字符串的形式输出
     */
    @Override
    public String toString() {
        return "LogInLog{"
                + "id=" + id
                + ", openid='" + openid + '\''
                + ", plateNumber='" + plateNumber + '\''
                + ", lmcode='" + lmcode + '\''
                + ", userid=" + userid + "}";
    }
}
