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
			
			Trans t1 = new Trans(500,a1,a2);
			tDAO.insertTrans(t1);
			Trans t2 = new Trans(-450,a1,a2);
			tDAO.insertTrans(t2);
			Trans t3 = new Trans(-100,a1,a2);
			tDAO.insertTrans(t3);
			Trans t4 = new Trans(200,a1,a2);
			tDAO.insertTrans(t4);
//			t1.getSender().setBalance(t1.getSender().getBalance()-t1.getTrans_amount());
//			aDAO.updateaftertrans(t1.getSender());
//			t1.getReceiver().setBalance(t1.getReceiver().getBalance()+t1.getTrans_amount());
//			aDAO.updateaftertrans(t1.getReceiver());
			List<Account> allAccount = aDAO.getAllAccount();
			for(Account a : allAccount) {
				System.out.println(a);
			}
			List<Trans> allTrans = tDAO.getAllTrans();
			for(Trans t : allTrans) {
				System.out.println(t);
			}
			System.out.println(tDAO.getincomebyaccountid(1));
			System.out.println(tDAO.getexpensebyaccountid(1));
		} catch (HibernateException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
		}
	}

}
