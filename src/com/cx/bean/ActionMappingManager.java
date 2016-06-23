package com.cx.bean;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by cxspace on 16-6-23.
 */
public class ActionMappingManager {
    //保存action的集合
    private Map<String , ActionMapping> allActions;

    //构造方法
    public ActionMappingManager(){
        //初始化

        allActions = new HashMap<String, ActionMapping>();
        this.init();
    }

    /*
      根据请求路径名称，返回Action的映射对象
     */
    public ActionMapping getActionMapping(String actionName){

        if (actionName == null){
            throw new RuntimeException("传入参数有误,请查看mystruts.xml配置的路径");
        }


        ActionMapping actionMapping = allActions.get(actionName);

        if (actionMapping == null){
            throw new RuntimeException("路径mystruts.xml找不到，请检查");
        }

        return actionMapping;
    }

    //初始化

    private void init(){

        try {

            /****dom4j读取配置文件*****/
            //得到解析器
            SAXReader reader = new SAXReader();
            //得到src/mystruts.xml 文件流

            InputStream inStream = this.getClass().getResourceAsStream("/mystruts.xml");
            //加载文件

            Document doc = reader.read(inStream);

            //获取根标签
            Element root = doc.getRootElement();

            //得到package节点
            Element ele_package = root.element("package");

            //得到package下所有字节点
            List<Element> listAction = ele_package.elements("action");

            //遍历
            for (Element ele_action : listAction){
                //封装到ActionMapping对象
                ActionMapping actionMapping = new ActionMapping();

                actionMapping.setName(ele_action.attributeValue("name"));

                actionMapping.setClassName(ele_action.attributeValue("class"));

                actionMapping.setMethod(ele_action.attributeValue("method"));

                //封装所有action的结果视图

                Map<String , Result> results = new HashMap<String, Result>();
                //得到当前action节点下所有result字节点

                Iterator<Element> it = ele_action.elementIterator("result");

                while (it.hasNext()){

                    Element ele_result = it.next();

                    //封装对象
                    Result res = new Result();
                    res.setName(ele_result.attributeValue("name"));
                    res.setType(ele_result.attributeValue("type"));
                    res.setPage(ele_result.getTextTrim());

                    //添加到集合
                    results.put(res.getName() , res);

                }

                actionMapping.setResults(results);
                //添加到map集合
                allActions.put(actionMapping.getName() , actionMapping);

            }


        }catch (Exception e){
             throw new RuntimeException("初始化错误" , e);
        }


    }
}