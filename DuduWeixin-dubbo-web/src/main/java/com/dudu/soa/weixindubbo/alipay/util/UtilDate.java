package com.dudu.soa.weixindubbo.alipay.util;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 工具类
 */
public final  class UtilDate {

    private UtilDate() {
    }

    /**
     * 骞存湀鏃ユ椂鍒嗙(鏃犱笅鍒掔嚎) yyyyMMddHHmmss
     */
    public static final String DTLONG = "yyyyMMddHHmmss";

    /**
     * 瀹屾暣鏃堕棿 yyyy-MM-dd HH:mm:ss
     */
    public static final String SIMPLE = "yyyy-MM-dd HH:mm:ss";

    /**
     * 骞存湀鏃�(鏃犱笅鍒掔嚎) yyyyMMdd
     */
    public static final String DTSHORT = "yyyyMMdd";


    /**
     * 杩斿洖绯荤粺褰撳墠鏃堕棿(绮剧‘鍒版绉�),浣滀负涓�涓敮涓�鐨勮鍗曠紪鍙�
     *
     * @return 浠yyyMMddHHmmss涓烘牸寮忕殑褰撳墠绯荤粺鏃堕棿
     */
    public static String getOrderNum() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(DTLONG);
        return df.format(date);
    }

    /**
     * 鑾峰彇绯荤粺褰撳墠鏃ユ湡(绮剧‘鍒版绉�)锛屾牸寮忥細yyyy-MM-dd HH:mm:ss
     *
     * @return 1
     */
    public static String getDateFormatter() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(SIMPLE);
        return df.format(date);
    }

    /**
     * 鑾峰彇绯荤粺褰撴湡骞存湀鏃�(绮剧‘鍒板ぉ)锛屾牸寮忥細yyyyMMdd
     *
     * @return 1
     */
    public static String getDate() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(DTSHORT);
        return df.format(date);
    }

    /**
     * 浜х敓闅忔満鐨勪笁浣嶆暟
     *
     * @return 1
     */
    public static String getThree() {
        Random rad = new Random();
        return rad.nextInt(1000) + "";
    }

}
