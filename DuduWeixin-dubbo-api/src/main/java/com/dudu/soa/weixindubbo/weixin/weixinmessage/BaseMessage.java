package com.dudu.soa.weixindubbo.weixin.weixinmessage;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * 返回消息体-基本消息
 * Created by lizhen on 2017/4/23.
 */
public class BaseMessage implements Serializable{

    /**
     * 接收方帐号（收到的OpenID）
     */
    @XStreamAlias("ToUserName")
    private String ToUserName;
    /**
     * 开发者微信号
     */
    @XStreamAlias("FromUserName")
    private String FromUserName;
    /**
     * 消息创建时间 （整型）
     */
    @XStreamAlias("CreateTime")
    private long CreateTime;
    /**
     * 消息类型（text/music/news）
     */
    @XStreamAlias("MsgType")
    private String MsgType;


    /**
     *  BaseMessage(返回消息体-基本消息) 字符串形式
     * @return BaseMessage(返回消息体-基本消息)字符串
     */
    @Override
    public String toString() {
        return "ToUserName:" + ToUserName + ",FromUserName:" + FromUserName + ",CreateTime:" + CreateTime + ",MsgType:" + MsgType;
    }

    /**
     * 获取 接收方帐号（收到的OpenID）
     * @return ToUserName 接收方帐号（收到的OpenID）
     */
    public String getToUserName() {
        return this.ToUserName;
    }

    /**
     * 设置 接收方帐号（收到的OpenID）
     * @param ToUserName 接收方帐号（收到的OpenID）
     * @return 返回 BaseMessage(返回消息体-基本消息)
     */
    public BaseMessage setToUserName(String ToUserName) {
        this.ToUserName = ToUserName;
        return this;
    }

    /**
     * 获取 开发者微信号
     * @return FromUserName 开发者微信号
     */
    public String getFromUserName() {
        return this.FromUserName;
    }

    /**
     * 设置 开发者微信号
     * @param FromUserName 开发者微信号
     * @return 返回 BaseMessage(返回消息体-基本消息)
     */
    public BaseMessage setFromUserName(String FromUserName) {
        this.FromUserName = FromUserName;
        return this;
    }

    /**
     * 获取 消息创建时间 （整型）
     * @return CreateTime 消息创建时间 （整型）
     */
    public long getCreateTime() {
        return this.CreateTime;
    }

    /**
     * 设置 消息创建时间 （整型）
     * @param CreateTime 消息创建时间 （整型）
     * @return 返回 BaseMessage(返回消息体-基本消息)
     */
    public BaseMessage setCreateTime(long CreateTime) {
        this.CreateTime = CreateTime;
        return this;
    }

    /**
     * 获取 消息类型（textmusicnews）
     * @return MsgType 消息类型（textmusicnews）
     */
    public String getMsgType() {
        return this.MsgType;
    }

    /**
     * 设置 消息类型（textmusicnews）
     * @param MsgType 消息类型（textmusicnews）
     * @return 返回 BaseMessage(返回消息体-基本消息)
     */
    public BaseMessage setMsgType(String MsgType) {
        this.MsgType = MsgType;
        return this;
    }
}