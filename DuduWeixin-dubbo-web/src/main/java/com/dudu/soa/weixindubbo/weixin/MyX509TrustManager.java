package com.dudu.soa.weixindubbo.weixin;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * https协议通过X509TrustManager接口实现自己创建的证书
 */
public class MyX509TrustManager implements X509TrustManager {
    /**
     * @param chain    不知道
     * @param authType 不知道
     * @throws CertificateException 不知道
     */
    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    /**
     * @param chain    不知道
     * @param authType 不知道
     * @throws CertificateException 不知道
     */
    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
    }

    /**
     * @return 不知道
     */
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}