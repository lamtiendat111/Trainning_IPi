//package com.example.demo.config;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "slaveEntityManagerFactory",
//        transactionManagerRef = "slaveTransactionManager",
//        basePackages = {"com.example.demo.repsitory.slave"}
//  
//   
//)
//public class slaveDataSource {
//	@Bean(name = "slavedataSource")
//    @ConfigurationProperties(prefix = "slave.datasource")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
//	   @ConfigurationProperties(prefix = "slave.datasource")
//    @Bean(name = "slaveEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean
//    barEntityManagerFactory(
//            EntityManagerFactoryBuilder builder,
//					@Qualifier("slavedataSource") DataSource dataSource) {
//		   
//		return builder.dataSource(dataSource).packages("com.example.demo.entity.slave")
//				.persistenceUnit("Entity")
//				.build();
//	}
//
//	@ConfigurationProperties(prefix = "slave.datasource")
//    @Bean(name = "slaveTransactionManager")
//    public PlatformTransactionManager productTransactionManager(
//            @Qualifier("slaveEntityManagerFactory") EntityManagerFactory
//                    slaveEntityManagerFactory
//    ) {
//        return new JpaTransactionManager(slaveEntityManagerFactory);
//    }
//
//}
