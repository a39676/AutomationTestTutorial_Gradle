package demo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan(
	basePackages = { 
		"demo.mapper", 
		"demo.*.mapper" }, 
	sqlSessionTemplateRef = "database1SqlSessionTemplate"
)
public class Database1Config {

	@Primary
	@Bean(name = "dataSource1Properties")
	@ConfigurationProperties(prefix = "spring.datasource.database1")
	public DataSourceProperties dataSource1Properties() {
		return new DataSourceProperties();
	}

	@Primary
	@Bean(name = "dataSource1")
	public BasicDataSource dataSource1(@Qualifier("dataSource1Properties") DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().type(BasicDataSource.class).build();
	}

	@Primary
	@Bean(name = "database1SqlSessionFactory")
	public SqlSessionFactoryBean database1SqlSessionFactory(@Qualifier("dataSource1") DataSource dataSource) {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

		Properties mybatisProperties = new Properties();
		mybatisProperties.setProperty("cacheEnabled", "true");
		sqlSessionFactoryBean.setConfigurationProperties(mybatisProperties);
		sqlSessionFactoryBean.setDataSource(dataSource);

		return sqlSessionFactoryBean;
	}

	@Primary
	@Bean(name = "database1TransactionManager")
	public DataSourceTransactionManager database1TransactionManager(@Qualifier("dataSource1") DataSource dataSource) {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
		return transactionManager;
	}

	@Primary
	@Bean(name = "database1SqlSessionTemplate")
	public SqlSessionTemplate database1SqlSessionTemplate(
			@Qualifier("database1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

}
