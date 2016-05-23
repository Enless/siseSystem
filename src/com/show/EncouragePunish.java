package com.show;

import com.utils.Data;
import com.utils.DocumentUtils;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jockey on 2016/5/22.
 */
public class EncouragePunish {
    public static List getEncourage(String cookies){
        //获取url
        String url= Data.getUrlBySelector("tr [title~=奖惩记录]",cookies);
        //获取table
        Elements table = DocumentUtils.parseUrlToElements(url, cookies, ".table1");

        //奖惩原因
        Elements reason = table.select("td:nth-child(4)");
        //日期
        Elements date = table.select("td:nth-child(6)");
        //将对象保存到list中
        List list1 = DocumentUtils.parseElementsToList(reason, "<th>", "</th>");
        List list2 = DocumentUtils.parseElementsToList(date, "<td>", "</td>");
        //新建一个list保存2个list
        List list=new ArrayList<>();
        list.add(0,list1);
        list.add(1,list2);

        return list;

    }
}
