package com.cw.shwo.springconfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by handl on 2017/6/3.
 */
@Configuration
@PropertySource("classpath:/database.properties")
public class DaoSpringdbConfig {

    @Autowired
    private Environment environment;

    /**
     * 配置druid连接池
     * @return
     */
    /*@Bean
    public DruidDataSource druidDataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        //驱动类名称
        druidDataSource.setDriverClassName(environment.getProperty("db.driverclassname"));
        //数据库地址
        druidDataSource.setUrl(environment.getProperty("db.url"));
        //用户名
        druidDataSource.setUsername(environment.getProperty("db.username"));
        //密码
        druidDataSource.setPassword(environment.getProperty("db.password"));
        //初始化建立连接个数
        druidDataSource.setInitialSize(Integer.valueOf(environment.getProperty("db.initialsize")));
        //最大连接池数量
        druidDataSource.setMaxActive(Integer.valueOf(environment.getProperty("db.maxactive")));
        //最小连接池数量
        druidDataSource.setMinIdle(Integer.valueOf(environment.getProperty("db.minidle")));
        //获取连接时最大等待时间，单位毫秒
        druidDataSource.setMaxWait(Long.valueOf(environment.getProperty("db.maxwait")));
        //是否缓存preparedStatement,也就是PSCache
        druidDataSource.setPoolPreparedStatements(Boolean.valueOf(environment.getProperty("db.poolpreparedstatements")));
        //要启用PSCache，必须配置大于0，当大于0时,poolPreparedStatements自动触发修改为true
        druidDataSource.setMaxOpenPreparedStatements(Integer.valueOf(environment.getProperty("db.maxOpenpreparedstatements")));
        //用来检测连接是否有效的sql，要求是一个查询语句。 如果validationQuery为null，testOnBorrow、testOnReturn、 testWhileIdle都不会其作用。
        druidDataSource.setValidationQuery(environment.getProperty("db.validationquery"));
        //申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能
        druidDataSource.setTestOnBorrow(Boolean.valueOf(environment.getProperty("db.testonborrow")));
        //归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能
        druidDataSource.setTestOnReturn(Boolean.valueOf(environment.getProperty("db.testonreturn")));
        //建议配置为true，不影响性能，并且保证安全性。 申请连接的时候检测，如果空闲时间大于 timeBetweenEvictionRunsMillis， 执行validationQuery检测连接是否有效。
        druidDataSource.setTestWhileIdle(Boolean.valueOf(environment.getProperty("db.testwhileidle")));
        //1) Destroy线程会检测连接的间隔时间 2) testWhileIdle的判断依据，详细看testWhileIdle属性的说明
        druidDataSource.setTimeBetweenEvictionRunsMillis(Long.valueOf(environment.getProperty("db.timebetweenevictionrunsmillis")));
        //属性类型是字符串，通过别名的方式配置扩展插件
        druidDataSource.setFilters(environment.getProperty("db.filters"));
        return druidDataSource;
    }*/

    @Bean
    public DruidDataSource druidDataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        //驱动类名称
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //数据库地址
        druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/chwo");
        //用户名
        druidDataSource.setUsername("root");
        //密码
        druidDataSource.setPassword("root");
        return druidDataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException, SQLException {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(druidDataSource());
        sessionFactoryBean.setTypeAliasesPackage("com.cw.chwo.mapper");
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper*//*.xml"));
        return sessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.cw.chwo.mapper");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        mapperScannerConfigurer.setAnnotationClass(Mapper.class);
        return mapperScannerConfigurer;
    }
}
