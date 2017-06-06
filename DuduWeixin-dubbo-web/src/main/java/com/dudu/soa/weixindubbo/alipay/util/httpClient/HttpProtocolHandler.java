package com.dudu.soa.weixindubbo.alipay.util.httpClient;


import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.*;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.util.IdleConnectionTimeoutThread;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/* *
 *缁鎮曢敍娆籺tpProtocolHandler
 *閸旂喕鍏橀敍娆籺tpClient閺傜懓绱＄拋鍧楁６
 *鐠囷妇绮忛敍姘冲箯閸欐牞绻欑粙濠琓TP閺佺増宓�
 *閻楀牊婀伴敍锟�.3
 *閺冦儲婀￠敍锟�012-08-17
 *鐠囧瓨妲戦敍锟�
 *娴犮儰绗呮禒锝囩垳閸欘亝妲告稉杞扮啊閺傞�涚┒閸熷棙鍩涘ù瀣槸閼板本褰佹笟娑氭畱閺嶈渹绶ユ禒锝囩垳閿涘苯鏅㈤幋宄板讲娴犮儲鐗撮幑顔垮殰瀹歌京缍夌粩娆戞畱闂囷拷顪呴敍灞惧瘻閻撗勫Η閺堫垱鏋冨锝囩椽閸愶拷楠炲爼娼稉锟界暰鐟曚椒濞囬悽銊嚉娴狅絿鐖滈妴锟�
 *鐠囥儰鍞惍浣风矌娓氭稑顒熸稊鐘叉嫲閻梻鈹掗弨顖欑帛鐎规繃甯撮崣锝勫▏閻㈩煉绱濋崣顏呮Ц閹绘劒绶垫稉锟介嚋閸欏倽锟介妴锟�
 */

public class HttpProtocolHandler {

    private static String              DEFAULT_CHARSET                     = "GBK";

    /** 鏉╃偞甯寸搾鍛閺冨爼妫块敍宀�鏁眀ean factory鐠佸墽鐤嗛敍宀�宸遍惇浣疯礋8缁夋帡鎸� */
    private int                        defaultConnectionTimeout            = 8000;

    /** 閸ョ偛绨茬搾鍛閺冨爼妫�, 閻㈢渶ean factory鐠佸墽鐤嗛敍宀�宸遍惇浣疯礋30缁夋帡鎸� */
    private int                        defaultSoTimeout                    = 30000;

    /** 闂傝尙鐤嗘潻鐐村复鐡掑懏妞傞弮鍫曟？, 閻㈢渶ean factory鐠佸墽鐤嗛敍宀�宸遍惇浣疯礋60缁夋帡鎸� */
    private int                        defaultIdleConnTimeout              = 60000;

    private int                        defaultMaxConnPerHost               = 30;

    private int                        defaultMaxTotalConn                 = 80;

    /** 姒涙顓荤粵澶婄窡HttpConnectionManager鏉╂柨娲栨潻鐐村复鐡掑懏妞傞敍鍫濆涧閺堝婀潏鎯у煂閺堬拷銇囨潻鐐村复閺佺増妞傜挧铚傜稊閻㈩煉绱氶敍锟界粔锟�/*/
    private static final long          defaultHttpConnectionManagerTimeout = 3 * 1000;

    /**
     * HTTP鏉╃偞甯寸粻锛勬倞閸ｎ煉绱濈拠銉ㄧ箾閹恒儳顓搁悶鍡楁珤韫囧懘銆忛弰顖滃殠缁嬪鐣ㄩ崗銊ф畱.
     */
    private HttpConnectionManager      connectionManager;

    private static HttpProtocolHandler httpProtocolHandler                 = new HttpProtocolHandler();

    /**
     * 瀹搞儱宸堕弬瑙勭《
     * 
     * @return
     */
    public static HttpProtocolHandler getInstance() {
        return httpProtocolHandler;
    }

    /**
     * 缁変焦婀侀惃鍕�柅鐘虫煙濞夛拷
     */
    private HttpProtocolHandler() {
        // 閸掓稑缂撴稉锟介嚋缁捐法鈻肩�瑰鍙忛惃鍑TP鏉╃偞甯村Ч锟�
        connectionManager = new MultiThreadedHttpConnectionManager();
        connectionManager.getParams().setDefaultMaxConnectionsPerHost(defaultMaxConnPerHost);
        connectionManager.getParams().setMaxTotalConnections(defaultMaxTotalConn);

        IdleConnectionTimeoutThread ict = new IdleConnectionTimeoutThread();
        ict.addConnectionManager(connectionManager);
        ict.setConnectionTimeout(defaultIdleConnTimeout);

        ict.start();
    }

