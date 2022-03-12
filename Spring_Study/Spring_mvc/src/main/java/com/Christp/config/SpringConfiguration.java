package com.Christp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @ClassName SpringConfiguration
 * @Description 作为当前Spring的核心加载项目，引用数据源
 * @Author com.com.Christp
 * @Date 2021/11/27 14:54
 * @Version 1.0
 **/

//表示该类是Spring的核心配置类
@Configuration
//<context:component-scan base-package="com.com.com.Christp"/>
@ComponentScan("com.Christp")
//<import resource="">
@Import(DataSourceConfiguration.class)//如果要多重引入就用@Import({xx.class,xx.class...})
public class SpringConfiguration {

}
