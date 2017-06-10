package com.dudu.soa.weixindubbo.alipay.service;

import com.dudu.soa.weixindubbo.alipay.api.ApiAlipayIntf;
import com.dudu.soa.weixindubbo.alipay.config.AlipayConfig;
import com.dudu.soa.weixindubbo.alipay.module.AlipayRequestModule;
import com.dudu.soa.weixindubbo.alipay.util.AlipayCore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.dudu.soa.weixindubbo.alipay.util.AlipaySubmit.buildRequestMysign;

/**
 * Created by Shinelon on 2017/6/6.
 */
public class AlipayService implements ApiAlipayIntf {
    /**
     *
     */
    private static final String ALIPAY_GATEWAY_NEW = "https://mapi.alipay.com/gateway.do?";

    /**
     * 生成支付宝URL
     *
     * @param requestModule
     * @return
     */
    @Override
    public String buildAlipayRequest(AlipayRequestModule requestModule) {
        return null;
    }

    /**
     * 创建构建
     * @param sParaTemp 参数
     * @return 结果
     */
    private static Map<String, String> buildRequestPara(Map<String, String> sParaTemp) {
        //闄ゅ幓鏁扮粍涓殑绌哄�煎拰绛惧悕鍙傛暟
        Map<String, String> sPara = AlipayCore.paraFilter(sParaTemp);
        //鐢熸垚绛惧悕缁撴灉
        String mysign = buildRequestMysign(sPara);

        //绛惧悕缁撴灉涓庣鍚嶆柟寮忓姞鍏ヨ姹傛彁浜ゅ弬鏁扮粍涓�
        sPara.put("sign", mysign);
        sPara.put("sign_type", AlipayConfig.SIGN_TYPE);

        return sPara;
    }

    /**
     * Build request string.
     *
     * @param sParaTemp     the s para temp
     * @param strMethod     the str method
     * @param strButtonName the str button name
     * @return the string
     */
    public  String buildRequest(Map<String, String> sParaTemp, String strMethod, String strButtonName) {
        //寰呰姹傚弬鏁版暟缁�

        Map<String, String> sPara = buildRequestPara(sParaTemp);
        List<String> keys = new ArrayList<String>(sPara.keySet());

        StringBuffer sbHtml = new StringBuffer();

        sbHtml.append("<form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\"" + ALIPAY_GATEWAY_NEW
                + "_input_charset=" + AlipayConfig.INPUT_CHARSET + "\" method=\"" + strMethod
                + "\">");

        for (int i = 0; i < keys.size(); i++) {
            String name = (String) keys.get(i);
            String value = (String) sPara.get(name);

            sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
        }

        //submit鎸夐挳鎺т欢璇蜂笉瑕佸惈鏈塶ame灞炴��
        sbHtml.append("<input type=\"submit\" value=\"" + strButtonName + "\" style=\"display:none;\"></form>");
        sbHtml.append("<script>document.forms['alipaysubmit'].submit();</script>");

        return sbHtml.toString();
    }

}
