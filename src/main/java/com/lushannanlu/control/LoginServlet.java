package com.lushannanlu.control;

import com.lushannanlu.service.UserLoginService;
import com.lushannanlu.msg.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *@Describ:获取前端传过来的邮箱和密码
 *@Auther:李明季
 *@Time:
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserLoginService userLoginService = null;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        userLoginService = new UserLoginService();
        Message accessLogin = userLoginService.isAccessLogin(email,password);
        PrintWriter writer = resp.getWriter();
        System.out.println(req.getContextPath()+"/jsp/login.jsp");
        if(1==accessLogin.getCode()||0==accessLogin.getCode()){
            //设置返回的结果，让前台实现弹窗
            req.setAttribute("mssg",accessLogin);
            req.getRequestDispatcher("/jsp/login.jsp").forward(req,resp);
        }else{
            resp.sendRedirect(req.getContextPath()+"/jsp/poetry.jsp");
        }
        //2672857251@qq.com

    }
}
