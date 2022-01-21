package com.revature;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.utils.HibernateUtil;

public class Launcher {

	public static void main(String[] args) {
		UserDAO uDAO = new UserDAO();
		// TODO Auto-generated method stub
		try(Session ses = HibernateUtil.getSession()) {
			System.out.println("Connection Successful");
			User u1 = new User("username","password","test@gmail.com","First","Last","123 ABC street");
			User u2 = new User("testno2","password","testno2@yahoo.com","test","no2","homeless");
			uDAO.insertUser(u1);
			uDAO.insertUser(u2);
		} catch (HibernateException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
		}
	}

}
