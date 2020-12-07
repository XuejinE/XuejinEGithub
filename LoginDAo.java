package org.example.dao;

import org.example.exception.AppException;
import org.example.model.User;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class LoginDAo {

    public static User query(String username) {
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try{
           c=DBUtil.getConnection();
           String sql="select id, username, password, nickname, sex, birthday, " +
                   "head from user where username=?";

           ps=c.prepareStatement(sql);
            ps.setString(1,username);
           //设置占位符
            rs=ps.executeQuery();
            User user=null;
            while(rs.next()){
                user=new User();
                //设置User的值
                user.setId(rs.getInt("id"));
                user.setUsername(username);
                user.setPassword(rs.getString("password"));
                user.setNickname(rs.getString("Nickname"));
                user.setSex(rs.getBoolean("sex"));
                //关于日期的使用，java一般使用java.util.Date;
               // rs.getDte()=返回值是java.sql.Date(时分秒);
                //rs.getTimeStamp();返回值是java.sql.TimeStamp(年月日时分秒）
                java.sql.Date birthday= rs.getDate("birthday");
                if(birthday != null)
                    user.setBirthday(new Date(birthday.getTime()));
                user.setHead(rs.getString("head"));

            }
            return user;
        }catch(Exception e){
           throw new AppException("LOG001","查询用户操作出错",e);
        }finally {
            DBUtil.close(c,ps,rs);
        }
    }
}
