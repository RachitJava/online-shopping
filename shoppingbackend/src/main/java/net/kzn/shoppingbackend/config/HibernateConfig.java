package net.kzn.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

@Configuration
@ComponentScan(basePackages= {"net.kzn.shoppingbackend.dto"})
public class HibernateConfig {
	
	
	//Hum 5 static final variable create karna ja rahe hai jo db related info. ko provide karenga.
	
	
	private final static String DATABASE_URL="jdbc:h2:tcp://localhost/~/onlineshoppings";
	private final static String DATABASE_DRIVER="org.h2.Driver";
	private final static String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME="sa";
	private final static String DATABASE_PASSWORD="";
	
	
	//DataSource Bean
	@Bean
	
	//Ya bean create karega jo hum application ma use karenga aur iska return type datasource hoga
	
	public DataSource getDataSource() {
		
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName(DATABASE_DRIVER);
		datasource.setUrl(DATABASE_URL);
		datasource.setUsername(DATABASE_USERNAME);
		datasource.setPassword(DATABASE_PASSWORD);
		
		//Iss bean ko hum koi naam nhi da rahe hai getDataSoure()- by convection return karega datasource bean ko.
		
		return datasource;
	
	}
	
	//SessionFactory Bean
	@Bean
	
	public SessionFactory getSessionFactory(DataSource datasource) {
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(datasource);
		
		//iss datasource ke help sa hum sessionfactory ko build kar rahe hai
		
		builder.addProperties(getHibernateProperties()); //Huma ek private method banana hai ctr+1
		
		builder.scanPackages("net.kzn.shoppingbackend.dto");
		
		return builder.buildSessionFactory();
	}

	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		
		properties.put("hibernate.show_sql", true);
		
		properties.put("hibernate.format_sql", true);
		
		return properties;
	}
	
	//TransactionManager Bean
	@Bean	
	
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		
		//Jo previous bean create ke hai waha sa issa sessionfactory mil jayega
		
		HibernateTransactionManager transactionManager= new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
	}

}
