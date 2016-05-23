package com.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;


/**
 * 用于获取文本信息
 * Created by Administrator on 2016/4/30.
 */
public class Data {
//    从该主URL中获取功能URL
    private static final String MAIN_URL=
        "http://class.sise.com.cn:7001/sise/module/student_states/student_select_class/main.jsp";
    //获取document
    public static Document getDocument(String cookies){
        return Jsoup.parseBodyFragment(HttpUtils.get(MAIN_URL,cookies));
    }

    public Data() {
    }

    /**
     *
     * @param selector
     * @param cookies
     * @return url
     */
    public static String getUrlBySelector(String selector,String cookies){
//        选择规则
        Document document = getDocument(cookies);
        String url="";
        int temp=0;
        String str=document.select(selector).html();
//        以下用来过滤表单内容，提取出URL
        for (int i = 0; i <str.length() ; i++) {
            String c =String.valueOf(str.charAt(i)) ;
            if (c.equals("'")){
                if (temp==0){
                    temp=i;
                }else {
                    url = str.substring(temp+1, i);
                    break;
                }
            }
        }
        url=url.replace("../","");
        url=url.replaceAll("&amp;","&");
//        由于获取的URL是相对路径，转成绝对路径
        url="http://class.sise.com.cn:7001/"+url;
        return url;
    }
//    @Test
    public void Test() throws IOException {
        //登陆
        String cookies = HttpUtils.loginAntGetCookies("1440124166", "62511414");

        String url = getUrlBySelector("tr [title~=考勤]",cookies);
        String html = HttpUtils.get(url, cookies);
        Document document = Jsoup.parse(html);
        Elements elements = document.select(".table").select("tr");
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i));
        }
    }

}
