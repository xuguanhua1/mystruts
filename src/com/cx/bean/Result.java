package com.cx.bean;

/**
 * Created by cxspace on 16-6-23.
 */
public class Result {
    //跳转结果标记
    private String name;
    // 跳转类型，默认为转发
    private String type;
    //跳转的页面
    private String page;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
