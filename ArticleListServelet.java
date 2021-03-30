package org.example.servlet;

import org.example.dao.ArticleDAO;
import org.example.exception.AppException;
import org.example.model.Article;
import org.example.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/articleList")
public class ArticleListServelet extends AbstractBaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws IOException, Exception {
        //获取session 没有就返回null
        HttpSession session=req.getSession(false);
        if(session==null){
            throw new AppException("ART002","用户没有登陆，不允许访问");
        }
        User user=(User)session.getAttribute("user");
        if(user==null){
            throw new AppException("ART003","会话异常，请重新登陆");
        }
        //用户已登录，并且保存了用户信息
        List<Article> articles= ArticleDAO.queryByUserId(user.getId());
        return articles;
    }
}
