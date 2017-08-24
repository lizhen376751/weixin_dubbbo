package com.dudu.soa.weixindubbo.electroniccoupon.service;

import com.dudu.soa.framework.exception.DuduExceptionUtil;
import com.dudu.soa.framework.pagehelp.DuduPageHelpUtil;
import com.dudu.soa.weixindubbo.electroniccoupon.api.ApiElectronicCoupon;
import com.dudu.soa.weixindubbo.electroniccoupon.mapper.CouponConnectItem;
import com.dudu.soa.weixindubbo.electroniccoupon.mapper.CouponTemplateMapper;
import com.dudu.soa.weixindubbo.electroniccoupon.mapper.ElectronicCouponMapper;
import com.dudu.soa.weixindubbo.electroniccoupon.module.CouponConnect;
import com.dudu.soa.weixindubbo.electroniccoupon.module.CouponTemplate;
import com.dudu.soa.weixindubbo.electroniccoupon.module.CouponTemplateParam;
import com.dudu.soa.weixindubbo.electroniccoupon.module.ElectronicCoupon;
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
     * 添加电子优惠券
     * @param electronicCoupon electronicCoupon
     * @return Integer
     */
    @Override
    public Integer addCouponCode(ElectronicCoupon electronicCoupon) {

        return electronicCouponMapper.addCouponCode(electronicCoupon);
    }

}
