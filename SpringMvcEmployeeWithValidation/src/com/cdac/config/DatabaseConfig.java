package com.cdac.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
	@Autowired
	private DataSource dataSource;
	
	@Bean(name="template")
	public NamedParameterJdbcTemplate getJdbcTemplate() {
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);
		//template.setDataSource(dataSource);
		return template;
	}
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:postgresql://10.212.8.198:5432/ecib");
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUsername("ecib_user");
		dataSource.setPassword("ecgcecib");
		return dataSource;
	}
	@Bean(name = "transactionmanager")
	public DataSourceTransactionManager getDataSourceTransactionManager() {
		DataSourceTransactionManager b = new DataSourceTransactionManager();
		b.setDataSource(dataSource);
		return b;
	}
}
