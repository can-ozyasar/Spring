package com.canoz.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.reactive.context.ConfigurableReactiveWebEnvironment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.canoz.model.User;
import com.canoz.service.UserService;

@Configuration

public class AppConfig {
	
	
	// eğer userservice ye kayıt etmek istiyorsak @bean kullanmalıyız
	@Bean // dönüş tipi dönülecek tipte olması gerekiyor
	public UserService userService() {
	 
	  
		UserService userService1=new UserService();
		List<User> userList =new ArrayList<>();
		
		userList.add(new User("Ahmet"));
		userList.add(new User("Ahmet"));

	
		userService1.setUserList(userList);
		
		return userService1;
		
		
		
 }
}
