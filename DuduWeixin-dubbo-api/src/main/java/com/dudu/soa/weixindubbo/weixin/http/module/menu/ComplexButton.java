package com.dudu.soa.weixindubbo.weixin.http.module.menu;


import com.alibaba.fastjson.annotation.JSONField;

/**
 * button
 */
public class ComplexButton extends Button {
    /**
     * 二级按钮
     */
    @JSONField(name = "sub_button")
    private Button[] subbutton;

    /**
     * @return subbutton
     */
    public Button[] getSubbutton() {
        return subbutton;
    }

    /**
     * @param subbutton subbutton
     */
    public void setSubbutton(Button[] subbutton) {
        this.subbutton = subbutton;
    }
}