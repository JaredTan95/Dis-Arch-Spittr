package cn.tanjianff.Spittr.album;

import cn.tanjianff.Spittr.album.repository.JdbcTemplate.JdbcAlbumsRepository;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/*
 * Created by tanjian on 16/9/14.
 * 配置类
 */
@Configuration
@ComponentScan("cn.tanjianff")
public class Config {
    /* 配置C3P0数据库连接池*/
    @Bean
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass("com.mysql.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://123.207.83.185:3306/Spittr");
        ds.setUser("dev");
        ds.setPassword("123456");
        ds.setInitialPoolSize(5);
        ds.setMaxPoolSize(10);
        ds.setMinPoolSize(3);
        ds.setMaxIdleTime(600);
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public JdbcAlbumsRepository jdbcAlbumsRepository(JdbcTemplate jdbcTemplate){
        return new JdbcAlbumsRepository(jdbcTemplate);
    }
}
