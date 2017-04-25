package com.dudu.soa.weixindubbo.weixin.http.old;


import com.alibaba.fastjson.JSONObject;
import com.dudu.soa.framework.exception.DuduExceptionUtil;
import com.dudu.soa.weixindubbo.weixin.http.module.http.HttpMethod;
import com.dudu.soa.weixindubbo.weixin.http.module.http.ParamterContentType;
import com.dudu.soa.weixindubbo.weixin.http.module.http.WeixinActionMethodDefine;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * Created by Z800 on 2017/1/3.
 */
public final class WeixinServer {
    /**
     * 链接管理器
     */
    private static HttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();

    private WeixinServer() {
    }

    /**
     * 请求
     *
     * @param actionMethodDefine 接口
     * @param jsonObject         业务参数
     * @return 请求结果
     */
    private static String request(WeixinActionMethodDefine actionMethodDefine, JSONObject jsonObject) {
        //TODO ssl证书忽略
        HttpClient client = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setProxy(new HttpHost("127.0.0.1", 8888))
                .build();
        RequestConfig config = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
        try {
            HttpRequestBase request = null;
            String actionURL = WeixinActionFactory.getActionURL(actionMethodDefine);

            if (HttpMethod.GET.equals(actionMethodDefine.getHttpMethod())) {
                request = new HttpGet(actionURL);
                //TODO get请求拼接URL问题
            } else if (HttpMethod.POST.equals(actionMethodDefine.getHttpMethod())) {
                request = new HttpPost(actionURL);
                //TODO POST请求设置请求实体问题

            }
            request.setConfig(config);
            CloseableHttpResponse response = (CloseableHttpResponse) client.execute(request);
            String data = IOUtils.toString(IOUtils.toByteArray(response.getEntity().getContent()), "utf-8");
            return data;
        } catch (Exception e) {
            if (null != actionMethodDefine.getExceptionHandler()) {
                actionMethodDefine.getExceptionHandler().handle(e);
            } else {
                throw new RuntimeException("UnsupportedEncodingException异常", e);
            }
        }
        return null;
    }

    /**
     *
     * @param actionMethodDefine 实体类
     * @param jsonObject json对象
     * @return json对象
     */
    public static JSONObject requestforJSON(WeixinActionMethodDefine actionMethodDefine, JSONObject jsonObject) {
        if (!ParamterContentType.JSON.equals(actionMethodDefine.getParamterContentType())) {
            throw DuduExceptionUtil.throwException(actionMethodDefine.getUri() + "不支持JSON类型");
        }
        String content = WeixinServer.request(actionMethodDefine, jsonObject);
        return JSONObject.parseObject(content);
    }


}

