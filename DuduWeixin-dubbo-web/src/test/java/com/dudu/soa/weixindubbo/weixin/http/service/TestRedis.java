package com.dudu.soa.weixindubbo.weixin.http.service;


import com.dudu.soa.weixindubbo.weixin.http.util.RedisUtil;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * redis测试
 * Created by lizhen on 2017/6/10.
 */
public class TestRedis {
    private static Logger log = LoggerFactory.getLogger(TestRedis.class);
    private Jedis jedis;

    @Before
    public void setup() {
        //连接redis服务器，192.168.0.100:6379
        jedis = new Jedis("127.0.0.1", 6379);
        //权限认证
//        jedis.auth("admin");
    }

    /**
     * redis存储字符串
     */
    @Test
    public void testString() {
        //-----添加数据----------
        jedis.set("name", "xinxin");//向key-->name中放入了value-->xinxin
        log.info("================================" + jedis.get("name"));//执行结果：xinxin

        jedis.append("name", " is my lover"); //拼接
        log.info("================================" + jedis.get("name"));

        jedis.del("name");  //删除某个键
        log.info("================================" + jedis.get("name"));
        //设置多个键值对
        jedis.mset("name", "liuling", "age", "23", "qq", "476777XXX");
        jedis.incr("age"); //进行加1操作
        log.info("================================" + jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));

    }

    /**
     * redis操作Map
     */
    @Test
    public void testMap() {

        //-----添加数据----------
        Map<String, String> map = new HashMap<String, String>();
        map.put("access_token", "reLWdjH_RIXaBcuaWFh7w_f5ug_Ix7x2yccQOO3gKGWAn7FUeAD4InUG3scIhlgvt_krciC3NKyB8tWviLL9316-N6ajP6iBnT-eH9NBDL8JWZjAIAREH");
        long time = new Date().getTime();
        map.put("expires_in", String.valueOf(time-7300));
        jedis.hmset("0533001", map);
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("access_token", "reLWdjH_RIXaBcuaWFh7w_f5ug_Ix7x2yccQOO3gKGWAn7FUeAD4InUG3scIhlgvt_krciC3NKyB8tWviLL9316-N6ajP6iBnT-eH9NBDL8JWZjAIAREH");
        map2.put("expires_in", String.valueOf(time-7300));
        jedis.hmset("0533002", map2);
        //取出user中的name，执行结果:[minxr]-->注意结果是一个泛型的List
        //第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数
        List<String> rsmap = jedis.hmget("0533001", "access_token", "expires_in");
        log.info("================================" + rsmap.get(1));
        if (rsmap.size()>0){
            List<String> listaccess_token = jedis.hmget("0533001", "access_token");
            String access_token = listaccess_token.get(0);
            List<String> listexpires_in = jedis.hmget("0533001", "expires_in");
            String expires_in = listexpires_in.get(0);
            //当大于7200秒的时候,说明已经过期
            if (time-Long.parseLong(expires_in)>7200){
                jedis.hlen("0533001");
                //TODO 重新获取access_token
                //将重新获取的access_token存入到redis中
                access_token = "重新获取的access_token";
                expires_in = String.valueOf(time)+"刚获取的时间";
                map.put("access_token", access_token);
                map.put("expires_in", expires_in);
                jedis.hmset("0533001", map);

            }
        }
        List<String> rsmap1 = jedis.hmget("0533001", "access_token", "expires_in");
        List<String> rsmap2 = jedis.hmget("0533002", "access_token", "expires_in");
        log.info("================================" + rsmap1);
        log.info("================================" + rsmap2);


//        //-----添加数据----------
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("name", "xinxin");
//        map.put("age", "22");
//        map.put("qq", "123456");
//        jedis.hmset("user", map);
//        //取出user中的name，执行结果:[minxr]-->注意结果是一个泛型的List
//        //第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数
//        List<String> rsmap = jedis.hmget("user", "name", "age", "qq");
//        System.out.println("================================" + rsmap);

        //删除map中的某个键值
        jedis.hdel("user", "age");
        System.out.println("================================" + jedis.hmget("user", "age")); //因为删除了，所以返回的是null
        System.out.println("================================" + jedis.hlen("user")); //返回key为user的键中存放的值的个数2
        System.out.println("================================" + jedis.exists("user"));//是否存在key为user的记录 返回true
        System.out.println("================================" + jedis.hkeys("user"));//返回map对象中的所有key
        System.out.println("================================" + jedis.hvals("user"));//返回map对象中的所有value

        Iterator<String> iter = jedis.hkeys("user").iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            System.out.println("================================" + key + ":" + jedis.hmget("user", key));
        }
    }

    /**
     * jedis操作List
     */
    @Test
    public void testList() {
        //开始前，先移除所有的内容
        jedis.del("java framework");
        System.out.println(jedis.lrange("java framework", 0, -1));
        //先向key java framework中存放三条数据
        jedis.lpush("java framework", "spring");
        jedis.lpush("java framework", "struts");
        jedis.lpush("java framework", "hibernate");
        //再取出所有数据jedis.lrange是按范围取出，
        // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
        System.out.println(jedis.lrange("java framework", 0, -1));

        jedis.del("java framework");
        jedis.rpush("java framework", "spring");
        jedis.rpush("java framework", "struts");
        jedis.rpush("java framework", "hibernate");
        System.out.println(jedis.lrange("java framework", 0, -1));
    }


    @Test
    public void test() throws InterruptedException {
        //jedis 排序
        //注意，此处的rpush和lpush是List的操作。是一个双向链表（但从表现来看的）
        jedis.del("a");//先清除数据，再加入数据进行测试
        jedis.rpush("a", "1");
        jedis.lpush("a", "6");
        jedis.lpush("a", "3");
        jedis.lpush("a", "9");
        System.out.println(jedis.lrange("a", 0, -1));// [9, 3, 6, 1]
        System.out.println(jedis.sort("a")); //[1, 3, 6, 9]  //输入排序后结果
        System.out.println(jedis.lrange("a", 0, -1));
    }

    @Test
    public void testRedisPool() {
        RedisUtil redisUtil = new RedisUtil();
        redisUtil.getJedis().set("newname", "中文测试");
        System.out.println(redisUtil.getJedis().get("newname"));
    }
}
