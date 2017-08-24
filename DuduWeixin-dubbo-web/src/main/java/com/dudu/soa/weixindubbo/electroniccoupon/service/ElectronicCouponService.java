package com.dudu.soa.weixindubbo.electroniccoupon.service;

import com.dudu.soa.framework.exception.DuduExceptionUtil;
import com.dudu.soa.framework.pagehelp.DuduPageHelpUtil;
import com.dudu.soa.weixindubbo.electroniccoupon.api.ApiElectronicCoupon;
import com.dudu.soa.weixindubbo.electroniccoupon.mapper.CouponConnectItem;
import com.dudu.soa.weixindubbo.electroniccoupon.mapper.CouponTemplateMapper;
import com.dudu.soa.weixindubbo.electroniccoupon.module.CouponConnect;
import com.dudu.soa.weixindubbo.electroniccoupon.module.ElectronicCoupon;
import com.dudu.soa.weixindubbo.electroniccoupon.module.ElectronicCouponParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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
     * 设置电子优惠券模板
     *
     * @param electronicCoupon electronicCoupon
     * @return 返回电子优惠券模板id
     */
    @Override
    @Transactional
    public Integer installCoupon(ElectronicCoupon electronicCoupon) {
        couponTemplateMapper.addCouponTemplate(electronicCoupon);
        CouponConnect couponConnect = new CouponConnect();
        couponConnect.setShopCode(electronicCoupon.getShopCode());
        if (electronicCoupon.getCouponId() > 0) {
            couponConnect.setCouponId(electronicCoupon.getCouponId());
        } else {
            DuduExceptionUtil.throwException("关联失败");
        }
        couponConnect.setServiceCode(electronicCoupon.getServiceCode());
        couponConnect.setServiceFlag(electronicCoupon.getServiceFlag());
        if (StringUtils.hasText(electronicCoupon.getShopCodeLM())) {
            couponConnect.setShopCodeLM(electronicCoupon.getShopCodeLM());
        }
        Integer integer = couponConnectItem.addConnectWithItem(couponConnect);
        logger.debug("result===================>>>>>>>>>>" + integer);
        return electronicCoupon.getCouponId();
    }

    /**
     * 查询优惠券模板列表
     *
     * @param electronicCouponParam electronicCouponParam
     * @return List<ElectronicCoupon>
     */
    @Override
    public List<ElectronicCoupon> queryCouponList(ElectronicCouponParam electronicCouponParam) {
        DuduPageHelpUtil.query("createTime desc");
        return couponTemplateMapper.queryCouponTemplateList(electronicCouponParam);
    }

    /**
     * 根据id获取电子优惠券模板
     *
     * @param electronicCouponParam electronicCoupon
     * @return ElectronicCoupon
     */
    @Override
    public ElectronicCoupon getCouponById(ElectronicCouponParam electronicCouponParam) {
        return couponTemplateMapper.getCouponById(electronicCouponParam.getCouponId());
    }

    /**
     * 更新电子优惠券
     *
     * @param electronicCoupon electronicCoupon
     * @return Integer
     */
    @Override
    public Integer updateElectronicCoupon(ElectronicCoupon electronicCoupon) {
        if (null == electronicCoupon.getUpdateUser()) {
            DuduExceptionUtil.throwException("更新人不能为空!");
        }
        return couponTemplateMapper.updateCouponTemplate(electronicCoupon);
    }


}
