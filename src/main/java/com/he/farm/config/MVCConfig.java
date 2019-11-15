package com.he.farm.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: 贺谋昌
 * @Date: 2019/11/2 11:52
 * @Description:
 */
@Configuration
public class MVCConfig {
    public static final Logger logger= LogManager.getLogger(MVCConfig.class);
    @Bean
    public WebMvcConfigurer mvcConfigurer() {

        return new WebMvcConfigurer() {
            /*全局CORS配置,也可以在相关Controller的类或者方法中使用注解@CrossOrigin进行局部配置*/
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                logger.info("添加CORS信息。。。。。");
                //registry.addMapping("/api/**");
                //注意：如果只指定/api/**，则部分请求方法不能使用。如：update
                registry.addMapping("/**")
                        .allowedOrigins("*") //允许任何源url使用
                        .allowedMethods("*") //允许任何方法（"GET","PUT","POST","DELETE"等）
                        .allowCredentials(true).maxAge(3600);
            }
        };
    }
}