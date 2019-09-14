package com.silvio.eventospring;

import java.net.URI;
import java.net.URISyntaxException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 *
 * @author silvio
 */
@Configuration
public class DataConfiguration {
    
    
    //CONFIGURAÇAO DA CONECÇAO DO MYSQL E JPA
    /**
     * Bean de configuraçao de coneccao com o banco
     * @return coneccao com o banco
     *
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/eventospring");
        dataSource.setUsername("root");
        dataSource.setPassword("PASSWORD");
        return dataSource;
    }
    
    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true); // hibernate cria as tabelas automaticamente
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL57Dialect");
        adapter.setPrepareConnection(true);
        return adapter;
    }*/
    
    //CONNECTION CONFIGURATION OF HEROKU POSTGRESQL
    @Bean
    public BasicDataSource dataSource() throws URISyntaxException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }
    
}
