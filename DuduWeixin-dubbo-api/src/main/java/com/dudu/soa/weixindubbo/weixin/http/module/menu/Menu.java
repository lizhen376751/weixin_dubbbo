package com.dudu.soa.weixindubbo.weixin.http.module.menu;


import java.io.Serializable;

/**
 * 菜单类
 */
public class Menu implements Serializable {
    /**
     * 按钮
     */
    private Button[] button;

    /**
     *
     * @return 按钮
     */
    public Button[] getButton() {
        return button;
    }

    /**
     *
     * @param button 按钮
     */
    public void setButton(Button[] button) {
        this.button = button;
    }
}