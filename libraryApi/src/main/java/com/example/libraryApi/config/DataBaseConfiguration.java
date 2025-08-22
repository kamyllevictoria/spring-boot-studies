package com.example.libraryApi.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

//bean
@Configuration

public class DataBaseConfiguration {

    @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    @Value("${spring.datasource.driverClassName}")
    String driver;

    @Bean
    public DataSource hikariDataSource(){
        HikariConfig config = new HikariConfig();
        config.setUsername(username);
        config.setPassword(password);
        config.setJdbcUrl(url);
        config.setDriverClassName(driver);

        config.setMaximumPoolSize(10); //maximo de conexoes liberadas
        config.setMinimumIdle(1); //tamanho inicial do pool de conexoes liberadas

        config.setPoolName("library-db-pool");
        config.setMaxLifetime(600000); //600 mil ms
        config.setConnectionTimeout(100000);
        return new HikariDataSource(config);
    }

}
