package com.dudu.soa.weixindubbo.weixin.http.service;

import com.dudu.soa.weixindubbo.weixin.weixinmessage.Article;
import com.dudu.soa.weixindubbo.weixin.weixinmessage.NewsMessage;
import com.dudu.soa.weixindubbo.weixin.weixinmessage.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
            //对图文消息
            NewsMessage newmsg = new NewsMessage();
            newmsg.setToUserName(openid);
            newmsg.setFromUserName(mpid);
            newmsg.setCreateTime(new Date().getTime());
            newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
            if (map.get("Event").equals("subscribe")) {
                Article article = new Article();
                article.setDescription("这是图文消息1"); //图文消息的描述
                article.setPicUrl("http://image.duduchewang.cn/0533001/baoxian/D21A0247BAE310E9/1/1496903333065.jpg"); //图文消息图片地址
                article.setTitle("微信使用步骤");  //图文消息标题
                article.setUrl("http://image.duduchewang.cn/0533001/baoxian/D21A0247BAE310E9/1/1496903333065.jpg");  //图文url链接
                List<Article> list = new ArrayList<Article>();
                list.add(article);     //这里发送的是单图文，如果需要发送多图文则在这里list中加入多个Article即可！
                newmsg.setArticleCount(list.size());
                newmsg.setArticles(list);
                log.info("==============微信关注事件！");
                return MessageUtil.newsMessageToXml(newmsg);
            }
            if (map.get("Event").equals("LOCATION")) {
                log.info("==============地理推送事件！");
                txtmsg.setContent("地理推送事件");
            }
            return MessageUtil.textMessageToXml(txtmsg);

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
