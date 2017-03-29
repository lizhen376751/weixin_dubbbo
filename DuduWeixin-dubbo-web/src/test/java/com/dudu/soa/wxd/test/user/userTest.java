package com.dudu.soa.wxd.test.user;

import com.dudu.soa.weixindubbo.user.module.User;
import com.dudu.soa.weixindubbo.user.service.UserService;
import com.dudu.soa.wxd.test.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/3/29.
 */

public class userTest extends TestBase{
    @Autowired
    private UserService userService;
    @Test
    public void getUser() {
        try{
        User user = new User();
        user.setPlateNumber("鲁A2222");
        user.setLmcode("cs000");
        User user1 = userService.getUser(user);
        System.out.println("====================="+user1);
    }catch (Exception e){
        e.printStackTrace();
        System.out.println("错误信息为:=============="+e.getMessage());
    }
    };

    /**
     * 修改密码
     *
     *
     */
    @Test
    public void updateuser() {
        try{
        User user = new User();
        user.setPlateNumber("鲁A2222");
        user.setLmcode("cs000");
        user.setPassword("4545454");
        userService.updateuser(user);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("错误信息为:=============="+e.getMessage());
        }
    };

    /**
     * 新增用户注册
     *
     *
     */
    @Test
    public void adduser() throws Exception{
        try{
            User user = new User();
            user.setLmcode("cs000");
            user.setMobilePhone("18500003333");
            user.setPassword("56565");
            user.setPlateNumber("鲁A2222");
            userService.adduser(user);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("错误信息为:=============="+e.getMessage());
        }

    };

    /**
     * 删除用户
     *
     *
     */
    @Test
    public void delectUser() {
        try{
        User user = new User();
        user.setPlateNumber("鲁A2222");
        user.setLmcode("cs000");
        userService.delectUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    };
}
