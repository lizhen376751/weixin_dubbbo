package com.dudu.soa.weixindubbo.alipay.util;


import com.dudu.soa.weixindubbo.alipay.config.AlipayConfig;
import com.dudu.soa.weixindubbo.alipay.sign.MD5;
import com.dudu.soa.weixindubbo.alipay.util.httpClient.HttpProtocolHandler;
import com.dudu.soa.weixindubbo.alipay.util.httpClient.HttpRequest;
import com.dudu.soa.weixindubbo.alipay.util.httpClient.HttpResponse;
import com.dudu.soa.weixindubbo.alipay.util.httpClient.HttpResultType;
import org.apache.commons.httpclient.NameValuePair;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/* *
 *绫诲悕锛欰lipaySubmit
 *鍔熻兘锛氭敮浠樺疂鍚勬帴鍙ｈ姹傛彁浜ょ被
 *璇︾粏锛氭瀯閫犳敮浠樺疂鍚勬帴鍙ｈ〃鍗旽TML鏂囨湰锛岃幏鍙栬繙绋婬TTP鏁版嵁
 *鐗堟湰锛�3.3
 *鏃ユ湡锛�2012-08-13
 *璇存槑锛�
 *浠ヤ笅浠ｇ爜鍙槸涓轰簡鏂逛究鍟嗘埛娴嬭瘯鑰屾彁渚涚殑鏍蜂緥浠ｇ爜锛屽晢鎴峰彲浠ユ牴鎹嚜宸辩綉绔欑殑闇�瑕侊紝鎸夌収鎶�鏈枃妗ｇ紪鍐�,骞堕潪涓�瀹氳浣跨敤璇ヤ唬鐮併��
 *璇ヤ唬鐮佷粎渚涘涔犲拰鐮旂┒鏀粯瀹濇帴鍙ｄ娇鐢紝鍙槸鎻愪緵涓�涓弬鑰冦��
 */

public class AlipaySubmit {
    
    /**
     * 鏀粯瀹濇彁渚涚粰鍟嗘埛鐨勬湇鍔℃帴鍏ョ綉鍏砋RL(鏂�)
     */
    private static final String ALIPAY_GATEWAY_NEW = "https://mapi.alipay.com/gateway.do?";
	
    /**
     * 鐢熸垚绛惧悕缁撴灉
     * @param sPara 瑕佺鍚嶇殑鏁扮粍
     * @return 绛惧悕缁撴灉瀛楃涓�
     */
	public static String buildRequestMysign(Map<String, String> sPara) {
    	String prestr = AlipayCore.createLinkString(sPara); //鎶婃暟缁勬墍鏈夊厓绱狅紝鎸夌収鈥滃弬鏁�=鍙傛暟鍊尖�濈殑妯″紡鐢ㄢ��&鈥濆瓧绗︽嫾鎺ユ垚瀛楃涓�
        String mysign = "";
        if(AlipayConfig.sign_type.equals("MD5") ) {
        	mysign = MD5.sign(prestr, AlipayConfig.key, AlipayConfig.input_charset);
        }
        return mysign;
    }
	
    /**
     * 鐢熸垚瑕佽姹傜粰鏀粯瀹濈殑鍙傛暟鏁扮粍
     * @param sParaTemp 璇锋眰鍓嶇殑鍙傛暟鏁扮粍
     * @return 瑕佽姹傜殑鍙傛暟鏁扮粍
     */
    private static Map<String, String> buildRequestPara(Map<String, String> sParaTemp) {
        //闄ゅ幓鏁扮粍涓殑绌哄�煎拰绛惧悕鍙傛暟
        Map<String, String> sPara = AlipayCore.paraFilter(sParaTemp);
        //鐢熸垚绛惧悕缁撴灉
        String mysign = buildRequestMysign(sPara);

        //绛惧悕缁撴灉涓庣鍚嶆柟寮忓姞鍏ヨ姹傛彁浜ゅ弬鏁扮粍涓�
        sPara.put("sign", mysign);
        sPara.put("sign_type", AlipayConfig.sign_type);

        return sPara;
    }

