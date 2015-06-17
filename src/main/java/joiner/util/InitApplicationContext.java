package joiner.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitApplicationContext {

    private static ApplicationContext context = null;

    private InitApplicationContext(){

    }
    public static ApplicationContext getApplicationContext(){
        if(context == null){
            System.out.println("Context initiating");
            context = new ClassPathXmlApplicationContext("applicationContext.xml");
            System.out.println("Context initiated");
        }
        return context;
    }
}