package ioc;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("App.xml");
		
		HelloWorld h = (HelloWorld) context.getBean("helloworld");
		h.getMessage();
		context.start();
		context.stop();

	}

}
