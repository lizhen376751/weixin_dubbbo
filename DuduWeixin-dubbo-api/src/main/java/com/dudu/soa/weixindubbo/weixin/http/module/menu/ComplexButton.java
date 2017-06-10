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
     * Get subbutton button [ ].
     *
     * @return subbutton button [ ]
     */
    public Button[] getSubbutton() {
        return subbutton;
    }

    /**
     * Sets subbutton.
     *
     * @param subbutton subbutton
     */
    public void setSubbutton(Button[] subbutton) {
        this.subbutton = subbutton;
    }
}