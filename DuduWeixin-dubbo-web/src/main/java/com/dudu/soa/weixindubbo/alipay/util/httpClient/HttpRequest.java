package com.dudu.soa.weixindubbo.alipay.util.httpClient;

import org.apache.commons.httpclient.NameValuePair;

/* *
 *绫诲悕锛欻ttpRequest
 *鍔熻兘锛欻ttp璇锋眰瀵硅薄鐨勫皝瑁�
 *璇︾粏锛氬皝瑁匟ttp璇锋眰
 *鐗堟湰锛�3.3
 *鏃ユ湡锛�2011-08-17
 *璇存槑锛�
 *浠ヤ笅浠ｇ爜鍙槸涓轰簡鏂逛究鍟嗘埛娴嬭瘯鑰屾彁渚涚殑鏍蜂緥浠ｇ爜锛屽晢鎴峰彲浠ユ牴鎹嚜宸辩綉绔欑殑闇�瑕侊紝鎸夌収鎶�鏈枃妗ｇ紪鍐�,骞堕潪涓�瀹氳浣跨敤璇ヤ唬鐮併��
 *璇ヤ唬鐮佷粎渚涘涔犲拰鐮旂┒鏀粯瀹濇帴鍙ｄ娇鐢紝鍙槸鎻愪緵涓�涓弬鑰冦��
 */

public class HttpRequest {

    /** HTTP GET method */
    public static final String METHOD_GET        = "GET";

    /** HTTP POST method */
    public static final String METHOD_POST       = "POST";

    /**
     * 寰呰姹傜殑url
     */
    private String             url               = null;

    /**
     * 榛樿鐨勮姹傛柟寮�
     */
    private String             method            = METHOD_POST;

    private int                timeout           = 0;

    private int                connectionTimeout = 0;

    /**
     * Post鏂瑰紡璇锋眰鏃剁粍瑁呭ソ鐨勫弬鏁板�煎
     */
    private NameValuePair[]    parameters        = null;

    /**
     * Get鏂瑰紡璇锋眰鏃跺搴旂殑鍙傛暟
     */
    private String             queryString       = null;

    /**
     * 榛樿鐨勮姹傜紪鐮佹柟寮�
     */
    private String             charset           = "GBK";

    /**
     * 璇锋眰鍙戣捣鏂圭殑ip鍦板潃
     */
    private String             clientIp;

    /**
     * 璇锋眰杩斿洖鐨勬柟寮�
     */
    private HttpResultType     resultType        = HttpResultType.BYTES;

    public HttpRequest(HttpResultType resultType) {
        super();
        this.resultType = resultType;
    }

    /**
     * @return Returns the clientIp.
     */
    public String getClientIp() {
        return clientIp;
    }

    /**
     * @param clientIp The clientIp to set.
     */
    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public NameValuePair[] getParameters() {
        return parameters;
    }

    public void setParameters(NameValuePair[] parameters) {
        this.parameters = parameters;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    /**
     * @return Returns the charset.
     */
    public String getCharset() {
        return charset;
    }

    /**
     * @param charset The charset to set.
     */
    public void setCharset(String charset) {
        this.charset = charset;
    }

    public HttpResultType getResultType() {
        return resultType;
    }

    public void setResultType(HttpResultType resultType) {
        this.resultType = resultType;
    }

}
