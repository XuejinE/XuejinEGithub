package com.moumou.tomcat;

import com.moumou.tomcat.http.HttpServer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ConfigReader {
    public Config read(String name) throws IOException {
         Map<String,String> servletNameToServletClassNameMap=new HashMap<>();
         LinkedHashMap<String,String> urlToServletNameMap=new LinkedHashMap<>();

        String filename = String.format("%s/%s/WEB_INF/web.conf", HttpServer.WEBAPPS_BASE, name);
        String stage = "start";   //"servlets"/"mappings"


        //进行文本文件的读取
        try (InputStream is = new FileInputStream(filename)) {
            Scanner scanner = new Scanner(is,"UTF-8");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                System.out.println(line);
                if (line.isEmpty() || line.startsWith("#")) {
                    //如果是空行，或者注释行跳过
                    continue;
                }
                switch (stage) {
                    case "start":
                        if (line.equals("servlets:")) {
                            stage = "servlets";
                        }
                        break;
                    case "servlets":
                        if (line.equals("servlet-mappings")) {
                            stage = "mappings";
                        } else {
                            //进行ServletName=>ServletClassName的解析
                            String[] parts = line.split("=");
                            String servletName = parts[0].trim();
                            String servletClassName = parts[1].trim();
                            servletNameToServletClassNameMap.put(servletName, servletClassName);
                        }
                        break;
                    case "mappings":
                        //进行URL=>ServletName的解析
                        String[] parts = line.split("=");
                        String url = parts[0].trim();
                        String servletName = parts[1].trim();
                        urlToServletNameMap.put(url, servletName);
                        break;
                }
            }
        }
        return new Config(servletNameToServletClassNameMap,urlToServletNameMap);
    }
}
