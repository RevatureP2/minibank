package com.revature.repositories;

import org.hibernate.Session;

import com.revature.models.Trans;
import com.revature.utils.HibernateUtil;

public class TransDAO {
	public void insertTrans(Trans trans) {
		Session ses = HibernateUtil.getSession();
		ses.save(trans);
		HibernateUtil.closeSession();
	}
}
