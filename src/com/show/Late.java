package com.show;

import com.utils.Data;
import com.utils.DocumentUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * 晚归、违规用电记录查询
 * Created by Jockey on 2016/5/23.
 */
public  class Late {
    public static Elements getLateInfo(String cookies){
        //获取URL
        String url= Data.getUrlBySelector("tr [title~=晚归、违规用电记录]",cookies);
        //获取table
        Elements table = DocumentUtils.parseUrlToElements(url, cookies, "table");
        //课程名称
        Element element = table.get(2);

        Elements tr = element.select("tr");

        return tr;
    }
}
