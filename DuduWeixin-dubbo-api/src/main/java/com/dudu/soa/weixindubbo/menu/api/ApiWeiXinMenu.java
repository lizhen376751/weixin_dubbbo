package com.dudu.soa.weixindubbo.menu.api;

import com.dudu.soa.weixindubbo.menu.module.AddWeiXinMenu;
import com.dudu.soa.weixindubbo.menu.module.ResultQueryMenu;

import java.util.List;

/**
 * 新版微信自定义菜单接口
 * 冯广祥
 * 2017/8/18.
 */
public interface ApiWeiXinMenu {
    /**
     * 冯广祥
     * 查询自定义菜单
     *
     * @param shopCode 传参  shopCode
     * @return 返回参数
     */
    List<ResultQueryMenu> queryWeiXinMenu(String shopCode);

    /**
     * 冯广祥
     * 添加/修改自定义菜单
     *
     * @param list 集合传参
     * @return 返回影响行数
     */
    Integer addAndUpWeiXinMenu(List<AddWeiXinMenu> list);

    /**
     * 冯广祥
     * 添加自定义菜单
     *
     * @param param 传参
     * @return 返回ID
     */
    Integer addWeiXinMenu(AddWeiXinMenu param);
    /**
     * 冯广祥
     * 修改自定义菜单
     *
     * @param param 传参
     * @return 返回ID
     */
    Integer updateWeiXinMenu(AddWeiXinMenu param);
}
