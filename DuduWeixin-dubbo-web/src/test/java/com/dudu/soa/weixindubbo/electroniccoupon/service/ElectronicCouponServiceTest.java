package com.dudu.soa.weixindubbo.electroniccoupon.service;

import com.dudu.soa.framework.util.DuduTestUtil;
import com.dudu.soa.weixindubbo.electroniccoupon.module.ElectronicCoupon;
import com.dudu.soa.weixindubbo.electroniccoupon.module.ElectronicCouponParam;
import com.dudu.soa.wxd.test.TestBase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by zhenglz on 2017/8/24.
 */
public class ElectronicCouponServiceTest extends TestBase {
    /**
     * 打印日志
     */
    private Logger logger = LoggerFactory.getLogger(ElectronicCouponService.class);

    /**
     * 注入ElectronicCouponService
     */
    @Autowired
    private ElectronicCouponService couponService;

    /**
     * 测试更新优惠券模板
     * @throws Exception Exception
     */
    @Test
    public void updateElectronicCoupon() throws Exception {

        ElectronicCoupon electronicCoupon = new ElectronicCoupon();
        electronicCoupon.setCouponName("洗车券");
        electronicCoupon.setDetails("只能用与洗车");
        electronicCoupon.setDiXiaoJinE(new BigDecimal("80"));
        electronicCoupon.setAnotherJinE(new BigDecimal("100"));
        electronicCoupon.setCouponId(14);
        electronicCoupon.setUpdateUser("刘丽");
        DuduTestUtil.printRequestForTest(electronicCoupon);

        Integer integer = couponService.updateElectronicCoupon(electronicCoupon);
        logger.debug("更新结果==============>>>>>>>>>"+integer);
    }

    /**
     * 测试创建优惠券模板
     *
     * @throws Exception Exception
     */
    @Test
    public void testInstallCouponTemplate() throws Exception {
        ElectronicCoupon electronicCoupon = new ElectronicCoupon();
        electronicCoupon.setShopCode("0533001")
                .setAnotherJinE(new BigDecimal("0.5"))
                .setCouponName("正式测试")
                .setCreateUser("zlz")
                .setDetails("这是一个坑")
                .setForwardedNum(5)
                .setValidStartTime(new Date())
                .setValidEndTime(new Date())
                .setUsedNum(1)
                .setDiXiaoJinE(new BigDecimal("8"))
                .setImageCode("yiyiyiyiyiyiyiyiy")
                .setServiceFlag("1")
                .setServiceCode("1111111111");

        DuduTestUtil.printRequestForTest(electronicCoupon);
        Integer integer = couponService.installCoupon(electronicCoupon);
        logger.debug("result=============>>>>>>>>>>" + integer);
    }

    /**
     * 测试查询优惠券列表接口
     *
     * @throws Exception Exception
     */
    @Test
    public void queryCouponList() throws Exception {
        ElectronicCouponParam electronicCouponParam = new ElectronicCouponParam();
        electronicCouponParam.setShopCode("0533001");
        DuduTestUtil.printRequestForTest(electronicCouponParam);

        List<ElectronicCoupon> electronicCoupons = couponService.queryCouponList(electronicCouponParam);

        DuduTestUtil.printResponseForTest(electronicCoupons);
    }

    /**
     * 根据id获取模板消息
     *
     * @throws Exception Exception
     */
    @Test
    public void getCouponById() throws Exception {
        ElectronicCouponParam electronicCouponParam = new ElectronicCouponParam();
        electronicCouponParam.setCouponId(1);
        DuduTestUtil.printRequestForTest(electronicCouponParam);
        ElectronicCoupon couponById = couponService.getCouponById(electronicCouponParam);
        DuduTestUtil.printResponseForTest(couponById);
    }
}