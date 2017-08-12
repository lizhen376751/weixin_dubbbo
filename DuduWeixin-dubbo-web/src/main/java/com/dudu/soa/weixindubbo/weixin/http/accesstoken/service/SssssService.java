package com.dudu.soa.weixindubbo.weixin.http.accesstoken.service;

import com.dudu.soa.weixindubbo.weixin.http.accesstoken.mapper.AccessTokenDao;
import com.dudu.soa.weixindubbo.weixin.http.module.parammodule.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/12.
 */
@Service
public class SssssService {
    /**
     * token信息的dao层
     */
    @Autowired
    private AccessTokenDao accessTokenDao;

    /**
     * 获取微信的token
     *
     * @param accessToken 微信的token
     * @return token信息
     */
    public AccessToken getAccessToken(AccessToken accessToken){
        return accessTokenDao.getAccessToken(accessToken);
    }

    /**
     * 新增微信的token
     *
     * @param accessToken 微信的token
     * @return 主键id
     */
   public Integer addAccessToken(AccessToken accessToken){
        return accessTokenDao.addAccessToken(accessToken);
    }

    /**
     * 修改微信token
     *
     * @param accessToken 微信的token
     * @return 主键id
     */
    public Integer updateAccessToken(AccessToken accessToken){
        return accessTokenDao.updateAccessToken(accessToken);
    }

    /**
     * 微信的token
     *
     * @param accessToken 微信token
     * @return 主键id
     */
    public Integer deletAccessToken(AccessToken accessToken){
        return accessTokenDao.deletAccessToken(accessToken);
    }
}
