package com.app.dbmapping;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.app.bo.AuthorBo;

@SpringBootApplication
@ComponentScan(basePackages = "com.app")
@EnableJpaRepositories(basePackages = "com.app")
@EntityScan(basePackages = "com.app")
public class Proj17DataBaseMappingExtendedApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proj17DataBaseMappingExtendedApplication.class, args);
	}
	
//	@Bean
//	public DataSourceTransactionManager transactionmanager(DataSource dataSource) {
//		return new DataSourceTransactionManager(dataSource);
//	}

}
