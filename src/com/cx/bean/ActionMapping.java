package com.cx.bean;

import java.util.Map;

/**
 * Created by cxspace on 16-6-23.
 *
 * 加载配置文件，封装整个mystruts.xml
 *
 */

public class ActionMapping {

    //封装请求路径名
    private String name;

    //处理action类
    private String className;
    //处理方法
    private String method;
    //结果视图
    private Map<String,Result> results;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Map<String, Result> getResults() {
        return results;
    }

    public void setResults(Map<String, Result> results) {
        this.results = results;
    }
}
