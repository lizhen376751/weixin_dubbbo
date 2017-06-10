package com.dudu.soa.weixindubbo.alipay.util.httpclient;


import com.dudu.soa.weixindubbo.alipay.config.AlipayConfig;
import org.apache.commons.httpclient.Header;

import java.io.UnsupportedEncodingException;

/**
 * 响应
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

    /**
     * Get response headers header [ ].
     *
     * @return the header [ ]
     */
    public Header[] getResponseHeaders() {
        return responseHeaders;
    }

    /**
     * Sets response headers.
     *
     * @param responseHeaders the response headers
     */
    public void setResponseHeaders(Header[] responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    /**
     * Get byte result byte [ ].
     *
     * @return the byte [ ]
     */
    public byte[] getByteResult() {
        if (byteResult != null) {
            return byteResult;
        }
        if (stringResult != null) {
            return stringResult.getBytes();
        }
        return null;
    }

    /**
     * Sets byte result.
     *
     * @param byteResult the byte result
     */
    public void setByteResult(byte[] byteResult) {
        this.byteResult = byteResult;
    }
    /**
     * Gets string result.
     *
     * @return the string result
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    public String getStringResult() throws UnsupportedEncodingException {
        if (stringResult != null) {
            return stringResult;
        }
        if (byteResult != null) {
            return new String(byteResult, AlipayConfig.INPUT_CHARSET);
        }
        return null;
    }

    /**
     * Sets string result.
     *
     * @param stringResult the string result
     */
    public void setStringResult(String stringResult) {
        this.stringResult = stringResult;
    }

}
