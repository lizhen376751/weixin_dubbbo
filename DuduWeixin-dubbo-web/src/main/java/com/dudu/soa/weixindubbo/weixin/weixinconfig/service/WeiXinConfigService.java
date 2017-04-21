package com.dudu.soa.weixindubbo.weixin.weixinconfig.service;

import com.dudu.soa.weixindubbo.weixin.weixinconfig.api.ApiWeiXinConfig;
import com.dudu.soa.weixindubbo.weixin.weixinconfig.mapper.WeiXinConfigDao;
import com.dudu.soa.weixindubbo.weixin.weixinconfig.module.WeiXinConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lizhen on 2017/4/20.
 */
@Service
public class WeiXinConfigService implements ApiWeiXinConfig {
    /**
     * 引入dao层
     */
    @Autowired
    private WeiXinConfigDao weiXinConfigDao;

    /**
     * 获取微信公众号
     *
     * @param code 实体
     * @return 实体
     */
    @Override
    public  WeiXinConfig getWeiXinConfig(String code) {
        return weiXinConfigDao.getWeiXinConfig(code);
    }

    /**
     * 新增微信公众号
     *
     * @param weiXinConfig 实体
     * @return 新增的实体类
     */
    @Override
    public Integer addWeiXinConfig(WeiXinConfig weiXinConfig) {
        return weiXinConfigDao.addWeiXinConfig(weiXinConfig);
    }

    /**
     * 修改微信公众号
     *
     * @param weiXinConfig 实体
     * @return 修改的实体类
     */
    @Override
    public Integer updateWeiXinConfig(WeiXinConfig weiXinConfig) {
        return weiXinConfigDao.updateWeiXinConfig(weiXinConfig);
    }

    /**
     * 删除公众账号
     *
     * @param weiXinConfig 实体
     * @return 实体
     */
    @Override
    public Integer deleteWeiXinConfig(WeiXinConfig weiXinConfig) {
        return weiXinConfigDao.deleteWeiXinConfig(weiXinConfig);
    }
}
