package com.revature.repositories;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Account;
import com.revature.models.Trans;
import com.revature.utils.HibernateUtil;

public class TransDAO {
	public void insertTrans(Trans trans) {
	
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		ses.save(trans);
		
		trans.getSender().setBalance(trans.getSender().getBalance()-trans.getTrans_amount());
		ses.merge(trans.getSender());
		trans.getReceiver().setBalance(trans.getReceiver().getBalance()+trans.getTrans_amount());
		ses.merge(trans.getReceiver());
		
		System.out.println(trans.getTransdate());
		//ses.flush();
		tran.commit();
		
		HibernateUtil.closeSession();
		
	}
	public List<Trans> getAllTrans(){
		
		Session ses = HibernateUtil.getSession();
		
		//remember, HQL references the Java Class, so we look for Director (Java Class) as opposed to directors (SQL Entity)
		List<Trans> translist = ses.createQuery("FROM Trans").list();
		
		HibernateUtil.closeSession();
		
		return translist;
		
	}
	public List<Trans> getincomebyaccountid(int id){
		
		Session ses = HibernateUtil.getSession();
		
		//remember, HQL references the Java Class, so we look for Director (Java Class) as opposed to directors (SQL Entity)
		Query q = ses.createQuery("FROM Trans WHERE receiver_id_fk = ?0");
		q.setParameter(0, id);
		List<Trans> incomeList = q.getResultList();
		HibernateUtil.closeSession();
		
		return incomeList;
		
	}
	public List<Trans> getexpensebyaccountid(int id){
		
		Session ses = HibernateUtil.getSession();
		
		//remember, HQL references the Java Class, so we look for Director (Java Class) as opposed to directors (SQL Entity)
		Query q = ses.createQuery("FROM Trans WHERE sender_id_fk = ?0");
		q.setParameter(0, id);
		List<Trans> incomeList = q.getResultList();
		HibernateUtil.closeSession();
		
		return incomeList;
		
	}
	public List<Trans> getbudgetbymonth(int month,int id){
		
		Session ses = HibernateUtil.getSession();
		
		//remember, HQL references the Java Class, so we look for Director (Java Class) as opposed to directors (SQL Entity)
		Query q = ses.createQuery("FROM Trans WHERE EXTRACT (MONTH FROM transdate)=:d AND sender_id_fk=:i OR receiver_id_fk=:r");
		q.setParameter("d", month);
		q.setParameter("i", id);
		q.setParameter("r", id);
		List<Trans> incomeList = q.getResultList();
		HibernateUtil.closeSession();
		
		return incomeList;
		
	}
}