    /**
     * 閹笛嗩攽Http鐠囬攱鐪�
     * 
     * @param request 鐠囬攱鐪伴弫鐗堝祦
     * @param strParaFileName 閺傚洣娆㈢猾璇茬�烽惃鍕棘閺佹澘鎮�
     * @param strFilePath 閺傚洣娆㈢捄顖氱窞
     * @return 
     * @throws HttpException, IOException 
     */
    public HttpResponse execute(HttpRequest request, String strParaFileName, String strFilePath) throws HttpException, IOException {
        HttpClient httpclient = new HttpClient(connectionManager);

        // 鐠佸墽鐤嗘潻鐐村复鐡掑懏妞�
        int connectionTimeout = defaultConnectionTimeout;
        if (request.getConnectionTimeout() > 0) {
            connectionTimeout = request.getConnectionTimeout();
        }
        httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(connectionTimeout);

        // 鐠佸墽鐤嗛崶鐐茬安鐡掑懏妞�
        int soTimeout = defaultSoTimeout;
        if (request.getTimeout() > 0) {
            soTimeout = request.getTimeout();
        }
        httpclient.getHttpConnectionManager().getParams().setSoTimeout(soTimeout);

        // 鐠佸墽鐤嗙粵澶婄窡ConnectionManager闁插﹥鏂乧onnection閻ㄥ嫭妞傞梻锟�
        httpclient.getParams().setConnectionManagerTimeout(defaultHttpConnectionManagerTimeout);

        String charset = request.getCharset();
        charset = charset == null ? DEFAULT_CHARSET : charset;
        HttpMethod method = null;

        //get濡�崇础娑撴柧绗夌敮锔跨瑐娴肩姵鏋冩禒锟�
        if (request.getMethod().equals(HttpRequest.METHOD_GET)) {
            method = new GetMethod(request.getUrl());
            method.getParams().setCredentialCharset(charset);

            // parseNotifyConfig娴兼矮绻氱拠浣峰▏閻⑩剠ET閺傝纭堕弮璁圭礉request娑擄拷鐣炬担璺ㄦ暏QueryString
            method.setQueryString(request.getQueryString());
        } else if(strParaFileName.equals("") && strFilePath.equals("")) {
        	//post濡�崇础娑撴柧绗夌敮锔跨瑐娴肩姵鏋冩禒锟�
            method = new PostMethod(request.getUrl());
            ((PostMethod) method).addParameters(request.getParameters());
            method.addRequestHeader("Content-Type", "application/x-www-form-urlencoded; text/html; charset=" + charset);
        }
        else {
        	//post濡�崇础娑撴柨鐢稉濠佺炊閺傚洣娆�
            method = new PostMethod(request.getUrl());
            List<Part> parts = new ArrayList<Part>();
            for (int i = 0; i < request.getParameters().length; i++) {
            	parts.add(new StringPart(request.getParameters()[i].getName(), request.getParameters()[i].getValue(), charset));
            }
            //婢х偛濮為弬鍥︽閸欏倹鏆熼敍瀹籺rParaFileName閺勵垰寮弫鏉挎倳閿涘奔濞囬悽銊︽拱閸︾増鏋冩禒锟�
            parts.add(new FilePart(strParaFileName, new FilePartSource(new File(strFilePath))));
            
            // 鐠佸墽鐤嗙拠閿嬬湴娴ｏ拷
            ((PostMethod) method).setRequestEntity(new MultipartRequestEntity(parts.toArray(new Part[0]), new HttpMethodParams()));
        }

        // 鐠佸墽鐤咹ttp Header娑擃厾娈慤ser-Agent鐏炵偞锟�
        method.addRequestHeader("User-Agent", "Mozilla/4.0");
        HttpResponse response = new HttpResponse();

        try {
            httpclient.executeMethod(method);
            if (request.getResultType().equals(HttpResultType.STRING)) {
                response.setStringResult(method.getResponseBodyAsString());
            } else if (request.getResultType().equals(HttpResultType.BYTES)) {
                response.setByteResult(method.getResponseBody());
            }
            response.setResponseHeaders(method.getResponseHeaders());
        } catch (UnknownHostException ex) {

            return null;
        } catch (IOException ex) {

            return null;
        } catch (Exception ex) {

            return null;
        } finally {
            method.releaseConnection();
        }
        return response;
    }

    /**
     * 鐏忓搳ameValuePairs閺佹壆绮嶆潪顒�褰夋稉鍝勭摟缁楋缚瑕�
     * 
     * @param nameValues
     * @return
     */
    protected String toString(NameValuePair[] nameValues) {
        if (nameValues == null || nameValues.length == 0) {
            return "null";
        }

        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < nameValues.length; i++) {
            NameValuePair nameValue = nameValues[i];

            if (i == 0) {
                buffer.append(nameValue.getName() + "=" + nameValue.getValue());
            } else {
                buffer.append("&" + nameValue.getName() + "=" + nameValue.getValue());
            }
        }

        return buffer.toString();
    }
}
