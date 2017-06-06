package com.dudu.soa.weixindubbo.alipay.api;

import com.dudu.soa.weixindubbo.alipay.module.AlipayRequestModule;

/**
 * Created by Shinelon on 2017/6/6.
 */
public interface ApiAlipayIntf {
    /**
     * 生成支付宝URL
     * @param requestModule
     * @return
     */
    public String buildAlipayRequest(AlipayRequestModule requestModule);
}
