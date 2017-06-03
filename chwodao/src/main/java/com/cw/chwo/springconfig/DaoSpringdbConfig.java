package com.cw.chwo.springconfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

/**
 * Created by handl on 2017/6/3.
 */
@Configuration
public class DaoSpringdbConfig {

    @Autowired
    private Environment environment;

    /**
     * 配置druid连接池
     * @return
     */
    @Bean(initMethod = "init",destroyMethod = "close")
    public DruidDataSource druidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(environment.getProperty(""));
        druidDataSource.setUrl(environment.getProperty(""));
        druidDataSource.setUsername(environment.getProperty(""));
        druidDataSource.setPassword(environment.getProperty(""));
//        druidDataSource.setInitialSize(environment.getProperty(""));
//        druidDataSource.setMaxActive(environment.getProperty(""));
//        druidDataSource.setMinIdle(environment.getProperty(""));
//        druidDataSource.setMaxWait(environment.getProperty(""));
//        druidDataSource.setTimeBetweenEvictionRunsMillis(environment.getProperty(""));
//        druidDataSource.setMinEvictableIdleTimeMillis(environment.getProperty(""));
        druidDataSource.setValidationQuery(environment.getProperty(""));
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setRemoveAbandoned(true);
//        druidDataSource.setRemoveAbandonedTimeout(environment.getProperty(""));
        druidDataSource.setLogAbandoned(true);
        /**druidDataSource.setFilters(environment.getProperty(""));
        druidDataSource(environment.getProperty(""));
        druidDataSource(environment.getProperty(""));
        druidDataSource(environment.getProperty(""));
        druidDataSource(environment.getProperty(""));
        druidDataSource(environment.getProperty(""));
        druidDataSource(environment.getProperty(""));
        druidDataSource(environment.getProperty(""));
        druidDataSource(environment.getProperty(""));*/
        return druidDataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(druidDataSource());
        sessionFactoryBean.setTypeAliasesPackage("com.cw.chwo.mapper");
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return sessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.cw.chwo.mapper");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        return mapperScannerConfigurer;
    }
}