    /**
     * 寤虹珛璇锋眰锛屼互琛ㄥ崟HTML褰㈠紡鏋勯�狅紙榛樿锛�
     * @param sParaTemp 璇锋眰鍙傛暟鏁扮粍
     * @param strMethod 鎻愪氦鏂瑰紡銆備袱涓�煎彲閫夛細post銆乬et
     * @param strButtonName 纭鎸夐挳鏄剧ず鏂囧瓧
     * @return 鎻愪氦琛ㄥ崟HTML鏂囨湰
     */
    public static String buildRequest(Map<String, String> sParaTemp, String strMethod, String strButtonName) {
        //寰呰姹傚弬鏁版暟缁�
    	
        Map<String, String> sPara = buildRequestPara(sParaTemp);
        List<String> keys = new ArrayList<String>(sPara.keySet());

        StringBuffer sbHtml = new StringBuffer();

        sbHtml.append("<form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\"" + ALIPAY_GATEWAY_NEW
                      + "_input_charset=" + AlipayConfig.input_charset + "\" method=\"" + strMethod
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
    
    /**
     * 寤虹珛璇锋眰锛屼互琛ㄥ崟HTML褰㈠紡鏋勯�狅紝甯︽枃浠朵笂浼犲姛鑳�
     * @param sParaTemp 璇锋眰鍙傛暟鏁扮粍
     * @param strMethod 鎻愪氦鏂瑰紡銆備袱涓�煎彲閫夛細post銆乬et
     * @param strButtonName 纭鎸夐挳鏄剧ず鏂囧瓧
     * @param strParaFileName 鏂囦欢涓婁紶鐨勫弬鏁板悕
     * @return 鎻愪氦琛ㄥ崟HTML鏂囨湰
     */
    public static String buildRequest(Map<String, String> sParaTemp, String strMethod, String strButtonName, String strParaFileName) {
        //寰呰姹傚弬鏁版暟缁�
        Map<String, String> sPara = buildRequestPara(sParaTemp);
        List<String> keys = new ArrayList<String>(sPara.keySet());

        StringBuffer sbHtml = new StringBuffer();

        sbHtml.append("<form id=\"alipaysubmit\" name=\"alipaysubmit\"  enctype=\"multipart/form-data\" action=\"" + ALIPAY_GATEWAY_NEW
                      + "_input_charset=" + AlipayConfig.input_charset + "\" method=\"" + strMethod
                      + "\">");

        for (int i = 0; i < keys.size(); i++) {
            String name = (String) keys.get(i);
            String value = (String) sPara.get(name);

            sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
        }
        
        sbHtml.append("<input type=\"file\" name=\"" + strParaFileName + "\" />");

        //submit鎸夐挳鎺т欢璇蜂笉瑕佸惈鏈塶ame灞炴��
        sbHtml.append("<input type=\"submit\" value=\"" + strButtonName + "\" style=\"display:none;\"></form>");

        return sbHtml.toString();
    }
    
    /**
     * 寤虹珛璇锋眰锛屼互妯℃嫙杩滅▼HTTP鐨凱OST璇锋眰鏂瑰紡鏋勯�犲苟鑾峰彇鏀粯瀹濈殑澶勭悊缁撴灉
     * 濡傛灉鎺ュ彛涓病鏈変笂浼犳枃浠跺弬鏁帮紝閭ｄ箞strParaFileName涓巗trFilePath璁剧疆涓虹┖鍊�
     * 濡傦細buildRequest("", "",sParaTemp)
     * @param strParaFileName 鏂囦欢绫诲瀷鐨勫弬鏁板悕
     * @param strFilePath 鏂囦欢璺緞
     * @param sParaTemp 璇锋眰鍙傛暟鏁扮粍
     * @return 鏀粯瀹濆鐞嗙粨鏋�
     * @throws Exception
     */
    public static String buildRequest(String strParaFileName, String strFilePath,Map<String, String> sParaTemp) throws Exception {
        //寰呰姹傚弬鏁版暟缁�
        Map<String, String> sPara = buildRequestPara(sParaTemp);

        HttpProtocolHandler httpProtocolHandler = HttpProtocolHandler.getInstance();

        HttpRequest request = new HttpRequest(HttpResultType.BYTES);
        //璁剧疆缂栫爜闆�
        request.setCharset(AlipayConfig.input_charset);

        request.setParameters(generatNameValuePair(sPara));
        request.setUrl(ALIPAY_GATEWAY_NEW+"_input_charset="+AlipayConfig.input_charset);

        HttpResponse response = httpProtocolHandler.execute(request,strParaFileName,strFilePath);
        if (response == null) {
            return null;
        }
        
        String strResult = response.getStringResult();

        return strResult;
    }

    /**
     * MAP绫诲瀷鏁扮粍杞崲鎴怤ameValuePair绫诲瀷
     * @param properties  MAP绫诲瀷鏁扮粍
     * @return NameValuePair绫诲瀷鏁扮粍
     */
    private static NameValuePair[] generatNameValuePair(Map<String, String> properties) {
        NameValuePair[] nameValuePair = new NameValuePair[properties.size()];
        int i = 0;
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            nameValuePair[i++] = new NameValuePair(entry.getKey(), entry.getValue());
        }

        return nameValuePair;
    }
    
    /**
     * 鐢ㄤ簬闃查挀楸硷紝璋冪敤鎺ュ彛query_timestamp鏉ヨ幏鍙栨椂闂存埑鐨勫鐞嗗嚱鏁�
     * 娉ㄦ剰锛氳繙绋嬭В鏋怷ML鍑洪敊锛屼笌鏈嶅姟鍣ㄦ槸鍚︽敮鎸丼SL绛夐厤缃湁鍏�
     * @return 鏃堕棿鎴冲瓧绗︿覆
     * @throws IOException
     * @throws DocumentException
     * @throws MalformedURLException
     */
	public static String query_timestamp() throws MalformedURLException,
            DocumentException, IOException {

        //鏋勯�犺闂畄uery_timestamp鎺ュ彛鐨刄RL涓�
        String strUrl = ALIPAY_GATEWAY_NEW + "service=query_timestamp&partner=" + AlipayConfig.partner + "&_input_charset" +AlipayConfig.input_charset;
        StringBuffer result = new StringBuffer();

        SAXReader reader = new SAXReader();
        Document doc = reader.read(new URL(strUrl).openStream());

        List<Node> nodeList = doc.selectNodes("//alipay/*");

        for (Node node : nodeList) {
            // 鎴彇閮ㄥ垎涓嶉渶瑕佽В鏋愮殑淇℃伅
            if (node.getName().equals("is_success") && node.getText().equals("T")) {
                // 鍒ゆ柇鏄惁鏈夋垚鍔熸爣绀�
                List<Node> nodeList1 = doc.selectNodes("//response/timestamp/*");
                for (Node node1 : nodeList1) {
                    result.append(node1.getText());
                }
            }
        }

        return result.toString();
    }
}
