package com.show;

import com.utils.HttpUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jockey on 2016/5/21.
 * 这个类是用来处理个人信息优化的
 * 将数据转化为List数组输出
 */
public class PersonInfo {

    /**
     *
     * 用于获取必修课程信息
     * @param url 个人信息的URL
     * @param cookies cookies
     * @return 一个list，每一个元素含1个tr
     */
    public static List<String>  getCompulsoryInfo(String url,String cookies){
        //解析页面
        Document document = Jsoup.parseBodyFragment(HttpUtils.get(url, cookies));
        //名称
        Elements courseName = document.select(".table").first().select("td:nth-child(3)");
        //成绩
        Elements courseScore = document.select(".table").first().select("td:nth-child(9)");
        //学分
        Elements courseFen = document.select(".table").first().select("td:nth-child(10)");
        //测试
//        for (int i = 0; i < courseName.size(); i++) {
//            System.out.println(courseName.get(i).text()+"///"+courseScore.get(i).text()+"///"+courseFen.get(i).text()+"///");
//        }
        List<String> list=new ArrayList<>();
        for (int i = 0; i < courseName.size(); i++) {
            String name = courseName.get(i).text();
            String text = "";
            //将解析的东西重新封装成html dom元素，直接解析
            text="<tr><th>"+name+"</th>"+"<td>"+
                    courseScore.get(i).text()+"</td>" +"<td>"+
                    courseFen.get(i).text()+"</td></tr>";
            list.add(i,text);
        }
        return list;
    }


    /**
     * 用来获取个人信息
     * @param url
     * @param cookies
     * @return td
     */
    public static List getPersonalInfo(String url, String cookies){
        List arrayList = new ArrayList<>();
        //解析页面
        Document document = Jsoup.parseBodyFragment(HttpUtils.get(url, cookies));
        Elements table = document.select(".tablehead").select("table").select("td");
        for (int i = 0; i < table.size(); i++) {
            String text="<td>"+table.get(i).text()+"</td>";
            arrayList.add(i,text);
        }
        return arrayList;
    }

}
