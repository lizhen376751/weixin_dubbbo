package com.dudu.soa.weixindubbo.alipay.util;


import com.dudu.soa.weixindubbo.alipay.config.AlipayConfig;
import com.dudu.soa.weixindubbo.alipay.sign.MD5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;


/**
 * 唤醒
 */
public final  class AlipayNotify {

    private AlipayNotify() {

    }

    /**
     * 鏀粯瀹濇秷鎭獙璇佸湴鍧�
     */
    private static final String HTTPS_VERIFY_URL = "https://mapi.alipay.com/gateway.do?service=notify_verify&";

    /**
     * 楠岃瘉娑堟伅鏄惁鏄敮浠樺疂鍙戝嚭鐨勫悎娉曟秷鎭�
     *
     * @param params 閫氱煡杩斿洖鏉ョ殑鍙傛暟鏁扮粍
     * @return 楠岃瘉缁撴灉
     */
    public static boolean verify(Map<String, String> params) {

        //鍒ゆ柇responsetTxt鏄惁涓簍rue锛宨sSign鏄惁涓簍rue
        //responsetTxt鐨勭粨鏋滀笉鏄痶rue锛屼笌鏈嶅姟鍣ㄨ缃棶棰樸�佸悎浣滆韩浠借�匢D銆乶otify_id涓�鍒嗛挓澶辨晥鏈夊叧
        //isSign涓嶆槸true锛屼笌瀹夊叏鏍￠獙鐮併�佽姹傛椂鐨勫弬鏁版牸寮忥紙濡傦細甯﹁嚜瀹氫箟鍙傛暟绛夛級銆佺紪鐮佹牸寮忔湁鍏�
        String responseTxt = "true";
        String notifyId = "";

        if (params.get("notifyId") != null) {
            notifyId = params.get("notifyId");
            responseTxt = verifyResponse(notifyId);
        }
        String sign = "";
        if (params.get("sign") != null) {
            sign = params.get("sign");
        }
        boolean isSign = getSignVeryfy(params, sign);

        System.out.println("====鏀粯瀹濆弬鏁�:{sign:" + sign + "},{isSign:" + isSign + "},{notifyId:" + notifyId + "},{responseTxt:" + responseTxt + "}");
        //鍐欐棩蹇楄褰曪紙鑻ヨ璋冭瘯锛岃鍙栨秷涓嬮潰涓よ娉ㄩ噴锛�
        //String sWord = "responseTxt=" + responseTxt + "\n isSign=" + isSign + "\n 杩斿洖鍥炴潵鐨勫弬鏁帮細" + AlipayCore.createLinkString(params);
        //AlipayCore.logResult(sWord);


        //鍐欐棩蹇楄褰曪紙鑻ヨ璋冭瘯锛岃鍙栨秷涓嬮潰涓よ娉ㄩ噴锛�
        //String sWord = "responseTxt=" + responseTxt + "\n isSign=" + isSign + "\n 杩斿洖鍥炴潵鐨勫弬鏁帮細" + AlipayCore.createLinkString(params);
        //AlipayCore.logResult(sWord);


        return  "true".equals(responseTxt) && isSign;
    }

    /**
     * 鏍规嵁鍙嶉鍥炴潵鐨勪俊鎭紝鐢熸垚绛惧悕缁撴灉
     *
     * @param params 閫氱煡杩斿洖鏉ョ殑鍙傛暟鏁扮粍
     * @param sign   姣斿鐨勭鍚嶇粨鏋�
     * @return 鐢熸垚鐨勭鍚嶇粨鏋�
     */
    private static boolean getSignVeryfy(Map<String, String> params, String sign) {
        //杩囨护绌哄�笺�乻ign涓巗ign_type鍙傛暟
        Map<String, String> sParaNew = AlipayCore.paraFilter(params);
        //鑾峰彇寰呯鍚嶅瓧绗︿覆
        String preSignStr = AlipayCore.createLinkString(sParaNew);
        //鑾峰緱绛惧悕楠岃瘉缁撴灉
        boolean isSign = false;
        if (AlipayConfig.SIGN_TYPE.equals("MD5")) {
            System.out.println("鏀粯瀹濋獙璇佺鍚�:{preSignStr:" + preSignStr + "},{sign:" + sign + "},{key:" + AlipayConfig.KEY + "},{input_charset:"
                    + AlipayConfig.INPUT_CHARSET + "}");
            isSign = MD5.verify(preSignStr, sign, AlipayConfig.KEY, AlipayConfig.INPUT_CHARSET);
        }
        return isSign;
    }

    /**
     * 鑾峰彇杩滅▼鏈嶅姟鍣ˋTN缁撴灉,楠岃瘉杩斿洖URL
     *
     * @param notifyId 閫氱煡鏍￠獙ID
     * @return 鏈嶅姟鍣ˋTN缁撴灉
     * 楠岃瘉缁撴灉闆嗭細
     * invalid鍛戒护鍙傛暟涓嶅 鍑虹幇杩欎釜閿欒锛岃妫�娴嬭繑鍥炲鐞嗕腑partner鍜宬ey鏄惁涓虹┖
     * true 杩斿洖姝ｇ‘淇℃伅
     * false 璇锋鏌ラ槻鐏鎴栬�呮槸鏈嶅姟鍣ㄩ樆姝㈢鍙ｉ棶棰樹互鍙婇獙璇佹椂闂存槸鍚﹁秴杩囦竴鍒嗛挓
     */
    private static String verifyResponse(String notifyId) {
        //鑾峰彇杩滅▼鏈嶅姟鍣ˋTN缁撴灉锛岄獙璇佹槸鍚︽槸鏀粯瀹濇湇鍔″櫒鍙戞潵鐨勮姹�

        String partner = AlipayConfig.PARTNER;
        String url = HTTPS_VERIFY_URL + "partner=" + partner + "&notifyId=" + notifyId;

        return checkUrl(url);
    }

    /**
     * 鑾峰彇杩滅▼鏈嶅姟鍣ˋTN缁撴灉
     *
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
