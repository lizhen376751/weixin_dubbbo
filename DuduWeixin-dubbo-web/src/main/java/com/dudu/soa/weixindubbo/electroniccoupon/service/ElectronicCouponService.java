package com.dudu.soa.weixindubbo.electroniccoupon.service;

import com.dudu.soa.framework.exception.DuduExceptionUtil;
import com.dudu.soa.framework.pagehelp.DuduPageHelpUtil;
import com.dudu.soa.weixindubbo.electroniccoupon.api.ApiElectronicCoupon;
import com.dudu.soa.weixindubbo.electroniccoupon.mapper.CouponConnectItem;
import com.dudu.soa.weixindubbo.electroniccoupon.mapper.CouponTemplateMapper;
import com.dudu.soa.weixindubbo.electroniccoupon.mapper.ElectronicCouponMapper;
import com.dudu.soa.weixindubbo.electroniccoupon.module.CouponConnect;
import com.dudu.soa.weixindubbo.electroniccoupon.module.CouponCountResult;
import com.dudu.soa.weixindubbo.electroniccoupon.module.CouponTemplate;
import com.dudu.soa.weixindubbo.electroniccoupon.module.CouponTemplateParam;
import com.dudu.soa.weixindubbo.electroniccoupon.module.ElectronicCoupon;
import com.dudu.soa.weixindubbo.electroniccoupon.module.ElectronicCouponParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 电子优惠券服务类
 *
 * @Author: 郑岭志
 * @Date: 2017年08月24 10:19
 */
@Service
public class ElectronicCouponService implements ApiElectronicCoupon {
    /**
     * 日志打印类
     */
    private static Logger logger = LoggerFactory.getLogger(ElectronicCouponService.class);
    /**
     * 注入CouponTemplateMapper
     */
    @Autowired
    private CouponTemplateMapper couponTemplateMapper;
    /**
     * 注入CouponConnectItem
     */
    @Autowired
    private CouponConnectItem couponConnectItem;
    /**
     * 注入 ElectronicCouponMapper
     */
    @Autowired
    private ElectronicCouponMapper electronicCouponMapper;

    /**
     * 设置电子优惠券模板
     *
     * @param couponTemplate couponTemplate
     * @return 返回电子优惠券模板id
     */
    @Override
    @Transactional
    public Integer installCoupon(CouponTemplate couponTemplate) {
        couponTemplateMapper.addCouponTemplate(couponTemplate);
        CouponConnect couponConnect = new CouponConnect();
        couponConnect.setShopCode(couponTemplate.getShopCode());
        if (couponTemplate.getCouponId() > 0) {
            couponConnect.setCouponId(couponTemplate.getCouponId());
        } else {
            DuduExceptionUtil.throwException("关联失败");
        }
        couponConnect.setServiceCode(couponTemplate.getServiceCode());
        couponConnect.setServiceFlag(couponTemplate.getServiceFlag());
        if (StringUtils.hasText(couponTemplate.getShopCodeLM())) {
            couponConnect.setShopCodeLM(couponTemplate.getShopCodeLM());
        }
        Integer integer = couponConnectItem.addConnectWithItem(couponConnect);
        logger.debug("result===================>>>>>>>>>>" + integer);
        return couponTemplate.getCouponId();
    }

    /**
     * 查询优惠券模板列表
     *
     * @param couponTemplateParam couponTemplateParam
     * @return List<CouponTemplate>
     */
    @Override
    public List<CouponTemplate> queryCouponList(CouponTemplateParam couponTemplateParam) {
        DuduPageHelpUtil.query("createTime desc");
        return couponTemplateMapper.queryCouponTemplateList(couponTemplateParam);
    }

    /**
     * 根据id获取电子优惠券模板
     *
     * @param couponTemplateParam couponTemplate
     * @return CouponTemplate
     */
    @Override
    public CouponTemplate getCouponById(CouponTemplateParam couponTemplateParam) {
        return couponTemplateMapper.getCouponById(couponTemplateParam.getCouponId());
    }

    /**
     * 更新电子优惠券
     *
     * @param couponTemplate couponTemplate
     * @return Integer
     */
    @Override
    public Integer updateElectronicCoupon(CouponTemplate couponTemplate) {
        if (null == couponTemplate.getUpdateUser()) {
            DuduExceptionUtil.throwException("更新人不能为空!");
        }
        return couponTemplateMapper.updateCouponTemplate(couponTemplate);
    }

    /**
     * 领取电子优惠券
     *
     * @param electronicCoupon electronicCoupon
     * @return Integer
     */
    @Override
    @Transactional
    public Integer addCouponCode(ElectronicCoupon electronicCoupon) {
        List<ElectronicCoupon> list = new ArrayList<>();
        CouponTemplate couponById = couponTemplateMapper.getCouponById(electronicCoupon.getCouponId());
        int mixNum = couponById.getUsedNum() + couponById.getForwardedNum();
        Long couponCode = null;
        for (int i = 0; i < mixNum; i++) {
            if (i == 0) {
                //随机生成三位数字
                int threeNum = (int) (Math.random() * 900) + 100;
                //日期戳去掉一位数字,100年以内不会有影响
                couponCode = new Date().getTime() - 1300000000000L;
                list.add(new ElectronicCoupon()
                        .setShopCode(electronicCoupon.getShopCode())
                        .setOpenId(electronicCoupon.getOpenId())
                        .setCouponFlag(1)
                        .setBelongedOpenId(electronicCoupon.getOpenId())
                        .setCouponId(electronicCoupon.getCouponId())
                        .setCouponCode(couponCode.toString() + threeNum)
                        .setCouponEndTime(new Date(new Date().getTime() + 30 * 24 * 60 * 60 * 1000))
                        .setCouponStartTime(new Date())
                        .setLingquTime(new Date())
                        .setCouponState("2")
                        .setCustId(electronicCoupon.getCustId())
                );
            } else {
                //随机生成三位数字
                int threeNum = (int) (Math.random() * 900) + 100;
                //日期戳去掉一位数字,100年以内不会有影响
                couponCode = new Date().getTime() - 1300000000000L;
                list.add(new ElectronicCoupon()
                        .setShopCode(electronicCoupon.getShopCode())
                        .setBelongedOpenId(electronicCoupon.getOpenId())
                        .setCouponFlag(0)
                        .setOpenId(electronicCoupon.getOpenId())
                        .setCouponId(electronicCoupon.getCouponId())
                        .setCouponCode(couponCode.toString() + threeNum)
                        .setCouponEndTime(new Date(new Date().getTime() + 30 * 24 * 60 * 60 * 1000))
                        .setCouponStartTime(new Date())
                        .setCouponState("1")
                );
            }
        }
        if (list.size() > 0) {
            Integer integer = electronicCouponMapper.addCouponCode(list);
        } else {
            DuduExceptionUtil.throwException("领取失败");
        }
        return electronicCoupon.getId();
    }

    /**
     * 微信客户优惠券统计
     *
     * @param electronicCouponParam electronicCouponParam
     * @return 可是使用数目 可赚发数目
     */
    @Override
    public CouponCountResult getWeiXinConponCount(ElectronicCouponParam electronicCouponParam) {
        CouponCountResult couponCountResult = new CouponCountResult();
        electronicCouponParam.setCouponFlag(0);
        couponCountResult.setForwardNum(electronicCouponMapper.getWeiXinConponCount(electronicCouponParam));
        electronicCouponParam.setCouponFlag(1);
        couponCountResult.setUserNum(electronicCouponMapper.getWeiXinConponCount(electronicCouponParam));
        return couponCountResult;
    }

}
