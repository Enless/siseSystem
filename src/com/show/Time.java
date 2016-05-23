package com.show;

import com.utils.Data;
import com.utils.DocumentUtils;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * 考试时间查询
 * Created by Jockey on 2016/5/23.
 */
public class Time {
    public static List getTime(String cookies) {
        //获取url
        String url= Data.getUrlBySelector("tr [title~=考试时间查看]",cookies);
        //获取table
        Elements table = DocumentUtils.parseUrlToElements(url, cookies, ".table");

        //课程名称
        Elements title = table.select("td:nth-child(2)");
        //日期
        Elements date = table.select("td:nth-child(3)");
        //考场
        Elements place = table.select("td:nth-child(6)");

        //将对象保存到list中
        List list1 = DocumentUtils.parseElementsToList(title, "<td>", "</td>");
        List list2 = DocumentUtils.parseElementsToList(date, "<td>", "</td>");
        List list3 = DocumentUtils.parseElementsToList(place, "<td>", "</td>");
        //新建一个list保存2个list
        List list=new ArrayList<>();
        list.add(0,list1);
        list.add(1,list2);
        list.add(2,list3);

        return list;
    }
}
