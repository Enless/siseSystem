package com.servlet;

import com.utils.HttpUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Jockey on 2016/5/20.
 * 这个类是用来处理登陆操作的
 * 当登陆失败会跳到404界面
 * @Todo 优化404页面
 * 登陆成功进入主页
 * @Todo 处理URL
 */
@WebServlet(name = "Login",urlPatterns = "/Login")
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取输入用户名，密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //获取cookies
        String cookies = HttpUtils.loginAntGetCookies(username, password);
        //判断是否登陆成功
        if (null == cookies){
            response.sendRedirect(request.getContextPath()+"/jsp/404.html");
        }else {
            //用session域存储数据
            HttpSession session=request.getSession();
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            session.setAttribute("cookies",cookies);
            request.getRequestDispatcher(request.getContextPath()+"/jsp/home.jsp").forward(request,response);
        }


    }
}
