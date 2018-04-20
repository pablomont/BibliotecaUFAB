package uepb.web.ufab.config;

import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import exception.para;

@Configuration 
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class DBConfig {
	/**
	* <h1>DBConfig</h1>
	* DBConfig configura o banco de dados ligado ao sistema
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/	
	@Autowired
    private Environment env;
	
	@Bean
	/** Inicia o template do Hibernate
	 *  @return template especifico do hibernate definido por sessionFactory  
	 */
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate(sessionFactory());
	}
	
	@Bean
	/** Criação do SessionFactory alocando DataSource, PackagesToScan e HibernateProperties
	 * 	@exception IOException
	 *  @return SessionFactory   
	 */
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(getDataSource());
		lsfb.setPackagesToScan("uepb.web.ufab.model");
		lsfb.setHibernateProperties(hibernateProperties());
		try {
			lsfb.afterPropertiesSet();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lsfb.getObject();
	}
	
	/** Criação do DataSource alocando DriverClassName, Url, Username e Password da database 
	 *  @return dataSource   
	 */
	@Bean
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    
	    dataSource.setDriverClassName(env.getProperty("database.driver"));
	    dataSource.setUrl(env.getProperty("database.url"));
	    dataSource.setUsername(env.getProperty("database.root"));
	    dataSource.setPassword(env.getProperty("database.password"));
	    return dataSource;
	}
	
	/** Criação do HibernateTransactionManager usando sessionFactory 
	 *  @return HibernateTransactionManager   
	 */
	@Bean
	public HibernateTransactionManager hibTransMan(){
		return new HibernateTransactionManager(sessionFactory());
	}
	
	/** Criação das propriedades do hibernate
	 *  @return properties   
	 */
    private Properties hibernateProperties() {
         Properties properties = new Properties();
         properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
         properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
         properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
           
         return properties;        
    }	
	
	
}
