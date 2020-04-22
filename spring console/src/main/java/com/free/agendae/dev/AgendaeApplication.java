package com.free.agendae.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.free.agendae.DAO.UserDAO;
import com.free.agendae.domain.classes.User;

@SpringBootApplication
public class AgendaeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaeApplication.class, args);
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"conf/springconfiguration.xml");
		UserDAO userDAO = (UserDAO) applicationContext.getBean("userdao");
		
		
		User user = new User();
		user.setName("User Test");
		user.setCpf("123");
		user.setWhatsappNumber("111111111111");
		
		
		userDAO.saveOrUpdate(user);
		
//		findUserById(user, 1L);
//		deleteUser(user,1L);
	}

}
