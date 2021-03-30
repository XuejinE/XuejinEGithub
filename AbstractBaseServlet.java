package org.example.servlet;

import org.example.exception.AppException;
import org.example.model.JSONResponse;
import org.example.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class AbstractBaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求体的编码格式，
        req.setCharacterEncoding("UTF-8");
        //设置乡音繁体的编码
        resp.setCharacterEncoding("UTF-8");
        //设置乡响应体的数据类型，(浏览器需要采用什么方式执行）
        resp.setContentType("application/json");


        //session会话管理，除登录和注册接口，其他都需要登陆后访问
        //req.getServletPath()采取请求服务路径
        //req.getServletPath()
        //TODO
        JSONResponse json=new JSONResponse();

        try{

            Object data=process(req,resp);
            //子类的process方法执行完没有抛异常，表示业务执行成功
            json.setSuccess(true);
            json.setData(data);

            //调用子类重写的方法
            process(req,resp);
        }catch(Exception e){
         //异常如何处理？JDBC的异常SQLException，JSON处理的异常，自定义异常返回错误消息

            e.printStackTrace();
            //Json.setSuccess(false)
            String code="UNKNOWN";
            String s="未知的错误";
            if(e instanceof AppException){
                code=((AppException)e).getCode();
                s= e.getMessage();
            }
            json.setCode(code);
            json.setMessage(s);

        }
    //前后端数据封装
        PrintWriter pw=resp.getWriter();
        pw.println(JSONUtil.serialize(json));
        pw.flush();
        pw.close();
        //TODO

    }
    protected abstract Object process(HttpServletRequest req,
                                    HttpServletResponse resp) throws IOException, Exception;


}
