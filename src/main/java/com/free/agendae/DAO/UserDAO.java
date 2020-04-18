package com.free.agendae.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.free.agendae.domain.classes.User;

@Repository
public class UserDAO implements UserInterface{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Override
	public void saveOrUpdate(User user) {		
		hibernateTemplate.saveOrUpdate(user);
	}

	@Override
	public void delete(User user) {
		hibernateTemplate.delete(user);
		
	}

	@Override
	public UserInterface findById(Long id) {				
		return hibernateTemplate.get(UserInterface.class, id);
		
	}

}
