package com.ab.lxoa.web.interceptor;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author zhoushuobiao
 * todo @SpringBootConfiguration
 */
public class WebAppConfig extends WebMvcConfigurationSupport {

    private final ApiInterceptor apiInterceptor;

    public WebAppConfig(ApiInterceptor apiInterceptor) {
        this.apiInterceptor = apiInterceptor;
    }

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(apiInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login/**", "/logout/**", "/error/**"); //"/menu/**"
        super.addInterceptors(registry);
    }
}
