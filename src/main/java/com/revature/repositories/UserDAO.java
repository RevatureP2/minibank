package com.revature.repositories;


import org.hibernate.Session;

import com.revature.models.User;
import com.revature.utils.HibernateUtil;
public class UserDAO {
	public void insertUser(User user) {
		Session ses = HibernateUtil.getSession();
		ses.save(user);
		HibernateUtil.closeSession();
	}
}
