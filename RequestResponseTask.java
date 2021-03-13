package com.moumou.tomcat;

import com.moumou.standard.Servlet;
import com.moumou.standard.http.HttpServletRequest;
import com.moumou.standard.http.HttpServletResponse;

import javax.naming.Context;
import java.net.Socket;

public class RequestResponseTask implements Runnable{
    private final Socket socket;

    public RequestResponseTask(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
    /*    //解析并得到请求对象
        HttpServletRequest request=null;
        //2.实例化一个响应对象
        HttpServletResponse response=null;
        //3.根据request.getContextPath()找到哪个Context进行处理
        Context context=null;
        //4.根据request.getServletPath()找到Context中哪个HttpServlet进行处理
        Servlet servlet=null;
        //5.调用servlet.service(request,response),交给业务处理
        servlet.service(request,response);
        //6.根据response对象中的数据，发送HTTP响应
        sendResponse(response);*/
    }
}
