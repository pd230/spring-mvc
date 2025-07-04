package com.example.SpringMVC.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.SpringMVC.model.User_data;

import jakarta.transaction.Transactional;



@Repository
@Transactional            // applies to every method
public class UserDao {
   
	@Autowired
	SessionFactory sessionfactory;
	
	@Transactional
	public List<User_data> getAll(){
		Session session = sessionfactory.getCurrentSession();
		List<User_data> users = session.createQuery("from User_data", User_data.class).list();
		return users;
	}
	
	@Transactional
	public User_data getOne(int id) {
		Session session = sessionfactory.getCurrentSession();
		User_data user = session.find(User_data.class, id);
		return user;
	}
	
//	@Transactional
//	public void save(User_data u) {
//		Session session = sessionfactory.getCurrentSession();
//		session.persist(u);
//	}
	
//	or
	
//	persist user into the database using namedQuery 
	
	@Transactional
	public void save(User_data user) {
		Session session = sessionfactory.getCurrentSession();
		MutationQuery q = session.createNamedMutationQuery("User_data.insert");
	    q.setParameter("uid",  user.getUid());
	    q.setParameter("uname", user.getUname());
	    q.executeUpdate();
	}
	
}
