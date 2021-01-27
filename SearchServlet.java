package org.example.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.example.model.Result;
import org.example.model.Weight;
import org.example.util.index;

import javax.servlet.HttpConstraintElement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.*;

//根据前端请求路径，定义后端服务路径，/loadOnStartup属性表示否在启动时初始化，默认-1启动不初始化，第一次请求
@WebServlet(value = "/search",loadOnStartup = 0)
public class SearchServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {
        //初始化
        index.buildForwardIndex();
        index.buildInvertedIndex();
        System.out.println("init complete");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application");//ajax请求
        //构造返回给前端的内容：使用对象，之后在序列化为json字符
        Map<String,Object> map=new HashMap<>();
        //解析请求数据
        String query =req.getParameter("query");
        List<Result> results=new ArrayList<>();
        try{
            //根据搜索内容处理搜索业务
            //校验请求数据：搜索内容
            if(query==null && query.trim().length()==0){
                map.put("ok",false);
                map.put("msg","搜索内容为空");
            }else{
                //1.根据搜索内容，进行分词，遍历每个分词
                for(Term t : ToAnalysis.parse(query).getTerms()){
                    String fenci=t.getName();//搜素的分词
                    //如果分词是没有意义的分词，就不执行，就跳过
                    //TODO定义一个数组，包含没有意义的关键词，if(isValid(fenci))continue
                    //2.每个分词，在倒排中查找对应文档（一个分词对应多个文档）
                    List<Weight> weights=index.get(fenci);
                    //3.一个文档转换为一个Result（不同分词可能存在相同文档

                    for(Weight w:weights){
                     //先转换weight为result
                        Result r=new Result();
                        r.setId(w.getDoc().getId());
                        r.setTitle(w.getDoc().getTitle());
                        r.setWeight(w.getWeight());
                        r.setUrl(w.getDoc().getUrl());
                       //拍脑门决定业务：文档内容超过60的部分，隐藏为。。。
                       String content=w.getDoc().getContent();
                        r.setDesc(content.length()<=60?content:content.substring(0,60)+"...");
                    //暂时不做合并，合并操作，需要在List<Result>找已有的，判断docId相同
                        //找已有的，判断docId相同，直接在已有的Result权重加上现有的
                        //不存在，直接放进去
                        results.add(r);

                    }
                }
                // 4.合并完成后，对List<Result>排序，权重降序排序），

                results.sort(new Comparator<Result>() {

                    @Override
                    public int compare(Result o1, Result o2) {
                       // return Integer.compare(o1.getWeight(),o2.getWeight());
                        return  Integer.compare(o2.getWeight(),o1.getWeight());
                    }
                });
             /*   results.sort(((o1, o2) ->{
                            return  Integer.compare(o2.getWeight(),o1.getWeight());

                        });
                results.sort((o1,o2)->Integer.compare(o2.getWeight(),o1.getWeight()));*/
                map.put("ok",true);
                map.put("data",results);
            }


        }catch(Exception e){
            e.printStackTrace();
            map.put("ok",false);
            map.put("msg",true);
        }
        PrintWriter pw= resp.getWriter();//获取输出流
        //设置响应体的内容，map对象序列化为json字符串
        pw.println(new ObjectMapper().writeValueAsString(map));
    }
}
