package com.dudu.soa.weixindubbo.user.mapper;

import com.dudu.soa.weixindubbo.user.module.User;

/**
 * Created by Administrator on 2017/3/29.
 */

public interface UserDao {
    /**
     * 根据lmcode查询是否有此用户
     *
     * @param user 用户信息
     * @return 用户信息
     */
    User getUser(User user);

    /**
     * 修改密码
     *
     * @param user 用户实体类
     */
    void updateuser(User user);

    /**
     * 新增用户注册
     *
     * @param user 用户新增
     */
    void adduser(User user);

    /**
     * 删除用户
     *
     * @param user 删除用户
     */
    void delectUser(User user);
}
