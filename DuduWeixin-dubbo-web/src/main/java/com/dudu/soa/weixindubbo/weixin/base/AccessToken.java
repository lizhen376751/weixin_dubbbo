package com.dudu.soa.weixindubbo.weixin.base;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/14.
 */
public class AccessToken implements Serializable {

    /**
     * token
     */
    private String token;
    /**
     * 有效时间
     */
    private int expiresIn;
    /**
     * token创建时间
     */
    private long createTime = System.currentTimeMillis();

    /**
     *  AccessToken(Created by Administrator on 2017414.) 字符串形式
     * @return AccessToken(Created by Administrator on 2017414.)字符串
     */
    @Override
    public String toString() {
        return "token:" + token + ",expiresIn:" + expiresIn + ",createTime:" + createTime;
    }

    /**
     * 获取 token
     * @return token token
     */
    public String getToken() {
        return this.token;
    }

    /**
     * 设置 token
     * @param token token
     * @return 返回 AccessToken(Created by Administrator on 2017414.)
     */
    public AccessToken setToken(String token) {
        this.token = token;
        return this;
    }

    /**
     * 获取 有效时间
     * @return expiresIn 有效时间
     */
    public int getExpiresIn() {
        return this.expiresIn;
    }

    /**
     * 设置 有效时间
     * @param expiresIn 有效时间
     * @return 返回 AccessToken(Created by Administrator on 2017414.)
     */
    public AccessToken setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    /**
     * 获取 token创建时间
     * @return createTime token创建时间
     */
    public long getCreateTime() {
        return this.createTime;
    }

    /**
     * 设置 token创建时间
     * @param createTime token创建时间
     * @return 返回 AccessToken(Created by Administrator on 2017414.)
     */
    public AccessToken setCreateTime(long createTime) {
        this.createTime = createTime;
        return this;
    }
}
