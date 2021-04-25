package com.arobs.internship.library.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.arobs.internship.library.repository")
@EntityScan("com.arobs.internship.library.entity")
@EnableTransactionManagement
public class AppConfig {

}
