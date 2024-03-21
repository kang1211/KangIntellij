
// "/images/**"의 경로 리소스를 외부 경로 uploadPath로 저장 작업

package com.weapon.shop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration// Spring의 java구성 클래스
public class WebMvcConfig implements WebMvcConfigurer {
// WebMvcConfigurer의 구현체 WebMvcConfig
    @Value("${uploadPath}")
    String uploadPath;
// @Value에 의해 application.properties에 uploadPath를 uploadPath필드에 삽입
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/images/**").addResourceLocations(uploadPath);
    }
// WebMvcConfigurer 인터페이스의 addResourceHandlers메서드를 구현
// ResourceHandlerRegistry의 객체를 매개변수로 받아옴
// 객체 registry의 addResourceHandler메서드의("/images/**")에
// addResourceLocations메서드를 매개변수 uploadPath를 넣어서 실행

}
