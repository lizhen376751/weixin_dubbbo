package com.dudu.soa.weixindubbo.weixin;

import com.alibaba.fastjson.JSONObject;
import com.dudu.soa.framework.commons.logger.LogUtil;
import org.junit.Test;

/**
 * Created by Administrator on 2017/4/14.
 */
public class WeixinActionFactoryTest {
    @Test
    public void getAccessToken() throws Exception {
        LogUtil.getLogger().debug(JSONObject.toJSONString(WeixinActionFactory.getAccessToken()));
        
    }

}