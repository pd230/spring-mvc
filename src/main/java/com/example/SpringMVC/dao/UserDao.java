package com.example.SpringMVC.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.SpringMVC.model.User_data;

import jakarta.transaction.Transactional;



@Component
public class UserDao {
   
	@Autowired
	SessionFactory sessionfactory;
	
	@Transactional
	public List<User_data> getAll(){
		Session session = sessionfactory.getCurrentSession();
		List<User_data> users = session.createQuery("from User_data", User_data.class).list();
		return users;
	}
	
}
