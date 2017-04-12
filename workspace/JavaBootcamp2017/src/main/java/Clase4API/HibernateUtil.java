package Clase4API;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Clase4API.Model.Category;
import Clase4API.Model.Item;
import Clase4API.Model.ItemBag;
import Clase4API.Model.ShoppingCart;
import Clase4API.Model.User;

public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				
				registry = new StandardServiceRegistryBuilder().configure("shoppingcarthibernate.cfg.xml").build();
				/*StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

				Map<String, String> settings = new HashMap<>();
				settings.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
				settings.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/shopping_cart");
				settings.put("hibernate.connection.username", "root");
				settings.put("hibernate.connection.password","");
				settings.put("hibernate.show_sql", "true");
				settings.put("hibernate.hbm2ddl.auto", "update");

				registryBuilder.applySettings(settings);

				registry = registryBuilder.build();*/

				MetadataSources sources = new MetadataSources(registry).addAnnotatedClass(Item.class).addAnnotatedClass(ItemBag.class)
						.addAnnotatedClass(ShoppingCart.class).addAnnotatedClass(User.class).addAnnotatedClass(Category.class);

				Metadata metadata = sources.getMetadataBuilder().build();

				sessionFactory = metadata.getSessionFactoryBuilder().build();
			} catch (Exception e) {
				System.out.println("SessionFactory creation failed");
				e.printStackTrace();
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
		return sessionFactory;
	}

	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}
