package cn.loveyx815.rocketmq.mqtransaction.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.loveyx815.rocketmq.mqtransaction.dao.PointDao;
import cn.loveyx815.rocketmq.mqtransaction.dao.UserDao;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/02/04 22:58
 * @Description: 双数据源配置
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = "testDataSource")
    @Primary
    @Qualifier("testDataSource")
    @ConfigurationProperties(prefix="spring.datasource.hikari.mysql")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "formalDataSource")
    @Qualifier("formalDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.formal.mysql")
    public DataSource formalDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name="testJdbcTemplate")
    public JdbcTemplate testJdbcTemplate (
            @Qualifier("testDataSource")  DataSource testDataSource ) {
        return new JdbcTemplate(testDataSource);
    }

    @Bean(name = "formalJdbcTemplate")
    public JdbcTemplate formalJdbcTemplate(
            @Qualifier("formalDataSource") DataSource formalDataSource){
        return new JdbcTemplate(formalDataSource);
    }

    @Bean(name="userDao")
    public UserDao getUserDao(@Qualifier("testJdbcTemplate") JdbcTemplate jdbcTemplate){
        UserDao userDao =new UserDao();
        userDao.setJdbcTemplate(jdbcTemplate);
        return  userDao;
    }
    @Bean(name="pointDao")
    public PointDao getPointDao(@Qualifier("formalJdbcTemplate") JdbcTemplate jdbcTemplate){
        PointDao pointDao =new PointDao();
        pointDao.setJdbcTemplate(jdbcTemplate);
        return  pointDao;
    }
}
