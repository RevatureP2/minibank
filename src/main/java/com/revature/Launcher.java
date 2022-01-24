package com.revature;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.Account;
import com.revature.models.Trans;
import com.revature.models.User;
import com.revature.repositories.AccountDAO;
import com.revature.repositories.TransDAO;
import com.revature.repositories.UserDAO;
import com.revature.utils.HibernateUtil;

public class Launcher {

	public static void main(String[] args) {
		UserDAO uDAO = new UserDAO();
		AccountDAO aDAO = new AccountDAO();
		TransDAO tDAO = new TransDAO();
		// TODO Auto-generated method stub
		try(Session ses = HibernateUtil.getSession()) {
			System.out.println("Connection Successful");
			User u1 = new User("username","password","test@gmail.com","First","Last","123 ABC street");
			User u2 = new User("testno2","password","testno2@yahoo.com","test","no2","homeless");
			Account a1 = new Account(1,"checking",1000,u1);
			Account a2 = new Account(2,"saving",10000,u1);
			Account a3 = new Account(3,"checking",200,u2);
			Account a4 = new Account(4,"saving",2000,u2);
			aDAO.insertAccount(a1);
			aDAO.insertAccount(a2);
			aDAO.insertAccount(a3);
			aDAO.insertAccount(a4);
			List<Account> allAccount = aDAO.getAllAccount();
			Trans t1 = new Trans(-200,null,a2);
			tDAO.insertTrans(t1);
			for(Account a : allAccount) {
				System.out.println(a);
			}
		} catch (HibernateException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
		}
	}

}
