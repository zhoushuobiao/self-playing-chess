package com.ab.lxoa.web;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author xzwang
 * @date 2018/11/08
 */
@SpringBootApplication(scanBasePackages = {"com.ab.lxoa"})
@EnableTransactionManagement
@ServletComponentScan
@MapperScan("com.ab.lxoa.dao.mapper") //这里配置Mapper扫描,则DAO中不需要添加@Mapper注解
/**
 * 修改启动类，继承 SpringBootServletInitializer 并重写 configure 方法
 */
public class LxoaWebApplication{

    private static Logger log = LoggerFactory.getLogger(LxoaWebApplication.class);

/*  @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new ApiFilter());
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/*"); //这个请求会走filter。 比如是/api/product/out/list就不会走filter
        //urlPatterns.add("*.do");
        registrationBean.setUrlPatterns(urlPatterns);
        registrationBean.addInitParameter("name", "Shachor");
        registrationBean.setName("ApiFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }*/

    public static void main(String[] args) {
        log.debug("~~~~~~~~~link start~~~~~~~~~");
        SpringApplication.run(LxoaWebApplication.class, args);
        log.debug("~~~~~~~~~start success~~~~~~~~~");
    }
}