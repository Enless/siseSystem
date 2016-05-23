package com.show;

import com.utils.Data;
import com.utils.DocumentUtils;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jockey on 2016/5/23.
 */
public class Course {
    /**
     * 获取所有课程信息
     * @param cookies
     * @return
     */
    public static List CourseElements(String cookies){
        //获取url
        String url= Data.getUrlBySelector("tr [title~=查看开设课程]",cookies);
        //获取table
        Elements tr = DocumentUtils.parseUrlToElements(url, cookies, "tr[height]");
        //课程名称
        Elements name = tr.select("td:nth-child(2)");
        //课程学分
        Elements fen = tr.select("td:nth-child(4)");
        //考察方式
        Elements way = tr.select("td:nth-child(5)");

        List list1 = DocumentUtils.parseElementsToList(name, "<td>", "</td>");
        List list2 = DocumentUtils.parseElementsToList(fen, "<td>", "</td>");
        List list3 = DocumentUtils.parseElementsToList(way, "<td>", "</td>");

        List list = new ArrayList<>();
        list.add(0,list1);
        list.add(1,list2);
        list.add(2,list3);
        return list;
    }

}
