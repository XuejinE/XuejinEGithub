package com.moumou.webapps.dictionary;

import com.moumou.standard.ServletException;
import com.moumou.standard.http.HttpServlet;


public class ReformServlet extends HttpServlet {
    public ReformServlet() {
        System.out.println("我是ReformServlet的构造方法");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("我是ReformServlet的init方法");
    }
}
