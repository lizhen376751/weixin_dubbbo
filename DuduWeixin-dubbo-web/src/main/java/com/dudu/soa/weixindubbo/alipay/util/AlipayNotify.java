package com.dudu.soa.weixindubbo.alipay.util;


import com.dudu.soa.weixindubbo.alipay.config.AlipayConfig;
import com.dudu.soa.weixindubbo.alipay.sign.MD5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;


/* *
 *绫诲悕锛欰lipayNotify
 *鍔熻兘锛氭敮浠樺疂閫氱煡澶勭悊绫�
 *璇︾粏锛氬鐞嗘敮浠樺疂鍚勬帴鍙ｉ�氱煡杩斿洖
 *鐗堟湰锛�3.3
 *鏃ユ湡锛�2012-08-17
 *璇存槑锛�
 *浠ヤ笅浠ｇ爜鍙槸涓轰簡鏂逛究鍟嗘埛娴嬭瘯鑰屾彁渚涚殑鏍蜂緥浠ｇ爜锛屽晢鎴峰彲浠ユ牴鎹嚜宸辩綉绔欑殑闇�瑕侊紝鎸夌収鎶�鏈枃妗ｇ紪鍐�,骞堕潪涓�瀹氳浣跨敤璇ヤ唬鐮併��
 *璇ヤ唬鐮佷粎渚涘涔犲拰鐮旂┒鏀粯瀹濇帴鍙ｄ娇鐢紝鍙槸鎻愪緵涓�涓弬鑰�

 *************************娉ㄦ剰*************************
 *璋冭瘯閫氱煡杩斿洖鏃讹紝鍙煡鐪嬫垨鏀瑰啓log鏃ュ織鐨勫啓鍏XT閲岀殑鏁版嵁锛屾潵妫�鏌ラ�氱煡杩斿洖鏄惁姝ｅ父
 */
public class AlipayNotify {



    /**
     * 鏀粯瀹濇秷鎭獙璇佸湴鍧�
     */
    private static final String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";

