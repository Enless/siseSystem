package com.show;

import com.utils.Data;
import com.utils.DocumentUtils;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jockey on 2016/5/22.
 * 考勤
 * tr [title~=考勤]
 */
public class Attendance {

    /**
     *
     * 返回一个含2个list的list
     * @param cookies
     * @return list
     */
    public static List getAttendanceInfo(String cookies){
        //获取URL
        String url= Data.getUrlBySelector("tr [title~=考勤]",cookies);
        //获取table
        Elements table = DocumentUtils.parseUrlToElements(url, cookies, "#table1");
        //课程名称
        Elements courseName = table.select("td:nth-child(2)");
        //信息
        Elements info = table.select("td:nth-child(3)");
        //将对象保存到list中
        List list1 = DocumentUtils.parseElementsToList(courseName, "<td>", "</td>");
        List list2 = DocumentUtils.parseElementsToList(info, "<td>", "</td>");
        //新建一个list保存2个list
        List list=new ArrayList<>();
        list.add(0,list1);
        list.add(1,list2);

        return list;
    }
}
