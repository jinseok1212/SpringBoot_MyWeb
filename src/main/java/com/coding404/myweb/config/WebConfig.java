package com.coding404.myweb.config;

import com.coding404.myweb.interceptor.MenuHandler;
import com.coding404.myweb.interceptor.UserAuthHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //인터셉터 빈 등록
    @Bean
    public UserAuthHandler userAuthHandler() {
        return new UserAuthHandler();
    }
    //메뉴처리 인터셉터 빈등록
    @Bean
    public MenuHandler menuHandler() {
        return new MenuHandler();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userAuthHandler())
                .addPathPatterns("/product/*")//상품관련 내역에 모두 추가
                .addPathPatterns("/"); //메인페이지
        registry.addInterceptor(menuHandler())
                .addPathPatterns("/product/*"); //메뉴 post핸들러가 동작할 주소
    }
}
