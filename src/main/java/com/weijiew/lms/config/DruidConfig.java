package com.weijiew.lms.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @Description
 * @ClassName DruidConfig
 * @Author jie wei
 * @date 2020.11.15 22:45
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix ="spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet());

        HashMap<String,String> iniParameters = new HashMap<>();

        iniParameters.put("loginUsername","admin");
        iniParameters.put("loginPassword","123456");

        bean.setInitParameters(iniParameters);
        return bean;
    }
}
