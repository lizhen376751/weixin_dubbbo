package com.dudu.soa.weixindubbo.weixin.weixinmessage;

/**
 * 返回消息体-基本消息
 * Created by lizhen on 2017/4/23.
 */
public class BaseMessage {

    /**
     * 接收方帐号（收到的OpenID）
     */
    private String toUserName;
    /**
     * 开发者微信号
     */
    private String fromUserName;
    /**
     * 消息创建时间 （整型）
     */
    private long createTime;
    /**
     * 消息类型（text/music/news）
     */
    private String msgType;

    /**
     *  BaseMessage(@Description: 返回消息体-基本消息) 字符串形式
     * @return BaseMessage(@Description: 返回消息体-基本消息)字符串
     */
    @Override
    public String toString() {
        return "toUserName:" + toUserName + ",fromUserName:" + fromUserName + ",createTime:" + createTime + ",msgType:" + msgType;
    }

    /**
     * 获取 接收方帐号（收到的OpenID）
     * @return toUserName 接收方帐号（收到的OpenID）
     */
    public String getToUserName() {
        return this.toUserName;
    }

    /**
     * 设置 接收方帐号（收到的OpenID）
     * @param toUserName 接收方帐号（收到的OpenID）
     * @return 返回 BaseMessage(@Description: 返回消息体-基本消息)
     */
    public BaseMessage setToUserName(String toUserName) {
        this.toUserName = toUserName;
        return this;
    }

    /**
     * 获取 开发者微信号
     * @return fromUserName 开发者微信号
     */
    public String getFromUserName() {
        return this.fromUserName;
    }

    /**
     * 设置 开发者微信号
     * @param fromUserName 开发者微信号
     * @return 返回 BaseMessage(@Description: 返回消息体-基本消息)
     */
    public BaseMessage setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
        return this;
    }

    /**
     * 获取 消息创建时间 （整型）
     * @return createTime 消息创建时间 （整型）
     */
    public long getCreateTime() {
        return this.createTime;
    }

    /**
     * 设置 消息创建时间 （整型）
     * @param createTime 消息创建时间 （整型）
     * @return 返回 BaseMessage(@Description: 返回消息体-基本消息)
     */
    public BaseMessage setCreateTime(long createTime) {
        this.createTime = createTime;
        return this;
    }

    /**
     * 获取 消息类型（textmusicnews）
     * @return msgType 消息类型（textmusicnews）
     */
    public String getMsgType() {
        return this.msgType;
    }

    /**
     * 设置 消息类型（textmusicnews）
     * @param msgType 消息类型（textmusicnews）
     * @return 返回 BaseMessage(@Description: 返回消息体-基本消息)
     */
    public BaseMessage setMsgType(String msgType) {
        this.msgType = msgType;
        return this;
    }
}