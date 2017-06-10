package com.dudu.soa.weixindubbo.weixin.weixinconfig.api;


import com.dudu.soa.weixindubbo.weixin.weixinconfig.module.WeiXinConfig;

/**
 * 微信的相关配置
 * Created by lizhen on 2017/4/20.
 */
public interface ApiWeiXinConfig {
    /**
     * 获取微信公众号
     *
     * @param code 编码
     * @return 实体 wei xin config
     */
    WeiXinConfig getWeiXinConfig(String code);

    /**
     * 新增微信公众号
     *
     * @param weiXinConfig 实体
     * @return 新增的实体类 integer
     */
    Integer addWeiXinConfig(WeiXinConfig weiXinConfig);

    /**
     * 修改微信公众号
     *
     * @param weiXinConfig 实体
     * @return 修改的实体类 integer
     */
    Integer updateWeiXinConfig(WeiXinConfig weiXinConfig);

    /**
     * 删除公众账号
     *
     * @param weiXinConfig 实体
     * @return 实体 integer
     */
    Integer deleteWeiXinConfig(WeiXinConfig weiXinConfig);

}
