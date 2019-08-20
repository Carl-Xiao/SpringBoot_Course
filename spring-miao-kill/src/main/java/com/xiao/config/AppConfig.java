package com.xiao.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableConfigurationProperties(ConfigProperties.class)
public class AppConfig {
    private static final Logger log = LoggerFactory.getLogger(AppConfig.class);
    @Autowired
    ConfigProperties configProperties;
    /*@Value("${spring.datasource.useGlobalDataSourceStat}")
    private boolean useGlobalDataSourceStat;*/
    @Bean     //声明其为Bean实例
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(configProperties.getUrl());
        datasource.setUsername(configProperties.getUsername());
        datasource.setPassword(configProperties.getPassword());
        datasource.setDriverClassName(configProperties.getDriverClassNname());
        //configuration
        datasource.setInitialSize(configProperties.getInitialSize());
        datasource.setMinIdle(configProperties.getMinIdle());
        datasource.setMaxActive(configProperties.getMaxActive());
        datasource.setMaxWait(configProperties.getMaxWait());
        datasource.setTimeBetweenEvictionRunsMillis(configProperties.getTimeBetweenEvictionRunsMillis());
        datasource.setMinEvictableIdleTimeMillis(configProperties.getMinEvictableIdleTimeMillis());
        datasource.setValidationQuery(configProperties.getValidationQuery());
        datasource.setTestWhileIdle(configProperties.isTestWhileIdle());
        datasource.setTestOnBorrow(configProperties.isTestOnBorrow());
        datasource.setTestOnReturn(configProperties.isTestOnReturn());
        datasource.setPoolPreparedStatements(true);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(configProperties.getMaxPoolPreparedStatementPerConnectionSize());
        datasource.setDbType(configProperties.getType());
        //连接泄露检查，长时间不归回则强制回收连接
        datasource.setBreakAfterAcquireFailure(true);
        datasource.setRemoveAbandoned(true);
        //datasource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);
        try {
            datasource.setFilters(configProperties.getFilters());
        } catch (SQLException e) {
            log.error("druid configuration initialization filter: " + e);
        }
        datasource.setConnectionProperties(configProperties.getConnectionProperties());
        return datasource;
    }
}
