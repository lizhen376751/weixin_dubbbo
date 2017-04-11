package com.dudu.soa.weixindubbo.weixin;

/**
 * 已经合并到AdvancedUtilService
 * Created by lizhen on 2017/3/15.
 * 公众平台通用接口工具类
 */
public final class WeixinUtil {
//    private WeixinUtil() {
//    }
//
//    /**
//     * 发起https请求并获取结果
//     *
//     * @param requestUrl    请求地址
//     * @param requestMethod 请求方式（GET、POST）
//     * @param outputStr     提交的数据
//     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
//     */
//    public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
//
//        JSONObject jsonObject = null;
//        StringBuffer buffer = new StringBuffer();
//        try {
//            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
//            TrustManager[] tm = {new MyX509TrustManager()};
//            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
//            sslContext.init(null, tm, new java.security.SecureRandom());
//            // 从上述SSLContext对象中得到SSLSocketFactory对象
//            SSLSocketFactory ssf = sslContext.getSocketFactory();
//
//            URL url = new URL(requestUrl);
//            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
//            httpUrlConn.setSSLSocketFactory(ssf);
//
//            httpUrlConn.setDoOutput(true);
//            httpUrlConn.setDoInput(true);
//            httpUrlConn.setUseCaches(false);
//            // 设置请求方式（GET/POST）
//            httpUrlConn.setRequestMethod(requestMethod);
//
//            if ("GET".equalsIgnoreCase(requestMethod)) {
//                httpUrlConn.connect();
//            }
//
//            // 当有数据需要提交时
//            if (null != outputStr) {
//                OutputStream outputStream = httpUrlConn.getOutputStream();
//                // 注意编码格式，防止中文乱码
//                outputStream.write(outputStr.getBytes("UTF-8"));
//                outputStream.close();
//            }
//
//            // 将返回的输入流转换成字符串
//            InputStream inputStream = httpUrlConn.getInputStream();
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//
//            String str = null;
//            while ((str = bufferedReader.readLine()) != null) {
//                buffer.append(str);
//            }
//            bufferedReader.close();
//            inputStreamReader.close();
//            // 释放资源
//            inputStream.close();
//            inputStream = null;
//            httpUrlConn.disconnect();
//            jsonObject = JSONObject.parseObject(buffer.toString());
//        } catch (ConnectException ce) {
////            log.error("Weixin server connection timed out.");
//        } catch (Exception e) {
////            log.error("https request error:{}", e);
//        }
//        return jsonObject;
//    }
//
//    /**
//     * TODO 封装成接口 需要将获取到的token放到数据库里面
//     * 获取access_token的接口地址（GET） 限2000（次/天）
//     */
//    public static final  String TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
//
//    /**
//     * 获取access_token
//     *
//     * @param appid 凭证
//     * @param appsecret 密钥
//     * @return AccessToken
//     */
//    public static AccessToken getAccessToken(String appid, String appsecret) {
//        AccessToken accessToken = null;
//
//        String requestUrl = TOKEN_URL.replace("APPID", appid).replace("APPSECRET", appsecret);
//        JSONObject jsonObject = httpRequest(requestUrl, "GET", null);
//        // 如果请求成功
//        if (null != jsonObject) {
//            try {
//                accessToken = new AccessToken();
//                accessToken.setToken(jsonObject.getString("access_token"));
//                accessToken.setExpiresIn(jsonObject.getIntValue("expires_in"));
//            } catch (JSONException e) {
//                accessToken = null;
//                // 获取token失败
////                log.e("获取token失败 errcode:{} errmsg:{}", jsonObject.getIntValue("errcode"), jsonObject.getString("errmsg"));
//            }
//        }
//        return accessToken;
//    }
//
//    /**
//     *  菜单创建（POST） 限100（次/天）
//     */
//    private static  String mENUCREATURL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
//
//    /**
//     * 创建菜单
//     *
//     * @param menu 菜单实例
//     * @param accessToken 有效的access_token
//     * @return 0表示成功，其他值表示失败
//     */
//    public static int createMenu(Menu menu, String accessToken) {
//        int result = 0;
//
//        // 拼装创建菜单的url
//        String url = mENUCREATURL.replace("ACCESS_TOKEN", accessToken);
//        // 将菜单对象转换成json字符串
//
//        String jsonMenu = JSONObject.toJSONString(menu);
//        // 调用接口创建菜单
//        JSONObject jsonObject = httpRequest(url, "POST", jsonMenu);
//
//        if (null != jsonObject) {
//            if (0 != jsonObject.getIntValue("errcode")) {
//                result = jsonObject.getIntValue("errcode");
////                log.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
//            }
//        }
//
//        return result;
//    }


}
