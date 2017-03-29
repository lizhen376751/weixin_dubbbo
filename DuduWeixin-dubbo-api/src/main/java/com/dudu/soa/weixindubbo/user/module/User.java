package com.dudu.soa.weixindubbo.user.module;

/**
 * Created by Administrator on 2017/3/29.
 */

public class User {
    /**
     * 主键id
     */
    private int id;

    /**
     * 手机号码
     */
    private String mobilePhone;
    /**
     * 车牌号码
     */
    private String plateNumber;
    /**
     * 联盟code
     */
    private String lmcode;
    /**
     * 密码
     */
    private String password;

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return mobilePhone
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * @param mobilePhone mobilePhone
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * @return plateNumber
     */
    public String getPlateNumber() {
        return plateNumber;
    }

    /**
     * @param plateNumber plateNumber
     */
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    /**
     * @return lmcode
     */
    public String getLmcode() {
        return lmcode;
    }

    /**
     * @param lmcode lmcode
     */
    public void setLmcode(String lmcode) {
        this.lmcode = lmcode;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return 实体类
     */
    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", mobilePhone='" + mobilePhone + '\''
                + ", plateNumber='" + plateNumber + '\''
                + ", lmcode='" + lmcode + '\''
                + ", password='" + password + "}";
    }
}
