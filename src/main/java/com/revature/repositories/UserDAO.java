package com.revature.repositories;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Account;
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
			HibernateUtil.closeSession();
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
		if(q.getResultList().isEmpty()) {
			HibernateUtil.closeSession();
			return null;
		}
		User user = (User) q.getSingleResult();
		HibernateUtil.closeSession();
		return user;
	}
	
	public void insertNewUser(User newUser) throws SQLException {
	
	Session ses = HibernateUtil.getSession();
	ses.save(newUser);
	HibernateUtil.closeSession();
			
			
		}
	public User getUserbyuserid(int id){
		
		Session ses = HibernateUtil.getSession();
		
		//remember, HQL references the Java Class, so we look for Director (Java Class) as opposed to directors (SQL Entity)
		
		Query q = ses.createQuery("FROM User WHERE user_id = ?0");
		q.setParameter(0, id);
		User user = (User)q.getSingleResult();
		//User userlist = q.getResultList();
		HibernateUtil.closeSession();
		
		return user;
		
	}
	public String resetpassword(String email){
		
		Session ses = HibernateUtil.getSession();
		
		//remember, HQL references the Java Class, so we look for Director (Java Class) as opposed to directors (SQL Entity)
		
		Query q = ses.createQuery("FROM User WHERE email = ?0");
		q.setParameter(0, email);
		if(q.getResultList().isEmpty()) {
			HibernateUtil.closeSession();
			return null;
		}
		User user = (User) q.getSingleResult();
		user.setPassword("password");
		String newpassword="password";
		ses.save(user);
		HibernateUtil.closeSession();
		return newpassword;
		//User userlist = q.getResultList();
		
		
	}
	
	
	}
	
	

