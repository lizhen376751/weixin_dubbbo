package com.dudu.soa.weixindubbo.menu.module;

import java.io.Serializable;
import java.util.Date;

/**
 * 查询自定义菜单返回参数
 * 冯广祥
 * 2017/8/18.
 */
public class ResultQueryMenu implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 客户配置的菜单要连接到的URL地址
     */
    private String menuUrl;
    /**
     * 状态   1：正常   2：作废
     */
    private Integer condition;
    /**
     * 创建日期
     */
    private Date createtime;
    /**
     * 模块级别   2：父类模块   3：子类模块
     */
    private Integer moduleLayer;
    /**
     * 模块排序
     */
    private Integer sequence;
    /**
     * 父模块
     */
    private Integer moduleUpId;
    /**
     * 店铺编码
     */
    private String shopCode;
    /**
     * 老版微信菜单ID
     */
    private Integer historyId;

    /**
     *  ResultQueryMenu(查询自定义菜单返回参数) 字符串形式
     * @return ResultQueryMenu(查询自定义菜单返回参数)字符串
     */
    @Override
    public String toString() {
        return "id:" + id + ",title:" + title + ",menuUrl:" + menuUrl + ",condition:" + condition + ",createtime:" + createtime + ",moduleLayer:" + moduleLayer
                + ",sequence:" + sequence + ",moduleUpId:" + moduleUpId + ",shopCode:" + shopCode + ",historyId:" + historyId;
    }

    /**
     * 获取 主键ID
     * @return id 主键ID
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * 设置 主键ID
     * @param id 主键ID
     * @return 返回 ResultQueryMenu(查询自定义菜单返回参数)
     */
    public ResultQueryMenu setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 标题
     * @return title 标题
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * 设置 标题
     * @param title 标题
     * @return 返回 ResultQueryMenu(查询自定义菜单返回参数)
     */
    public ResultQueryMenu setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * 获取 客户配置的菜单要连接到的URL地址
     * @return menuUrl 客户配置的菜单要连接到的URL地址
     */
    public String getMenuUrl() {
        return this.menuUrl;
    }

    /**
     * 设置 客户配置的菜单要连接到的URL地址
     * @param menuUrl 客户配置的菜单要连接到的URL地址
     * @return 返回 ResultQueryMenu(查询自定义菜单返回参数)
     */
    public ResultQueryMenu setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
        return this;
    }

    /**
     * 获取 状态   1：正常   2：作废
     * @return condition 状态   1：正常   2：作废
     */
    public Integer getCondition() {
        return this.condition;
    }

    /**
     * 设置 状态   1：正常   2：作废
     * @param condition 状态   1：正常   2：作废
     * @return 返回 ResultQueryMenu(查询自定义菜单返回参数)
     */
    public ResultQueryMenu setCondition(Integer condition) {
        this.condition = condition;
        return this;
    }

    /**
     * 获取 创建日期
     * @return createtime 创建日期
     */
    public Date getCreatetime() {
        return this.createtime;
    }

    /**
     * 设置 创建日期
     * @param createtime 创建日期
     * @return 返回 ResultQueryMenu(查询自定义菜单返回参数)
     */
    public ResultQueryMenu setCreatetime(Date createtime) {
        this.createtime = createtime;
        return this;
    }

    /**
     * 获取 模块级别   2：父类模块   3：子类模块
     * @return moduleLayer 模块级别   2：父类模块   3：子类模块
     */
    public Integer getModuleLayer() {
        return this.moduleLayer;
    }

    /**
     * 设置 模块级别   2：父类模块   3：子类模块
     * @param moduleLayer 模块级别   2：父类模块   3：子类模块
     * @return 返回 ResultQueryMenu(查询自定义菜单返回参数)
     */
    public ResultQueryMenu setModuleLayer(Integer moduleLayer) {
        this.moduleLayer = moduleLayer;
        return this;
    }

    /**
     * 获取 模块排序
     * @return sequence 模块排序
     */
    public Integer getSequence() {
        return this.sequence;
    }

    /**
     * 设置 模块排序
     * @param sequence 模块排序
     * @return 返回 ResultQueryMenu(查询自定义菜单返回参数)
     */
    public ResultQueryMenu setSequence(Integer sequence) {
        this.sequence = sequence;
        return this;
    }

    /**
     * 获取 父模块
     * @return moduleUpId 父模块
     */
    public Integer getModuleUpId() {
        return this.moduleUpId;
    }

    /**
     * 设置 父模块
     * @param moduleUpId 父模块
     * @return 返回 ResultQueryMenu(查询自定义菜单返回参数)
     */
    public ResultQueryMenu setModuleUpId(Integer moduleUpId) {
        this.moduleUpId = moduleUpId;
        return this;
    }

    /**
     * 获取 店铺编码
     * @return shopCode 店铺编码
     */
    public String getShopCode() {
        return this.shopCode;
    }

    /**
     * 设置 店铺编码
     * @param shopCode 店铺编码
     * @return 返回 ResultQueryMenu(查询自定义菜单返回参数)
     */
    public ResultQueryMenu setShopCode(String shopCode) {
        this.shopCode = shopCode;
        return this;
    }

    /**
     * 获取 老版微信菜单ID
     * @return historyId 老版微信菜单ID
     */
    public Integer getHistoryId() {
        return this.historyId;
    }

    /**
     * 设置 老版微信菜单ID
     * @param historyId 老版微信菜单ID
     * @return 返回 ResultQueryMenu(查询自定义菜单返回参数)
     */
    public ResultQueryMenu setHistoryId(Integer historyId) {
        this.historyId = historyId;
        return this;
    }
}
