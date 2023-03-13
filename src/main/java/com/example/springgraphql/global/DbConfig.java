package com.example.springgraphql.global;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * db config
 * </pre>
 */

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.example.springgraphql.domain.product.repository", "com.example.springgraphql.domain.review.repository"},
        entityManagerFactoryRef = "h2EntityManager",
        transactionManagerRef = "h2TransactionManager"
)
public class DbConfig {

    @Value("${spring.jpa.show-sql}")
    private Boolean showSql;

    @Value("${spring.jpa.properties.hibernate.format_sql}")
    private Boolean formatSql;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    @Value("${spring.jpa.hibernate.naming.implicit-strategy}")
    private String implicitStrategy;

    @Value("${spring.jpa.hibernate.naming.physical-strategy}")
    private String physicalStrategy;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    DataSource dataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean h2EntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());

        // Entity 패키지 경로 지정
        em.setPackagesToScan("com.example.springgraphql.domain.product.entity",
                "com.example.springgraphql.domain.review.entity");

        // Hibernate 구현체용 JpaVendorAdapter 설정
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(adapter);

        // jpa 설정
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.ddl-auto", ddlAuto);
        properties.put("hibernate.show_sql", showSql);
        properties.put("hibernate.format_sql", formatSql);
        properties.put("hibernate.implicit_naming_strategy", implicitStrategy);
        properties.put("hibernate.physical_naming_strategy", physicalStrategy);
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    public PlatformTransactionManager h2TransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(h2EntityManager().getObject());

        return transactionManager;
    }
}
