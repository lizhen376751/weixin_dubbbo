package com.dudu.soa.weixindubbo.wechatcard.api;

import java.io.DataInputStream;

/**
 * 微信卡包相關接口
 * Created by lizhen on 2017/7/27.
 */

public interface ApiCard {
    /**
     * 模拟form表单的形式 ，上传文件 以输出流的形式把文件写入到url中，然后用输入流来获取url的响应
     *
     * @param token    请求地址 form表单url地址
     * @param filePath 文件的
     * @param in       文件的
     * @return String url的响应信息返回值
     */
     String send(String token, String filePath, DataInputStream in);
}
