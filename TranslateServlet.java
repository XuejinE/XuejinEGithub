package com.moumou.webapps.dictionary;

import com.moumou.standard.ServletException;
import com.moumou.standard.ServletRequest;
import com.moumou.standard.ServletResponse;
import com.moumou.standard.http.HttpServlet;
import com.moumou.standard.http.HttpServletRequest;
import com.moumou.standard.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class TranslateServlet extends HttpServlet {
    public TranslateServlet(){
        System.out.println("我是Translate的构造方法");
    }
    @Override
    public void init() throws ServletException {
        System.out.println("我是TranslateServlet的init方法");
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String english=req.getParameter("english");
        String chinese=translate(english);
        resp.setContentType("text/html");
        PrintWriter writer=resp.getWriter();
        writer.printf("<h1>翻译服务<h1>\r\n");
        writer.printf("<p>%s 的意思是 %s</p>\r\n",english,chinese);
    }
    private String translate(String english){
        String chinese=english;
        return chinese ;
    }
}
