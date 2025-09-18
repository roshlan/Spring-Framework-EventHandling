package ioc;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ioc.CustomEventPublisher;
public class MainApp {
public static void main(String[] args)
{
	ConfigurableApplicationContext context=new ClassPathXmlApplicationContext("App001.xml");
	CustomEventPublisher cvp=(CustomEventPublisher)context.getBean("customEventPublisher");
	cvp.publish();
	cvp.publish();
}
	
}
