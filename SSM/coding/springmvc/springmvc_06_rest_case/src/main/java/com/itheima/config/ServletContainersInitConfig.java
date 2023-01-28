package com.itheima.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class ServletContainersInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    //Spring
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    //SpringMVC
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    //设置SpringMVC拦截
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //乱码处理
    protected Filter[] getServletFilters() {
        //处理post乱码
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        return new Filter[]{filter};
    }
}
