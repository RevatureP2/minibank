package com.revature.repositories;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Trans;
import com.revature.models.User;
//import com.revature.util.ConnectionFactory;
import com.revature.utils.HibernateUtil;
public class UserDAO {
	public void insertUser(User user) {
		Session ses = HibernateUtil.getSession();
		ses.save(user);
		HibernateUtil.closeSession();
	}
	public void updateuserprofile(User u) {
	Session ses = HibernateUtil.getSession();
	
	Transaction tran = ses.beginTransaction();
	ses.merge(u);
	tran.commit();
	HibernateUtil.closeSession();
	} 
	public boolean uniquechecker(String username, String email) {
		Session ses = HibernateUtil.getSession();
		Query q = ses.createQuery("FROM User WHERE username = :u OR email = :e");
		q.setParameter("u", username);
		q.setParameter("e", email);
		List<User> uniqueList = q.getResultList();
		boolean ans = uniqueList.isEmpty();
		if(ans == true) {
			return true;
		}
		HibernateUtil.closeSession();
		return false;
	}
	public User loginchecker(String username, String password) {
		Session ses = HibernateUtil.getSession();
		Query q = ses.createQuery("FROM User WHERE username = :u AND password = :e");
		q.setParameter("u", username);
		q.setParameter("e", password);
		User user = (User) q.getSingleResult();
		HibernateUtil.closeSession();
		return user;
	}
	
public void insertNewUser(User newUser) throws SQLException {
	
	Session ses = HibernateUtil.getSession();
	ses.save(newUser);
	HibernateUtil.closeSession();
			
			
		}
	}
	
	

