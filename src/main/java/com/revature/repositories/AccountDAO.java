package com.revature.repositories;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Account;
import com.revature.models.Trans;
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
//	public void updateaftertrans(Account a) {
//		Session ses = HibernateUtil.getSession();
//		
//		Transaction tran = ses.beginTransaction();
//		ses.merge(a);
//		tran.commit();
//		HibernateUtil.closeSession();
//	} 
	public List<Account> getAllAccountbyuserid(int id){
		
		Session ses = HibernateUtil.getSession();
		
		//remember, HQL references the Java Class, so we look for Director (Java Class) as opposed to directors (SQL Entity)
		
		Query q = ses.createQuery("FROM Account WHERE user_id_fk = ?0");
		q.setParameter(0, id);
		List<Account> accountList = q.getResultList();
		HibernateUtil.closeSession();
		
		return accountList;
		
	}
	public Account getAccountbyaccountid(int id){
		
		Session ses = HibernateUtil.getSession();
		
		//remember, HQL references the Java Class, so we look for Director (Java Class) as opposed to directors (SQL Entity)
		
		Query q = ses.createQuery("FROM Account WHERE account_id = ?0");
		q.setParameter(0, id);
		Account accountList = (Account) q.getSingleResult();
		HibernateUtil.closeSession();
		
		return accountList;
		
	}
}
