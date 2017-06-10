package com.dudu.soa.weixindubbo.alipay.util.httpclient;

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

/**
 * The type Http request.
 */
public class HttpRequest {

    /**
     * HTTP GET method
     */
    public static final String METHOD_GET        = "GET";

    /**
     * HTTP POST method
     */
    public static final String METHOD_POST       = "POST";

    /**
     * 寰呰姹傜殑url
     */
    private String             url               = null;

    /**
     * 榛樿鐨勮姹傛柟寮�
     */
    private String             method            = METHOD_POST;
    /**
     *timeout
     */
    private int                timeout           = 0;
    /**
     * connectionTimeout
     */
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

    /**
     * Instantiates a new Http request.
     *
     * @param resultType the result type
     */
    public HttpRequest(HttpResultType resultType) {
        super();
        this.resultType = resultType;
    }

    /**
     * Gets client ip.
     *
     * @return Returns the clientIp.
     */
    public String getClientIp() {
        return clientIp;
    }

    /**
     * Sets client ip.
     *
     * @param clientIp The clientIp to set.
     */
    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    /**
     * Get parameters name value pair [ ].
     *
     * @return the name value pair [ ]
     */
    public NameValuePair[] getParameters() {
        return parameters;
    }

    /**
     * Sets parameters.
     *
     * @param parameters the parameters
     */
    public void setParameters(NameValuePair[] parameters) {
        this.parameters = parameters;
    }

    /**
     * Gets query string.
     *
     * @return the query string
     */
    public String getQueryString() {
        return queryString;
    }

    /**
     * Sets query string.
     *
     * @param queryString the query string
     */
    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets method.
     *
     * @return the method
     */
    public String getMethod() {
        return method;
    }

    /**
     * Sets method.
     *
     * @param method the method
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * Gets connection timeout.
     *
     * @return the connection timeout
     */
    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    /**
     * Sets connection timeout.
     *
     * @param connectionTimeout the connection timeout
     */
    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    /**
     * Gets timeout.
     *
     * @return the timeout
     */
    public int getTimeout() {
        return timeout;
    }

    /**
     * Sets timeout.
     *
     * @param timeout the timeout
     */
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    /**
     * Gets charset.
     *
     * @return Returns the charset.
     */
    public String getCharset() {
        return charset;
    }

    /**
     * Sets charset.
     *
     * @param charset The charset to set.
     */
    public void setCharset(String charset) {
        this.charset = charset;
    }

    /**
     * Gets result type.
     *
     * @return the result type
     */
    public HttpResultType getResultType() {
        return resultType;
    }

    /**
     * Sets result type.
     *
     * @param resultType the result type
     */
    public void setResultType(HttpResultType resultType) {
        this.resultType = resultType;
    }

}