    /**
     * 楠岃瘉娑堟伅鏄惁鏄敮浠樺疂鍙戝嚭鐨勫悎娉曟秷鎭�
     * @param params 閫氱煡杩斿洖鏉ョ殑鍙傛暟鏁扮粍
     * @return 楠岃瘉缁撴灉
     */
    public static boolean verify(Map<String, String> params) {

        //鍒ゆ柇responsetTxt鏄惁涓簍rue锛宨sSign鏄惁涓簍rue
        //responsetTxt鐨勭粨鏋滀笉鏄痶rue锛屼笌鏈嶅姟鍣ㄨ缃棶棰樸�佸悎浣滆韩浠借�匢D銆乶otify_id涓�鍒嗛挓澶辨晥鏈夊叧
        //isSign涓嶆槸true锛屼笌瀹夊叏鏍￠獙鐮併�佽姹傛椂鐨勫弬鏁版牸寮忥紙濡傦細甯﹁嚜瀹氫箟鍙傛暟绛夛級銆佺紪鐮佹牸寮忔湁鍏�
    	String responseTxt = "true";
    	String notify_id = "";
    	
    	if(params.get("notify_id") != null) {
			notify_id = params.get("notify_id");
			responseTxt = verifyResponse(notify_id);
		}
	    String sign = "";
	    if(params.get("sign") != null) {sign = params.get("sign");}
	    boolean isSign = getSignVeryfy(params, sign);
	    
	    System.out.println("====鏀粯瀹濆弬鏁�:{sign:"+sign+"},{isSign:"+isSign+"},{notify_id:"+notify_id+"},{responseTxt:"+responseTxt+"}");
        //鍐欐棩蹇楄褰曪紙鑻ヨ璋冭瘯锛岃鍙栨秷涓嬮潰涓よ娉ㄩ噴锛�
        //String sWord = "responseTxt=" + responseTxt + "\n isSign=" + isSign + "\n 杩斿洖鍥炴潵鐨勫弬鏁帮細" + AlipayCore.createLinkString(params);
	    //AlipayCore.logResult(sWord);
	

        //鍐欐棩蹇楄褰曪紙鑻ヨ璋冭瘯锛岃鍙栨秷涓嬮潰涓よ娉ㄩ噴锛�
        //String sWord = "responseTxt=" + responseTxt + "\n isSign=" + isSign + "\n 杩斿洖鍥炴潵鐨勫弬鏁帮細" + AlipayCore.createLinkString(params);
	    //AlipayCore.logResult(sWord);

        if (isSign && responseTxt.equals("true")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 鏍规嵁鍙嶉鍥炴潵鐨勪俊鎭紝鐢熸垚绛惧悕缁撴灉
     * @param Params 閫氱煡杩斿洖鏉ョ殑鍙傛暟鏁扮粍
     * @param sign 姣斿鐨勭鍚嶇粨鏋�
     * @return 鐢熸垚鐨勭鍚嶇粨鏋�
     */
	private static boolean getSignVeryfy(Map<String, String> Params, String sign) {
    	//杩囨护绌哄�笺�乻ign涓巗ign_type鍙傛暟
    	Map<String, String> sParaNew = AlipayCore.paraFilter(Params);
        //鑾峰彇寰呯鍚嶅瓧绗︿覆
        String preSignStr = AlipayCore.createLinkString(sParaNew);
        //鑾峰緱绛惧悕楠岃瘉缁撴灉
        boolean isSign = false;
        if(AlipayConfig.sign_type.equals("MD5") ) {
        	System.out.println("鏀粯瀹濋獙璇佺鍚�:{preSignStr:"+preSignStr+"},{sign:"+sign+"},{key:"+AlipayConfig.key+"},{input_charset:"
      +AlipayConfig.input_charset+"}");
        	isSign = MD5.verify(preSignStr, sign, AlipayConfig.key, AlipayConfig.input_charset);
        }
        return isSign;
    }

    /**
    * 鑾峰彇杩滅▼鏈嶅姟鍣ˋTN缁撴灉,楠岃瘉杩斿洖URL
    * @param notify_id 閫氱煡鏍￠獙ID
    * @return 鏈嶅姟鍣ˋTN缁撴灉
    * 楠岃瘉缁撴灉闆嗭細
    * invalid鍛戒护鍙傛暟涓嶅 鍑虹幇杩欎釜閿欒锛岃妫�娴嬭繑鍥炲鐞嗕腑partner鍜宬ey鏄惁涓虹┖ 
    * true 杩斿洖姝ｇ‘淇℃伅
    * false 璇锋鏌ラ槻鐏鎴栬�呮槸鏈嶅姟鍣ㄩ樆姝㈢鍙ｉ棶棰樹互鍙婇獙璇佹椂闂存槸鍚﹁秴杩囦竴鍒嗛挓
    */
    private static String verifyResponse(String notify_id) {
        //鑾峰彇杩滅▼鏈嶅姟鍣ˋTN缁撴灉锛岄獙璇佹槸鍚︽槸鏀粯瀹濇湇鍔″櫒鍙戞潵鐨勮姹�

        String partner = AlipayConfig.partner;
        String veryfy_url = HTTPS_VERIFY_URL + "partner=" + partner + "&notify_id=" + notify_id;

        return checkUrl(veryfy_url);
    }

    /**
    * 鑾峰彇杩滅▼鏈嶅姟鍣ˋTN缁撴灉
    * @param urlvalue 鎸囧畾URL璺緞鍦板潃
    * @return 鏈嶅姟鍣ˋTN缁撴灉
    * 楠岃瘉缁撴灉闆嗭細
    * invalid鍛戒护鍙傛暟涓嶅 鍑虹幇杩欎釜閿欒锛岃妫�娴嬭繑鍥炲鐞嗕腑partner鍜宬ey鏄惁涓虹┖ 
    * true 杩斿洖姝ｇ‘淇℃伅
    * false 璇锋鏌ラ槻鐏鎴栬�呮槸鏈嶅姟鍣ㄩ樆姝㈢鍙ｉ棶棰樹互鍙婇獙璇佹椂闂存槸鍚﹁秴杩囦竴鍒嗛挓
    */
    private static String checkUrl(String urlvalue) {
        String inputLine = "";

        try {
            URL url = new URL(urlvalue);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection
                .getInputStream()));
            inputLine = in.readLine().toString();
        } catch (Exception e) {
            e.printStackTrace();
            inputLine = "";
        }

        return inputLine;
    }
}
