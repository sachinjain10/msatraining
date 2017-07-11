package com.sachin;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.mysql.cj.jdbc.MysqlDataSource;

@Configuration
@EnableJpaRepositories(basePackages = { "com.external" })
public class PersistenceConfig {

	@Bean
	DataSource dataSource(Environment env) {
		
		DriverManagerDataSource ds = new DriverManagerDataSource();

		//MysqlDataSource ds = new MysqlDataSource();
		ds.setUrl("jdbc:mysql://localhost:3306/msa?serverTimezone=UTC");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		
		return ds;// new HikariDataSource(dataSourceConfig);
	}

	/*
	 * @Bean(destroyMethod = "close") DataSource dataSource(Environment env) {
	 * HikariConfig dataSourceConfig = new HikariConfig();
	 * dataSourceConfig.setDriverClassName(env.getRequiredProperty("db.driver"))
	 * ; dataSourceConfig.setJdbcUrl(env.getRequiredProperty("db.url"));
	 * dataSourceConfig.setUsername(env.getRequiredProperty("db.username"));
	 * dataSourceConfig.setPassword(env.getRequiredProperty("db.password"));
	 * 
	 * return new HikariDataSource(dataSourceConfig); }
	 */

	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Environment env) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan("com.sachin");

		Properties jpaProperties = new Properties();

		// Configures the used database dialect. This allows Hibernate to create
		// SQL
		// that is optimized for the used database.
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

		// Specifies the action that is invoked to the database when the
		// Hibernate
		// SessionFactory is created or closed.
		//jpaProperties.put("hibernate.hbm2ddl.auto", "create-drop");

		// Configures the naming strategy that is used when Hibernate creates
		// new database objects and schema elements
		jpaProperties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");

		// If the value of this property is true, Hibernate writes all SQL
		// statements to the console.
		jpaProperties.put("hibernate.show_sql", "false");

		// If the value of this property is true, Hibernate will format the SQL
		// that is written to the console.
		jpaProperties.put("hibernate.format_sql", "true");

		entityManagerFactoryBean.setJpaProperties(jpaProperties);

		return entityManagerFactoryBean;
	}

	// Add the other beans here


	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
}
