package com.example.starter.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

@Configuration
@EnableJpaRepositories(basePackages = ["com.example.starter"])
@EnableTransactionManagement
@EnableJpaAuditing
class PersistenceConfig {

	@Bean
	fun dataSource(): DataSource {
		val builder = EmbeddedDatabaseBuilder()
		return builder.setType(EmbeddedDatabaseType.H2)
				.build()
	}

	@Bean
	fun transactionManager(entityManagerFactory: EntityManagerFactory): PlatformTransactionManager {
		val txManager = JpaTransactionManager()
		txManager.setEntityManagerFactory(entityManagerFactory)
		return txManager
	}
}
