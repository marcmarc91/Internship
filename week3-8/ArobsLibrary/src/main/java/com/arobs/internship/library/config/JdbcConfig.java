package com.arobs.internship.library.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

//@Configuration
public class JdbcConfig {
    private static final Logger log = LoggerFactory.getLogger(JdbcConfig.class);

    //    @Bean
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/arobs_library");
        dataSource.setUsername("root");
        dataSource.setPassword("12345678");
        log.info("DataSource created.");

        return dataSource;
    }


}
