package com.dudu.soa.weixindubbo.weixin.http.service;

import com.dudu.soa.weixindubbo.weixin.weixinmessage.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Map;

/**
 * 消息业务处理分发器
 * Created by lizhen on 2017/4/23.
 */
public final class MsgDispatcher {
    /**
     * 日志打印
     */
    private static Logger log = LoggerFactory.getLogger(MsgDispatcher.class);
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
         *用户openid
         */
        String openid = map.get("FromUserName");
        /**
         *公众号原始ID
         */
        String mpid = map.get("ToUserName");
        //普通文本消息
        TextMessage txtmsg = new TextMessage();
        txtmsg.setToUserName(openid);
        txtmsg.setFromUserName(mpid);
        txtmsg.setCreateTime(new Date().getTime() / 1000);
        txtmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { // 文本消息
            log.info("==============这是文本消息！");
            return MessageUtil.textMessageToXml(txtmsg);

        }
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) { // 推送地理位置
            log.info("==============这是地理位置推送消息！");
            return "success";

        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) { // 图片消息
            log.info("==============这是图片消息！");
        }


        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) { // 链接消息
            log.info("==============这是链接消息！");
        }


        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) { // 位置消息
            log.info("==============这是位置消息！");
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) { // 语音消息
            log.info("==============这是语音消息！");
        }

        return null;
    }
}
