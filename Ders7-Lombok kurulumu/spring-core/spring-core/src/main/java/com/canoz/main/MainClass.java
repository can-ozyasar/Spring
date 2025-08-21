package com.canoz.main;

import java.util.Iterator;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.canoz.config.AppConfig;
import com.canoz.model.User;
import com.canoz.service.UserService;

public class MainClass {

	public static void main(String[] args) {
		
		
		
	 ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
	 UserService userService= context.getBean(UserService.class);
	 // config olarak işaretlenmiş classımızı ekliyoruz 
		// içindeki beanları 
		
	 
	 for (User user = userService.getUserList()) {
		 System.out.println(user);
		
	}

	}

}
