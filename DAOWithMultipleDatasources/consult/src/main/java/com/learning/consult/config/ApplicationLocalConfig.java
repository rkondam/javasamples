package com.learning.consult.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Profile({"local","test"})
@Configuration
public class ApplicationLocalConfig {

	@Value("${consult.db1.driver-classname}")
	private String driverClassName;

	// DB1 Props
	@Value("${consult.db1.url}")
	private String url_db1;
	
	@Value("${consult.db1.username}")
	private String username_db1;
	
	@Value("${consult.db1.password}")
	private String password_db1;
	
	//DB2 props
	@Value("${consult.db2.url}")
	private String url_db2;
	
	@Value("${consult.db2.username}")
	private String username_db2;
	
	@Value("${consult.db2.password}")
	private String password_db2;



	@Bean
    public DataSource consultDataSource_db2() 
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driverClassName);
        dataSourceBuilder.url(url_db2);
        dataSourceBuilder.username(username_db2);
        dataSourceBuilder.password(password_db2);
        return dataSourceBuilder.build();
    }
	
	@Bean
    public DataSource consultDataSource_db1() 
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driverClassName);
        dataSourceBuilder.url(url_db1);
        dataSourceBuilder.username(username_db1);
        dataSourceBuilder.password(password_db1);
        return dataSourceBuilder.build();
    }
			
	@Bean
	public NamedParameterJdbcTemplate jdbcTemplate_db1(DataSource consultDataSource_db1) {
		return new NamedParameterJdbcTemplate(consultDataSource_db1);
	}

	@Bean
	public NamedParameterJdbcTemplate jdbcTemplate_db2(DataSource consultDataSource_db2) {
		return new NamedParameterJdbcTemplate(consultDataSource_db2);
	}


}
