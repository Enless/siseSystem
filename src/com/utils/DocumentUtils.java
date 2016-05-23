package com.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jockey on 2016/5/22.
 */
public class DocumentUtils {

    /**
     *
     * @param elements
     * @param domHead html标签头
     * @param domEnd html标签尾
     * @return
     */
    public static List parseElementsToList(Elements elements,String domHead,String domEnd){
        List list = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            //根据需要设置格式
            list.add(i,domHead+elements.get(i).text()+domEnd);
        }
        return list;
    }

    /**
     * 获取页面，并得到根据相应选择器过滤出的文本
     * @param url
     * @param cookies
     * @param selector
     * @return
     */
    public static Elements parseUrlToElements(String url, String cookies, String selector){
        //解析页面
        Document document = Jsoup.parseBodyFragment(HttpUtils.get(url, cookies));
        //直接返回Elements对象
        return document.select(selector);
    }
}
