package com.dudu.soa.weixindubbo.weixin.http.service;

import com.dudu.soa.weixindubbo.weixin.weixinmessage.TextMessage;

import java.util.Date;
import java.util.Map;

/**
 * 消息业务处理分发器
 * Created by lizhen on 2017/4/23.
 */
public final class MsgDispatcher {
    private MsgDispatcher() {
    }

    /**
     * 根据对XML的解析后获取相应的类型,进行不同的业务处理
     *
     * @param map 接受到的消息
     * @return 返回不同类型的xml消息
     */
    public static String processMessage(Map<String, String> map) {
        /**
         *
         */
        String openid = map.get("FromUserName"); //TODO 用户openid
        /**
         *
         */
        String mpid = map.get("ToUserName");   //TODO 公众号原始ID
        //普通文本消息
        TextMessage txtmsg = new TextMessage();
        txtmsg.setToUserName(openid);
        txtmsg.setFromUserName(mpid);
        txtmsg.setCreateTime(new Date().getTime());
        txtmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { // 文本消息
            System.out.println("==============这是文本消息！");
            txtmsg.setContent("你好，这里是李振个人账号！");
            return MessageUtil.textMessageToXml(txtmsg);

        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) { // 图片消息
            System.out.println("==============这是图片消息！");
        }


        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) { // 链接消息
            System.out.println("==============这是链接消息！");
        }


        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) { // 位置消息
            System.out.println("==============这是位置消息！");
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) { // 语音消息
            System.out.println("==============这是语音消息！");
        }

        return null;
    }
}
