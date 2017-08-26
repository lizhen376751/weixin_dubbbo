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
import com.dudu.soa.weixindubbo.electroniccoupon.module.ReceiveRecords;
import com.dudu.soa.weixindubbo.electroniccoupon.module.WeiXinCouponInfo;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.WeiXinUserInfo;
import com.dudu.soa.weixindubbo.weixin.http.service.AllWeiXinService;
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
     * 注入AllWeiXinService
     */
    @Autowired
    private AllWeiXinService weiXinService;

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
        String result = "";
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
                result = couponCode.toString() + threeNum;
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


    /**
     * 查看优惠券详情
     *
     * @param electronicCouponParam electronicCouponParam
     * @return List<ElectronicCoupon>
     */
    @Override
    public WeiXinCouponInfo getWXElectronicCouponInfo(ElectronicCouponParam electronicCouponParam) {
        WeiXinCouponInfo wxElectronicCouponInfo = new WeiXinCouponInfo();
        if (null != electronicCouponParam.getCouponFlag()) {
            if (1 == electronicCouponParam.getCouponFlag()) {
                wxElectronicCouponInfo = electronicCouponMapper.getWXElectronicCouponInfo(electronicCouponParam);
            } else if (0 == electronicCouponParam.getCouponFlag()) {
                wxElectronicCouponInfo = electronicCouponMapper.getWXElectronicCouponInfo(electronicCouponParam);
                List<ReceiveRecords> receiveRecordss = queryReceiveRecords(electronicCouponParam);
                if (null != receiveRecordss && null != wxElectronicCouponInfo) {
                    wxElectronicCouponInfo.setList(receiveRecordss);
                }
            }
        } else {
            DuduExceptionUtil.throwException("参数传错!");
        }
        return wxElectronicCouponInfo;
    }

    /**
     * 查询微信端优惠券列表
     *
     * @param electronicCouponParam electronicCouponParam
     * @return List<WeiXinCouponInfo>
     */
    @Override
    public List<WeiXinCouponInfo> queryWXElectronicCouponList(ElectronicCouponParam electronicCouponParam) {
        return electronicCouponMapper.queryWXElectronicCouponList(electronicCouponParam);
    }

    /**
     * 查询领取记录列表
     *
     * @param electronicCouponParam electronicCouponParam
     * @return List<ReceiveRecords>
     */
    @Override
    public List<ReceiveRecords> queryReceiveRecords(ElectronicCouponParam electronicCouponParam) {

        List<ReceiveRecords> receiveRecords = electronicCouponMapper.queryReceiveRecords(electronicCouponParam);
        for (ReceiveRecords records : receiveRecords) {
            WeiXinUserInfo weiXinUserInfoByOpenid = weiXinService.getWeiXinUserInfoByOpenid(records.getShopCode(), "", records.getOpenId());
            records.setWeiXinUserName(weiXinUserInfoByOpenid.getNickname());
        }
        return receiveRecords;
    }

    @Override
    @Transactional
    public Integer lingQuCoupon(ElectronicCoupon electronicCoupon) {
        int result =0;
        ElectronicCouponParam param1 = new ElectronicCouponParam();
        param1.setBelongedOpenId(electronicCoupon.getBelongedOpenId());
//        electronicCoupon.setCouponId(electronicCoupon.getCouponId());
        param1.setShopCode(electronicCoupon.getShopCode());
        electronicCoupon.setCouponId(electronicCoupon.getCouponId());
        param1.setCouponFlag(0);
        Integer canLingQuNum = electronicCouponMapper.getWeiXinConponCount(param1);
        if (canLingQuNum > 0) {
            ElectronicCouponParam param2 = new ElectronicCouponParam();
            param2.setShopCode(electronicCoupon.getShopCode());
            param2.setCouponId(electronicCoupon.getCouponId());
            param2.setOpenId(electronicCoupon.getOpenId());
            param2.setCouponState("2");
            Integer whetherYiLing = electronicCouponMapper.getWeiXinConponCount(param2);
            if (whetherYiLing > 0) {
                DuduExceptionUtil.throwException("你已领取该优惠券!");
            } else {
                CouponTemplateParam param3 = new CouponTemplateParam();
                param3.setCouponId(electronicCoupon.getCouponId());
                CouponTemplate couponById = getCouponById(param3);
                electronicCoupon.setCouponEndTime(couponById.getValidEndTime());
                result = electronicCouponMapper.lingQuCoupon(electronicCoupon);
            }
        } else {
            DuduExceptionUtil.throwException("优惠券已领完!");
        }
        return result;
    }

}
