package com.duibuqi;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
*@author CC
*@Description
*/
@Configuration
@MapperScan(basePackages = {"com.duibuqi.dao.primary"},sqlSessionFactoryRef="primarySqlSessionFactory")
@PropertySource({"classpath:db.properties"})
public class PrimaryDataSourceConfig {

    @Value("${spring.primary.url}")
    public String url;

    @Value("${spring.primary.username}")
    public String username;

    @Value("${spring.primary.password}")
    public String password;

    @Value("${spring.primary.driver-class-name}")
    public String driver;

    @Bean(name = "primaryDataSource")
    @Primary
    public DataSource primaryDataSource(){
        HikariConfig hikariConfig  = new HikariConfig();
        hikariConfig.setPoolName("primary");
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.setDriverClassName(driver);
        return new HikariDataSource(hikariConfig);
    }

    @Bean(name = "primaryTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(primaryDataSource());
    }

    @Bean(name = "primarySqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("primaryDataSource") DataSource masterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);

        return sessionFactory.getObject();
    }

}
