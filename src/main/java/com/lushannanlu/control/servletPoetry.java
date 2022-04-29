package com.lushannanlu.control;

import com.alibaba.fastjson.JSON;
import com.lushannanlu.pojo.Poetry;
import com.lushannanlu.service.ServicePoetry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
@WebServlet("/poetry")
public class servletPoetry extends HttpServlet {
    private static ServicePoetry servicePoetry=null;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        String csvFilePath = "C:\\Users\\26728\\Desktop\\PoetryLibrary\\2_秦朝\\555-556.csv";
        servicePoetry = new ServicePoetry();
        //获取诗歌对象
        ArrayList<Poetry> poetries = servicePoetry.readCsv(csvFilePath);
        //将诗歌对象转为json对象存放在集合中
        ArrayList<Object> objects = new ArrayList<>();
        for (Poetry poetry : poetries) {
            objects.add(JSON.toJSON(poetry));
        }
        //将json集合转为json字符串
        String s = JSON.toJSONString(objects);

        //向前端发送json数据
        PrintWriter writer = resp.getWriter();
        writer.write(s);
        writer.close();
    }
}
