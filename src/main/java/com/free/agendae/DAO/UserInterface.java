package com.free.agendae.DAO;

import com.free.agendae.domain.classes.User;

public interface UserInterface {
	
	void saveOrUpdate(User user); 
	void delete(User user);
	UserInterface findById(Long id); 

}
