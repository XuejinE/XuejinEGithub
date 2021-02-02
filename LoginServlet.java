package org.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//注解的使用：（）包裹多个属性，是属性名=属性值// ，多个之间逗号间隔,属性名为value的可以省略
//servlet定义服务，注意服务路径是/开头，否则tomcat启动就会报错
    @WebServlet("/login")
    public class LoginServlet extends HttpServlet {
    //每次http请求映射到Servlet的资源路径，都会调用service生命周期方法，如果请求方法没有重写，/// /
    // 就会调用父类的doxx(请求方法），如果重写了。请为Request对象，这时候虽然还没有响应，但是也
    // 包装了一个Request响应对象。

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//设置请求，响应编码，及响应数据类型，（为响应体设置Content-Type数据类型）
        req.setCharacterEncoding("UTF-8");//设置请求体编码
        resp.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("text/html");

        //解析请求数据
        //getParameter方法获取请求数据，url和请求体，数据格式为k1=v1&k2=v2;
        String u = req.getParameter("username");
        String p = req.getParameter("password");
        System.out.printf("============用户名(%s) 密码(%s) %n", u, p);
        //返回响应数据
        PrintWriter pw = resp.getWriter();//response获取io输出流
        pw.println("登录成功");
        pw.println("<h3>欢迎你。" + u + "</h3>");
        pw.flush();//在输出流里有刷新。有缓冲的io操作，需要刷新缓冲区，才会真正的发送数据
        pw.close();//io流操作完，一定要关闭资源
        //super.doPost(req, resp);
    }
}






