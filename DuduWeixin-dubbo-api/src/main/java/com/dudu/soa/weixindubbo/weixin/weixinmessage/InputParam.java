package com.dudu.soa.weixindubbo.weixin.weixinmessage;

import java.io.InputStream;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/28.
 */

public class InputParam implements Serializable{
    /**
     *
     */
    private InputStream inputStream;

    /**
     *  InputParam(Created by Administrator on 2017428.) 字符串形式
     * @return InputParam(Created by Administrator on 2017428.)字符串
     */
    @Override
    public String toString() {
        return "inputStream:" + inputStream;
    }

    /**
     * 获取
     * @return inputStream
     */
    public InputStream getInputStream() {
        return this.inputStream;
    }

    /**
     * 设置
     * @param inputStream
     * @return 返回 InputParam(Created by Administrator on 2017428.)
     */
    public InputParam setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
        return this;
    }
}
