package com.dudu.soa.weixindubbo.alipay.util;

import com.dudu.soa.weixindubbo.alipay.config.AlipayConfig;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.methods.multipart.FilePartSource;
import org.apache.commons.httpclient.methods.multipart.PartSource;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


/**
 * 支付宝支付
 */
public final class AlipayCore {

    private AlipayCore() {
    }

    /**
     * 闄ゅ幓鏁扮粍涓殑绌哄�煎拰绛惧悕鍙傛暟
     *
     * @param sArray 绛惧悕鍙傛暟缁�
     * @return 鍘绘帀绌哄�间笌绛惧悕鍙傛暟鍚庣殑鏂扮鍚嶅弬鏁扮粍
     */
    public static Map<String, String> paraFilter(Map<String, String> sArray) {

        Map<String, String> result = new HashMap<String, String>();

        if (sArray == null || sArray.size() <= 0) {
            return result;
        }

        for (String key : sArray.keySet()) {
            String value = sArray.get(key);
            if (value == null || value.equals("") || key.equalsIgnoreCase("sign")
                    || key.equalsIgnoreCase("sign_type")) {
                continue;
            }
            result.put(key, value);
        }

        return result;
    }

    /**
     * 鎶婃暟缁勬墍鏈夊厓绱犳帓搴忥紝骞舵寜鐓р�滃弬鏁�=鍙傛暟鍊尖�濈殑妯″紡鐢ㄢ��&鈥濆瓧绗︽嫾鎺ユ垚瀛楃涓�
     *
     * @param params 闇�瑕佹帓搴忓苟鍙備笌瀛楃鎷兼帴鐨勫弬鏁扮粍
     * @return 鎷兼帴鍚庡瓧绗︿覆
     */
    public static String createLinkString(Map<String, String> params) {

        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        String prestr = "";

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);

            if (i == keys.size() - 1) { //鎷兼帴鏃讹紝涓嶅寘鎷渶鍚庝竴涓�&瀛楃
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }

        return prestr;
    }

    /**
     * 鍐欐棩蹇楋紝鏂逛究娴嬭瘯锛堢湅缃戠珯闇�姹傦紝涔熷彲浠ユ敼鎴愭妸璁板綍瀛樺叆鏁版嵁搴擄級
     *
     * @param sWord 瑕佸啓鍏ユ棩蹇楅噷鐨勬枃鏈唴瀹�
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(AlipayConfig.LOG_PATH + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Gets abstract.
     *
     * @param strFilePath the str file path
     * @param fileType    the file type
     * @return 结果 abstract
     * @throws IOException the io exception
     */
    public static String getAbstract(String strFilePath, String fileType) throws IOException {
        PartSource file = new FilePartSource(new File(strFilePath));
        if (fileType.equals("MD5")) {
            return DigestUtils.md5Hex(file.createInputStream());
        } else if (fileType.equals("SHA")) {
            return DigestUtils.sha256Hex(file.createInputStream());
        } else {
            return "";
        }
    }
}
