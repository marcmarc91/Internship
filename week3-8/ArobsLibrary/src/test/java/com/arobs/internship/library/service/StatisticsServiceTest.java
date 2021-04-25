package com.arobs.internship.library.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StatisticsServiceTest {
    private static final Logger log = LoggerFactory.getLogger(StatisticsServiceTest.class);
    @Autowired
    StatisticService statisticService;

    @Test
    @DisplayName("Get Top Book Rented")
    void getTopBookRented() {

    }

}
