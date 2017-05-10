package com.dudu.soa.weixindubbo.weixin.weixinmessage;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * @Description: 文本消息消息体
 * Created by lizhen on 2017/4/23.
 */

public class TextMessage extends BaseMessage implements Serializable{

    /**
     * 回复的消息内容
     */
    @XStreamAlias("Content")
    private String Content;


    /**
     *  TextMessage(@Description: 文本消息消息体) 字符串形式
     * @return TextMessage(@Description: 文本消息消息体)字符串
     */
    @Override
    public String toString() {
        return "Content:" + Content;
    }

    /**
     * 获取 回复的消息内容
     * @return Content 回复的消息内容
     */
    public String getContent() {
        return this.Content;
    }

    /**
     * 设置 回复的消息内容
     * @param Content 回复的消息内容
     * @return 返回 TextMessage(@Description: 文本消息消息体)
     */
    public TextMessage setContent(String Content) {
        this.Content = Content;
        return this;
    }
}