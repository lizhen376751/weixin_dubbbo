package com.dudu.soa.weixindubbo.menu.mapper;

import com.dudu.soa.weixindubbo.menu.module.AddWeiXinMenu;
import com.dudu.soa.weixindubbo.menu.module.ResultQueryMenu;

import java.util.List;

/**
 * Created by Administrator on 2017/8/18.
 */
public interface WeiXinMenuDao {
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
     * 查询主键ID
     *
     * @param id 传参
     * @return 返回ID
     */
    Integer getMenuId(Integer id);

    /**
     * 冯广祥
     * 添加自定义菜单
     *
     * @param param 传参
     * @return 返回影响行数
     */
    Integer addWeiXinMenu(AddWeiXinMenu param);

    /**
     * 冯广祥
     * 修改自定义菜单
     *
     * @param param 传参
     * @return 返回影响行数
     */
    Integer updateWeiXinMenu(AddWeiXinMenu param);
}
