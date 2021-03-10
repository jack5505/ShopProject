package uz.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
@Configuration
@PropertySource({"classpath:/persistence.properties"})
public class PersistenceConfig {
    @Autowired
    private Environment environment;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("uz.shop.entities");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(hibernateProperties());
        return em;
    }

    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.user"));
        dataSource.setPassword(environment.getProperty("jdbc.pass"));
        return dataSource;
    }

    private final Properties hibernateProperties(){
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect",environment.getProperty("hibernate.dialect"));
        hibernateProperties.setProperty("hibernate.show_sql",environment.getProperty("hibernate.show_sql"));
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto",environment.getProperty("hibernate.hbm2ddl.auto"));
       // hibernateProperties.setProperty("hibernate.connection.release_mode",environment.getProperty("hibernate.connection.release_mode"));
        hibernateProperties.setProperty("hibernate.c3p0.min_size",environment.getProperty("hibernate.c3p0.min_size"));
        hibernateProperties.setProperty("hibernate.c3p0.max_size",environment.getProperty("hibernate.c3p0.max_size"));
        hibernateProperties.setProperty("hibernate.c3p0.acquire_increment",environment.getProperty("hibernate.c3p0.acquire_increment"));
        hibernateProperties.setProperty("hibernate.c3p0.timeout",environment.getProperty("hibernate.c3p0.timeout"));
        hibernateProperties.setProperty("hibernate.c3p0.max_statements",environment.getProperty("hibernate.c3p0.max_statements"));
        //        hibernateProperties.setProperty("hibernate.jdbc.batch_size", env.getProperty("hibernate.jdbc.batch_size"));
//        hibernateProperties.setProperty("hibernate.order_inserts", env.getProperty("hibernate.order_inserts"));
//        hibernateProperties.setProperty("hibernate.order_updates", env.getProperty("hibernate.order_updates"));
//        hibernateProperties.setProperty("hibernate.current_session_context_class", env.getProperty("hibernate.current_session_context_class"));
//        hibernateProperties.setProperty("hibernate.transaction.flush_before_completion", env.getProperty("hibernate.transaction.flush_before_completion"));
//        hibernateProperties.setProperty("hibernate.transaction.auto_close_session", env.getProperty("hibernate.transaction.auto_close_session"));

        return hibernateProperties;
    }

}
