package com.utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 获取MyScese数据工具类
 * <p>
 * Created by cl on 2016/4/23.
 */
public class HttpUtils {
    
    // 不创建对象类
    private HttpUtils() {
    }

    // 返回cookie
    public static String loginAntGetCookies(String username, String password) {

        // 第一次请求
        Connection con = Jsoup.connect("http://class.sise.com.cn:7001/sise/login.jsp");// 获取连接
        con.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:44.0) Gecko/20100101 Firefox/44.0");// 配置模拟浏览器
        Connection.Response rs = null;
        try {
            rs = con.execute();// 获取响应
        } catch (IOException e) {
            e.printStackTrace();
        }
        Document doc = Jsoup.parse(rs.body());// 转换为Dom树
        List<Element> et = doc.select("form");// 获取form表单，可以通过查看页面源码代码得知

        // 获取，cooking和表单属性，下面map存放post时的数据
        Map<String, String> datas = new HashMap<>();
        for (Element e : et.get(0).getAllElements()) {
            if (e.attr("name").equals("username")) {
                e.attr("value", username);// 设置用户名
            }
            if (e.attr("name").equals("password")) {
                e.attr("value", password); // 设置用户密码
            }
            if (e.attr("name").length() > 0) {// 排除空值表单属性
                datas.put(e.attr("name"), e.attr("value"));
            }
        }

        // 第二次请求，post表单数据，以及cookie信息
        Connection con2 = Jsoup.connect("http://class.sise.com.cn:7001/sise/login_check.jsp");
        con2.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:44.0) Gecko/20100101 Firefox/44.0");
        // 设置cookie和post上面的map数据
        Connection.Response login = null;
        try {
            login = con2.ignoreContentType(true).method(Connection.Method.POST).data(datas).cookies(rs.cookies()).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!login.body().contains("/sise/index.jsp")) {
            System.out.println(login.body());
            return null;
        }

        return rs.cookies().toString();
    }

    //url: 通过get请求获取网页数据的地址
    //cookies: 调用loginAntGetCookies获得的cookies
    public static String get(String url, String cookies) {
        Connection con = Jsoup.connect(url);// 获取连接
        con.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:44.0) Gecko/20100101 Firefox/44.0");// 配置模拟浏览器

        Map<String, String> c = new HashMap<>();
        String[] cookie = cookies.substring(1, cookies.length() - 1).split("=");
        c.put(cookie[0], cookie[1]);
        con.cookies(c);

        Connection.Response rs = null;
        try {
            rs = con.execute();// 获取响应
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rs.body();
    }

    //url: 通过post请求获取网页数据的地址
    //cookies: 调用loginAntGetCookies获得的cookies
    //datas: 表单请求参数
    public static String post(String url, String cookies, Map<String, String> datas) {
        Connection con = Jsoup.connect(url);// 获取连接
        con.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:44.0) Gecko/20100101 Firefox/44.0");// 配置模拟浏览器

        Map<String, String> ck = new HashMap<>();
        String[] cookie = cookies.substring(1, cookies.length() - 1).split("=");
        ck.put(cookie[0], cookie[1]);

        Connection.Response rs = null;
        try {
            rs = con.ignoreContentType(true).method(Connection.Method.POST).data(datas).cookies(ck).execute();// 获取响应
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rs.body();
    }
}