package com.dudu.soa.weixindubbo.user.service;

import com.dudu.soa.weixindubbo.user.api.ApiUser;
import com.dudu.soa.weixindubbo.user.mapper.UserDao;
import com.dudu.soa.weixindubbo.user.module.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/3/29.
 */
@Service
public class UserService implements ApiUser {
    /**
     * 引入dao层
     */
    @Autowired
    private UserDao userDao;

    /**
     * 根据lmcode查询是否有此用户
     *
     * @param user 用户信息
     * @return 用户信息
     */
    @Override
    public User getUser(User user) {
        User user1 = userDao.getUser(user);
        String s = TestMD5.jM(user1.getPassword());
        user1.setPassword(s);
        return user1;
    };

    /**
     * 修改密码
     *
     * @param user 用户实体类
     */
    @Override
    @Transactional
    public void updateuser(User user) {
        userDao.updateuser(user);
    };

    /**
     * 新增用户注册
     *
     * @param user 用户新增
     */
    @Override
    @Transactional
    public void adduser(User user) {
        userDao.adduser(user);
    };

    /**
     * 删除用户
     *
     * @param user 删除用户
     */
    @Override
    @Transactional
    public void delectUser(User user) {
        userDao.delectUser(user);
    };
}
