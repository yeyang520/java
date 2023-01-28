package com.example.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@Configuration
public class MpConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        //1.定义拦截器
        MybatisPlusInterceptor mInterceptor = new MybatisPlusInterceptor();
        //2.添加拦截器
        mInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mInterceptor;
    }
}
