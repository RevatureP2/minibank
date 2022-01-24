package com.revature.repositories;
import java.util.List;

import org.hibernate.Session;

import com.revature.models.Account;

import com.revature.utils.HibernateUtil;
public class AccountDAO {
	public List<Account> getAllAccount(){
		
		Session ses = HibernateUtil.getSession();
		
		//remember, HQL references the Java Class, so we look for Director (Java Class) as opposed to directors (SQL Entity)
		List<Account> accountList = ses.createQuery("FROM Account").list();
		
		HibernateUtil.closeSession();
		
		return accountList;
		
	}
	public void insertAccount(Account acc) {
		Session ses = HibernateUtil.getSession();
		ses.save(acc);
		HibernateUtil.closeSession();
	}
}
