package com.dudu.soa.weixindubbo.alipay.util.httpClient;


import com.dudu.soa.weixindubbo.alipay.config.AlipayConfig;
import org.apache.commons.httpclient.Header;

import java.io.UnsupportedEncodingException;

/* *
 *绫诲悕锛欻ttpResponse
 *鍔熻兘锛欻ttp杩斿洖瀵硅薄鐨勫皝瑁�
 *璇︾粏锛氬皝瑁匟ttp杩斿洖淇℃伅
 *鐗堟湰锛�3.3
 *鏃ユ湡锛�2011-08-17
 *璇存槑锛�
 *浠ヤ笅浠ｇ爜鍙槸涓轰簡鏂逛究鍟嗘埛娴嬭瘯鑰屾彁渚涚殑鏍蜂緥浠ｇ爜锛屽晢鎴峰彲浠ユ牴鎹嚜宸辩綉绔欑殑闇�瑕侊紝鎸夌収鎶�鏈枃妗ｇ紪鍐�,骞堕潪涓�瀹氳浣跨敤璇ヤ唬鐮併��
 *璇ヤ唬鐮佷粎渚涘涔犲拰鐮旂┒鏀粯瀹濇帴鍙ｄ娇鐢紝鍙槸鎻愪緵涓�涓弬鑰冦��
 */

public class HttpResponse {

    /**
     * 杩斿洖涓殑Header淇℃伅
     */
    private Header[] responseHeaders;

    /**
     * String绫诲瀷鐨剅esult
     */
    private String   stringResult;

    /**
     * btye绫诲瀷鐨剅esult
     */
    private byte[]   byteResult;

    public Header[] getResponseHeaders() {
        return responseHeaders;
    }

    public void setResponseHeaders(Header[] responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    public byte[] getByteResult() {
        if (byteResult != null) {
            return byteResult;
        }
        if (stringResult != null) {
            return stringResult.getBytes();
        }
        return null;
    }

    public void setByteResult(byte[] byteResult) {
        this.byteResult = byteResult;
    }

    public String getStringResult() throws UnsupportedEncodingException {
        if (stringResult != null) {
            return stringResult;
        }
        if (byteResult != null) {
            return new String(byteResult, AlipayConfig.input_charset);
        }
        return null;
    }

    public void setStringResult(String stringResult) {
        this.stringResult = stringResult;
    }

}
