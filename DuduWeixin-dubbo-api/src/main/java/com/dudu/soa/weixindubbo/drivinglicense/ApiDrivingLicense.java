package com.dudu.soa.weixindubbo.drivinglicense;

/**
 * 行驶证图片上传接口
 * Created by lizhen on 2017/6/24.
 */

public interface ApiDrivingLicense {
    /**
     *
     * @param appcode 阿里云开通行驶证扫描的appcode
     * @param body 行驶证图片转换成的64位的编码
     * @return 返回行驶证相关的信息
     */
    String drivingLicense(String appcode, String body);
}
