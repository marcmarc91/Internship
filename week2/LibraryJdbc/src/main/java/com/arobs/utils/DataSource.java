package com.arobs.utils;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource implements Connector {
    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource dataSource;

    private DataSource() {
    }

    static {
        config.setJdbcUrl(JDBC_URL);
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.setMaximumPoolSize(4);
        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection.toString());

        return connection;
    }
}
