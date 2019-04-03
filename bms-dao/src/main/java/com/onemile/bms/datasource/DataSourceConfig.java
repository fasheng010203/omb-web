package com.onemile.bms.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.onemile.bms.datasource.annotation.DynamicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Eric
 * @Description:
 * @date 18/4/9
 */

@Configuration
public class DataSourceConfig {

    @Autowired
    private Environment env;

    /**
     * bms任务库
     *
     * @return
     */
    public DruidDataSource bmsDs() {
        return createDataSource(env.getProperty("bms.url"), env.getProperty("bms.username"), env.getProperty("bms.password"));
    }

    /**
     * zxshare任务库
     *
     * @return
     */
    public DruidDataSource shareDs() {
        return createDataSource(env.getProperty("share.url"), env.getProperty("share.username"), env.getProperty("share.password"));
    }

    /**
     * 任务库
     *
     * @return
     */
    public DruidDataSource lmsDs() {
        return createDataSource(env.getProperty("lms.url"), env.getProperty("lms.username"), env.getProperty("lms.password"));
    }

    /**
     * lss_core
     *
     * @return
     */
    public DruidDataSource lsscoreDs() {
        return createDataSource(env.getProperty("lsscore.url"), env.getProperty("lsscore.username"), env.getProperty("lsscore.password"));
    }


    @Bean
    @Primary
    public DataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();

        Map<Object, Object> map = new HashMap<>();
        map.put("bmsDs", this.bmsDs());
        map.put("shareDs", this.shareDs());
        map.put("lmsDs", this.lmsDs());
        map.put("lsscoreDs", this.lsscoreDs());
        //设置数据源
        dynamicDataSource.setTargetDataSources(map);
        //设置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(this.bmsDs());
        return dynamicDataSource;
    }


    public DruidDataSource createDataSource(String url, String username, String password) {

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setInitialSize(30);
        dataSource.setMinIdle(0);
        dataSource.setMaxActive(100);
        dataSource.setMaxWait(60000);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnReturn(false);
        dataSource.setPoolPreparedStatements(true);
        dataSource.setTimeBetweenEvictionRunsMillis(60000);
        dataSource.setMinEvictableIdleTimeMillis(300000);

        try {
            //todo 打开防火墙 执行多条语句异常
            dataSource.setFilters("stat");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dataSource.setUseGlobalDataSourceStat(true);

        dataSource.setConnectionProperties(env.getProperty("spring.datasource.connectionProperties"));

        return dataSource;

    }

    /**
     * 开启druid监控
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean druidStatView() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();
        registrationBean.setName("DruidStatView");
        StatViewServlet servlet = new StatViewServlet();
        registrationBean.setServlet(servlet);

        Map<String, String> initParameters = new HashMap<>();
//        initParameters.put("allow", "127.0.0.1");
//        initParameters.put("loginUsername", "admin");
//        initParameters.put("loginPassword", "admin123456");
        registrationBean.setInitParameters(initParameters);

        Collection<String> urlMappings = new ArrayList<>();
        urlMappings.add("/druid/*");
        registrationBean.setUrlMappings(urlMappings);

        return registrationBean;
    }


    /**
     * 开启uri监控
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        // 配置过滤项
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*,*.woff2,*.woff,*.map");
        return filterRegistrationBean;
    }


    /**
     * 配置bms事务
     *
     * @param
     * @return
     */
    @Bean
    public PlatformTransactionManager txManagerBms() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(bmsDs());
        return dataSourceTransactionManager;
    }


    /**
     * 配置Lms事务
     *
     * @param
     * @return
     */
    @Bean
    public PlatformTransactionManager txManagerLms() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(lmsDs());
        return dataSourceTransactionManager;
    }

    /**
     * 配置Share事务
     *
     * @return
     */
    @Bean
    public PlatformTransactionManager txManagerShare() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(shareDs());
        return dataSourceTransactionManager;
    }

}