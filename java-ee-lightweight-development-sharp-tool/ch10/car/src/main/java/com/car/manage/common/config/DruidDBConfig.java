package com.car.manage.common.config;

import com.car.manage.system.service.impl.SystemServiceImpl;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * DruidDBConfig类被@Configuration标注，用作配置信息.
 * DataSource对象被@Bean声明，为Spring容器所管理，
 * <p>
 * jdbc.url=${jdbc.url}
 * 最新的支持方式如下:
 * jdbc.url=@jdbc.url@
 * <p>
 * 表示这里定义的DataSource将覆盖其他来源的DataSource。
 */
@Configuration
public class DruidDBConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(DruidDBConfig.class);

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.filters}")
    private String filters;

    @Value("{spring.datasource.connectionProperties}")
    private String connectionProperties;

    /**
     * data source.
     *
     * @return data source
     */
    @Bean // 声明其为Bean实例
    @Primary // 在同样的DataSource中，首先使用被标注的DataSource
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);

        // configuration
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);

        try {
            datasource.setFilters(filters);

            List<Filter> filters = datasource.getProxyFilters();
            filters.forEach(filter -> {
                if (!(filter instanceof WallFilter)) {
                    return;
                }

                WallConfig config = ((WallFilter) filter).getConfig();

                if (config == null) {
                    config = new WallConfig();
                }

                config.setNoneBaseStatementAllow(Boolean.TRUE);
                ((WallFilter) filter).setConfig(config);
            });

            String url = dbUrl.substring(0, dbUrl.indexOf("?"));
            String db = url.substring(url.lastIndexOf("/") + 1);
            SystemServiceImpl.setDefaultDb(db);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        datasource.setConnectionProperties(connectionProperties);
        return datasource;
    }
}
