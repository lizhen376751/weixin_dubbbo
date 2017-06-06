package com.dudu.soa.weixindubbo.alipay.util;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/* *
 *绫诲悕锛歎tilDate
 *鍔熻兘锛氳嚜瀹氫箟璁㈠崟绫�
 *璇︾粏锛氬伐鍏风被锛屽彲浠ョ敤浣滆幏鍙栫郴缁熸棩鏈熴�佽鍗曠紪鍙风瓑
 *鐗堟湰锛�3.3
 *鏃ユ湡锛�2012-08-17
 *璇存槑锛�
 *浠ヤ笅浠ｇ爜鍙槸涓轰簡鏂逛究鍟嗘埛娴嬭瘯鑰屾彁渚涚殑鏍蜂緥浠ｇ爜锛屽晢鎴峰彲浠ユ牴鎹嚜宸辩綉绔欑殑闇�瑕侊紝鎸夌収鎶�鏈枃妗ｇ紪鍐�,骞堕潪涓�瀹氳浣跨敤璇ヤ唬鐮併��
 *璇ヤ唬鐮佷粎渚涘涔犲拰鐮旂┒鏀粯瀹濇帴鍙ｄ娇鐢紝鍙槸鎻愪緵涓�涓弬鑰冦��
 */
public class UtilDate {
	
    /** 骞存湀鏃ユ椂鍒嗙(鏃犱笅鍒掔嚎) yyyyMMddHHmmss */
    public static final String dtLong                  = "yyyyMMddHHmmss";
    
    /** 瀹屾暣鏃堕棿 yyyy-MM-dd HH:mm:ss */
    public static final String simple                  = "yyyy-MM-dd HH:mm:ss";
    
    /** 骞存湀鏃�(鏃犱笅鍒掔嚎) yyyyMMdd */
    public static final String dtShort                 = "yyyyMMdd";
	
    
    /**
     * 杩斿洖绯荤粺褰撳墠鏃堕棿(绮剧‘鍒版绉�),浣滀负涓�涓敮涓�鐨勮鍗曠紪鍙�
     * @return
     *      浠yyyMMddHHmmss涓烘牸寮忕殑褰撳墠绯荤粺鏃堕棿
     */
	public  static String getOrderNum(){
		Date date=new Date();
		DateFormat df=new SimpleDateFormat(dtLong);
		return df.format(date);
	}
	
	/**
	 * 鑾峰彇绯荤粺褰撳墠鏃ユ湡(绮剧‘鍒版绉�)锛屾牸寮忥細yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public  static String getDateFormatter(){
		Date date=new Date();
		DateFormat df=new SimpleDateFormat(simple);
		return df.format(date);
	}
	
	/**
	 * 鑾峰彇绯荤粺褰撴湡骞存湀鏃�(绮剧‘鍒板ぉ)锛屾牸寮忥細yyyyMMdd
	 * @return
	 */
	public static String getDate(){
		Date date=new Date();
		DateFormat df=new SimpleDateFormat(dtShort);
		return df.format(date);
	}
	
	/**
	 * 浜х敓闅忔満鐨勪笁浣嶆暟
	 * @return
	 */
	public static String getThree(){
		Random rad=new Random();
		return rad.nextInt(1000)+"";
	}
	
}
