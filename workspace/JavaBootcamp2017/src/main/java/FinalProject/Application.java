package FinalProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		/*AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(Application.class);
		ctx.refresh();*/
		System.getProperties().put( "server.port", 8181 );  //8181 port is set here
        SpringApplication.run(Application.class, args);
        
        
    }
}
