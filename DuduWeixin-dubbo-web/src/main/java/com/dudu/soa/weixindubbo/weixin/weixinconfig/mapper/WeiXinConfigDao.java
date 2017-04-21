package com.dudu.soa.weixindubbo.weixin.weixinconfig.mapper;

import com.dudu.soa.weixindubbo.weixin.weixinconfig.module.WeiXinConfig;

/**
 * 微信配置的dao层
 * Created by lizhen on 2017/4/20.
 */

public interface WeiXinConfigDao {
    /**
     * 获取微信公众号
     *
     * @param code 实体
     * @return 实体
     */
    WeiXinConfig getWeiXinConfig(String code);

    /**
     * 新增微信公众号
     *
     * @param weiXinConfig 实体
     * @return 新增的实体类
     */
    Integer addWeiXinConfig(WeiXinConfig weiXinConfig);

    /**
     * 修改微信公众号
     *
     * @param weiXinConfig 实体
     * @return 修改的实体类
     */
    Integer updateWeiXinConfig(WeiXinConfig weiXinConfig);

    /**
     * 删除公众账号
     *
     * @param weiXinConfig 实体
     * @return 实体
     */
    Integer deleteWeiXinConfig(WeiXinConfig weiXinConfig);
}
