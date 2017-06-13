package com.dudu.soa.weixindubbo.weixin.http.util;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by lizhen on 2017/6/10.
 */
public final class RedisUtil {

    /**
     * Redis服务器IP
     */
    private static String addr = "127.0.0.1";
//118.178.132.84     127.0.0.1:6379
    /**
     * Redis的端口号
     */
    private static int port = 6379;


    /**
     * 访问密码
     */
    private static String auth = "admin";

    /**
     * 可用连接实例的最大数目，默认值为8；
     * 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
     */
    private static int maxActive = 1024;

    /**
     * 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
     */
    private static int maxIdle = 200;

    /**
     * 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
     */
    private static int maxWait = 100000;
    /**
     *
     */
    private static int timeOut = 100000;

    /**
     * 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
     */
    private static boolean testOnBorrow = true;
    /**
     *
     */
    private static JedisPool jedisPool = null;

    /**
     * 初始化Redis连接池
     */
    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxIdle(maxIdle);
            config.setTestOnBorrow(testOnBorrow);
            jedisPool = new JedisPool(config, addr, port, timeOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放jedis资源
     *
     * @param jedis ..
     */
    public static void returnResource(final Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }

    /**
     * 获取Jedis实例
     *
     * @return ..
     */
    public Jedis getJedis() {
        try {
            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
