package com.dudu.soa.weixindubbo.electroniccoupon.service;

import com.dudu.soa.framework.util.DuduTestUtil;
import com.dudu.soa.weixindubbo.electroniccoupon.module.CouponCountResult;
import com.dudu.soa.weixindubbo.electroniccoupon.module.CouponTemplate;
import com.dudu.soa.weixindubbo.electroniccoupon.module.CouponTemplateParam;
import com.dudu.soa.weixindubbo.electroniccoupon.module.ElectronicCoupon;
import com.dudu.soa.weixindubbo.electroniccoupon.module.ReceiveRecords;
import com.dudu.soa.weixindubbo.electroniccoupon.module.WeiXinCouponInfo;
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
     * 测试领取优惠券
     * @throws Exception Exception
     */
    @Test
    public void lingQuCoupon() throws Exception {
        ElectronicCoupon electronicCoupon = new ElectronicCoupon();
        electronicCoupon.setShopCode("0533001")
                .setBelongedOpenId("oSsYXwNHJ9in8afIrkOv2PdK_IPU") //领取谁的优惠券
                .setOpenId("123")   //领取人openId
                .setCouponId(23); //领取哪个券
        Integer integer = couponService.lingQuCoupon(electronicCoupon);
    }

    /**
     * 测试查询优惠券列表
     *
     * @throws Exception Exception
     */
    @Test
    public void queryWXElectronicCouponList() throws Exception {
        ElectronicCouponParam electronicCouponParam = new ElectronicCouponParam();
        electronicCouponParam.setShopCode("0533001")
                .setCouponId(21)
                .setOpenId("olpAj1PmKtPQ8-QqTNVu9XfANp8g");
        DuduTestUtil.printRequestForTest(electronicCouponParam);
        List<WeiXinCouponInfo> weiXinCouponInfos = couponService.queryWXElectronicCouponList(electronicCouponParam);
        DuduTestUtil.printResponseForTest(weiXinCouponInfos);
    }

    /**
     * 测试页面详情接口
     *
     * @throws Exception Exception
     */
    @Test
    public void getWXElectronicCouponInfo() throws Exception {
        ElectronicCouponParam electronicCouponParam = new ElectronicCouponParam();
        electronicCouponParam.setOpenId("oSsYXwNHJ9in8afIrkOv2PdK_IPU");
        electronicCouponParam.setCouponId(23);
        electronicCouponParam.setShopCode("0533001");
        electronicCouponParam.setCouponFlag(0);
        DuduTestUtil.printRequestForTest(electronicCouponParam);
        WeiXinCouponInfo wxElectronicCouponInfo = couponService.getWXElectronicCouponInfo(electronicCouponParam);
        DuduTestUtil.printResponseForTest(wxElectronicCouponInfo);
    }

    /**
     * 测试查询领取记录接口
     *
     * @throws Exception Exception
     */
    @Test
    public void queryReceiveRecords() throws Exception {
        ElectronicCouponParam electronicCouponParam = new ElectronicCouponParam();
        electronicCouponParam.setOpenId("olpAj1PmKtPQ8-QqTNVu9XfANp8g");
        DuduTestUtil.printRequestForTest(electronicCouponParam);
        List<ReceiveRecords> receiveRecordss = couponService.queryReceiveRecords(electronicCouponParam);
        DuduTestUtil.printResponseForTest(receiveRecordss);
    }


    /**
     * 测试统计优惠券数量
     *
     * @throws Exception Exception
     */
    @Test
    public void getWeiXinConponCount() throws Exception {
        ElectronicCouponParam electronicCouponParam = new ElectronicCouponParam();
        electronicCouponParam.setOpenId("oSsYXwNHJ9in8afIrkOv2PdK_IPU")
                .setShopCode("0533001");
//                .setCouponId(21);
        CouponCountResult weiXinConponCount = couponService.getWeiXinConponCount(electronicCouponParam);
        DuduTestUtil.printResponseForTest(weiXinConponCount);
    }

    /**
     * 测试生成优惠券Code
     *
     * @throws Exception Exception
     */
    @Test
    public void addCouponCode() throws Exception {
        ElectronicCoupon electronicCoupon = new ElectronicCoupon();
        electronicCoupon.setShopCode("0533001")
                .setCouponId(21)
                .setOpenId("olpAj1PmKtPQ8-QqTNVu9XfANp8g");
//                .setCustId(5940);

        Integer integer = couponService.addCouponCode(electronicCoupon);


    }

    /**
     * 测试更新优惠券模板
     *
     * @throws Exception Exception
     */
    @Test
    public void updateElectronicCoupon() throws Exception {

        CouponTemplate couponTemplate = new CouponTemplate();
        couponTemplate.setCouponName("洗车券");
        couponTemplate.setDetails("只能用与洗车");
        couponTemplate.setDiXiaoJinE(new BigDecimal("80"));
        couponTemplate.setAnotherJinE(new BigDecimal("100"));
        couponTemplate.setCouponId(14);
        couponTemplate.setUpdateUser("刘丽");
        DuduTestUtil.printRequestForTest(couponTemplate);

        Integer integer = couponService.updateElectronicCoupon(couponTemplate);
        logger.debug("更新结果==============>>>>>>>>>" + integer);
    }

    /**
     * 测试创建优惠券模板
     *
     * @throws Exception Exception
     */
    @Test
    public void installCoupon() throws Exception {
        CouponTemplate couponTemplate = new CouponTemplate();
        couponTemplate.setShopCode("0533001")
                .setAnotherJinE(new BigDecimal("0.5"))
                .setCouponName("insert into测试")
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

        DuduTestUtil.printRequestForTest(couponTemplate);
        Integer integer = couponService.installCoupon(couponTemplate);
        logger.debug("result=============>>>>>>>>>>" + integer);
    }

    /**
     * 测试查询优惠券列表接口
     *
     * @throws Exception Exception
     */
    @Test
    public void queryCouponList() throws Exception {
        CouponTemplateParam couponTemplateParam = new CouponTemplateParam();
        couponTemplateParam.setShopCode("0533001");
        couponTemplateParam.setState(1);
//        couponTemplateParam.setQueryStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-08-24 12:00:00"));
//        couponTemplateParam.setQueryEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-08-24 15:00:00"));
        DuduTestUtil.printRequestForTest(couponTemplateParam);

        List<CouponTemplate> couponTemplates = couponService.queryCouponList(couponTemplateParam);

        DuduTestUtil.printResponseForTest(couponTemplates);
    }

    /**
     * 根据id获取模板消息
     *
     * @throws Exception Exception
     */
    @Test
    public void getCouponById() throws Exception {
        CouponTemplateParam couponTemplateParam = new CouponTemplateParam();
        couponTemplateParam.setCouponId(21);
        DuduTestUtil.printRequestForTest(couponTemplateParam);
        CouponTemplate couponById = couponService.getCouponById(couponTemplateParam);
        DuduTestUtil.printResponseForTest(couponById);
    }
}