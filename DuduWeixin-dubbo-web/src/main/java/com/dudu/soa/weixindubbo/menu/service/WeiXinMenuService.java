package com.dudu.soa.weixindubbo.menu.service;

import com.dudu.soa.framework.pagehelp.DuduPageHelpUtil;
import com.dudu.soa.weixindubbo.menu.api.ApiWeiXinMenu;
import com.dudu.soa.weixindubbo.menu.mapper.WeiXinMenuDao;
import com.dudu.soa.weixindubbo.menu.module.AddWeiXinMenu;
import com.dudu.soa.weixindubbo.menu.module.ResultQueryMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 冯广祥
 * 自定义菜单实现类
 * 2017/8/18.
 */
@Service
public class WeiXinMenuService implements ApiWeiXinMenu {
    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(WeiXinMenuService.class);
    /**
     * Dao
     */
    @Autowired
    private WeiXinMenuDao weiXinMenuDao;

    /**
     * 冯广祥
     * 查询自定义菜单
     *
     * @param shopCode 传参  shopCode
     * @return 返回
     */
    @Override
    public List<ResultQueryMenu> queryWeiXinMenu(String shopCode) {
        DuduPageHelpUtil.query(" id ASC");
        return weiXinMenuDao.queryWeiXinMenu(shopCode);
    }

    /**
     * 冯广祥
     * 添加/修改自定义菜单
     *
     * @param list 集合传参
     * @return 返回影响行数
     */
    @Transactional
    public Integer addAndUpWeiXinMenu(List<AddWeiXinMenu> list) {
        int id = 0;
        int id1 = 0;
        for (int i = 0; i < list.size(); i++) {
            for (AddWeiXinMenu addWeiXinMenu : list) {
                if (addWeiXinMenu.getSequence() == i) {
                    if (addWeiXinMenu.getModuleLayer() == 2) {
                        id = 0;
                    }
                    addWeiXinMenu.setModuleUpId(id);
                    addWeiXinMenu.setId(weiXinMenuDao.getMenuId(addWeiXinMenu.getHistoryId()));
                    // 判断id是否传参
                    if (null != addWeiXinMenu.getId() && !"".equals(addWeiXinMenu.getId())) {
                        if (addWeiXinMenu.getModuleLayer() == 2) {
                            id = addWeiXinMenu.getId();
                        }
                        // 传入ID 修改自定义菜单
                        updateWeiXinMenu(addWeiXinMenu);
                    } else {
                        // 不传入ID 添加自定义菜单
                        id1 = addWeiXinMenu(addWeiXinMenu);
                        if (addWeiXinMenu.getModuleLayer() == 2) {
                            id = id1;
                        }
                    }
                }
            }
        }
        return list.size();
    }

    /**
     * 冯广祥
     * 添加自定义菜单
     *
     * @param param 传参
     * @return 返回ID
     */
    @Transactional
    public Integer addWeiXinMenu(AddWeiXinMenu param) {
        if (null == param.getModuleUpId() || "".equals(param.getModuleUpId())) {
            param.setModuleUpId(0);
        }
        weiXinMenuDao.addWeiXinMenu(param);
        return param.getId();
    }

    /**
     * 冯广祥
     * 修改自定义菜单
     *
     * @param param 传参
     * @return 返回影响行数
     */
    @Transactional
    public Integer updateWeiXinMenu(AddWeiXinMenu param) {
        return weiXinMenuDao.updateWeiXinMenu(param);
    }
}
