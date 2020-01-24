package com.example.ProyectoPrueba.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.example.ProyectoPrueba")
public class SpringJdbcConfig {
    @Bean
    public DataSource  mysqlDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://85.10.205.173:3306/testjm");
        dataSource.setUsername("testjm");
        dataSource.setPassword("789456123");

        return dataSource;
    }

}
