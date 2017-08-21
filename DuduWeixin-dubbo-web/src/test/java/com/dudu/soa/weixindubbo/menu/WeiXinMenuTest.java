package com.dudu.soa.weixindubbo.menu;

import com.dudu.soa.framework.util.DuduTestUtil;
import com.dudu.soa.weixindubbo.menu.module.AddWeiXinMenu;
import com.dudu.soa.weixindubbo.menu.module.ResultQueryMenu;
import com.dudu.soa.weixindubbo.menu.service.WeiXinMenuService;
import com.dudu.soa.wxd.test.TestBase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 微信自定义菜单测试用例
 * 2017/8/18.
 */
public class WeiXinMenuTest extends TestBase {

    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(WeiXinMenuService.class);

    /**
     * 实现类
     */
    @Autowired
    private WeiXinMenuService service;

    /**
     * 查询自定义菜单
     */
    @Test
    public void testQyeryWeiXinMenu() {
        try {
            String shopCode = "0533001";
            List<ResultQueryMenu> result = service.queryWeiXinMenu(shopCode);
            DuduTestUtil.printResponseForTest(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加修改自定义菜单
     */
    //@Test
    public void testAddAndUpWeiXinMenu() {
        try {
            List<AddWeiXinMenu> list = new ArrayList<AddWeiXinMenu>();
            for (int i = 0; i < 12; i++) {
                int aa = 3;
                AddWeiXinMenu param = new AddWeiXinMenu();
                if (i == 0 || i == 5 || i == 8) {
                    aa = 2;
                }
                if (i <11) {
                    param.setShopCode("0533001")
                            .setCondition(1)
                            .setTitle("标题")
                            .setMenuUrl("new.duduchewang.com")
                            .setModuleLayer(aa)
                            .setSequence(i)
                            .setId(i + 157)
                    ;
                    list.add(param);
                } else {
                    param.setShopCode("0533001")
                            .setCondition(1)
                            .setTitle("标题修改添加")
                            .setMenuUrl("new.duduchewang.com")
                            .setModuleLayer(3)
                            .setSequence(i);
                    list.add(param);
                }

            }
            DuduTestUtil.printResponseForTest(list);
            Integer result = service.addAndUpWeiXinMenu(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //@Test
    public void testAddWeiXinMenu() {
        try {
            AddWeiXinMenu param = new AddWeiXinMenu();
            param.setTitle("测试添加")
                    .setMenuUrl("www.baidu.com")
                    .setCondition(1)
                    .setModuleLayer(3)
                    .setSequence(2)
                    .setModuleUpId(1)
                    .setShopCode("0533001")
                    .setHistoryId(2);
            DuduTestUtil.printRequestForTest(param);
            Integer result = service.addWeiXinMenu(param);
            logger.info("=========================result:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改自定义菜单测试用例
     */
    //@Test
    public void testUpdateWeiXinMenu() {
        try {
            AddWeiXinMenu param = new AddWeiXinMenu();
            param.setId(4)
                    .setShopCode("0533001")
                    .setTitle("测试")
                    .setMenuUrl("www.,taobao.com")
                    .setCondition(0)
                    .setModuleLayer(4)
                    .setSequence(2)
                    .setModuleUpId(2)
                    .setHistoryId(5);
            DuduTestUtil.printRequestForTest(param);
            Integer result = service.updateWeiXinMenu(param);
            logger.debug("=====================" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
