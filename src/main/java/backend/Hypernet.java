package backend;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import Model.Form;

public class Hypernet {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getsessionfactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "org.h2.Driver");
				settings.put(Environment.URL, "jdbc:h2:./data/MavenDemoMaster;MODE=MySQL");
				settings.put(Environment.USER, "mv");
				settings.put(Environment.PASS, "mvn");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "update");
				configuration.setProperties(settings);
				//configuration.addPackage("co.mm.demo.MavenAppDemo.entities");
				
				configuration.addAnnotatedClass(Form.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);

				
			}catch (Exception e) {
				e.getCause();
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

}
