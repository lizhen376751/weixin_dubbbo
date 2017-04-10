package com.dudu.soa.weixindubbo.weixin.module;

import java.io.Serializable;

/**
 * 按钮类
 */
public class Button implements Serializable {
    /**
     * 名字
     */
    private String name;

    /**
     * @return 名字
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name;
    }
}