package com.moumou.tomcat;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Config {
    public Map<String,String> servletNameToServletClassNameMap;
    public LinkedHashMap<String,String> urlToServletNameMap;

    public Config(Map<String, String> servletNameToServletClassNameMap, LinkedHashMap<String, String> urlToServletNameMap) {
    this.servletNameToServletClassNameMap=servletNameToServletClassNameMap;
    this.urlToServletNameMap=urlToServletNameMap;
    }
}

