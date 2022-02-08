package com.revature;

import java.util.Calendar;
import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.controller.AccountController;
import com.revature.controller.TransController;
import com.revature.controller.UserController;
import com.revature.models.Account;
import com.revature.models.Trans;
import com.revature.models.User;
import com.revature.repositories.AccountDAO;
import com.revature.repositories.TransDAO;
import com.revature.repositories.UserDAO;
import com.revature.utils.HibernateUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		UserDAO uDAO = new UserDAO();
		AccountDAO aDAO = new AccountDAO();
		TransDAO tDAO = new TransDAO();
		AccountController ac = new AccountController();
		UserController uc = new UserController();
		TransController tc = new TransController();
		try(Session ses = HibernateUtil.getSession()) {
			System.out.println("Connection Successful");
			//create user
			User u1 = new User("username","password","test@gmail.com","First","Last","123 ABC street","1234567890");
			User u2 = new User("testno2","password","testno2@yahoo.com","test","no2","homeless","0987654321");
			//create account linked to user
			Account a1 = new Account("checking",1000,u1);
			Account a2 = new Account("saving",10000,u1);
			Account a3 = new Account("checking",200,u2);
			Account a4 = new Account("saving",2000,u2);
			aDAO.insertAccount(a1);
			aDAO.insertAccount(a2);
			aDAO.insertAccount(a3);
			aDAO.insertAccount(a4);
			//create new user with only username password and email
			User u3 = new User("username2","password","useremail");
			uDAO.insertUser(u3);
			System.out.println(u3);
			//update users profile
			u3.setAddress("my new address");
			u3.setFirstname("fname");
			u3.setLastname("lname");
			uDAO.updateuserprofile(u3);
			//System.out.println(u3);
			//add new account on new user
			Account a5 = new Account("checking",0,u3);
			aDAO.insertAccount(a5);
			//trans between accounts
			Trans t1 = new Trans(500,java.sql.Date.valueOf("2022-07-24"),a1,a2);
			tDAO.insertTrans(t1);
			Trans t2 = new Trans(450,java.sql.Date.valueOf("2022-01-25"),a2,a1);
			tDAO.insertTrans(t2);
			Trans t3 = new Trans(100,java.sql.Date.valueOf("2022-01-26"),a2,a1);
			tDAO.insertTrans(t3);
			Trans t4 = new Trans(200,java.sql.Date.valueOf("2022-01-27"),a1,a2);
			tDAO.insertTrans(t4);
			Trans t5 = new Trans(200,java.sql.Date.valueOf("2022-01-31"),a3,a4);
			tDAO.insertTrans(t5);
			//get all account
//			List<Account> allAccount = aDAO.getAllAccount();
//			for(Account a : allAccount) {
//				System.out.println(a);
//			}
			//get all trans
//			List<Trans> allTrans = tDAO.getAllTrans();
//			for(Trans t : allTrans) {
//				System.out.println(t);
//			}
			//get income
			//System.out.println(tDAO.getincomebyaccountid(1));
			//get expense
			//System.out.println(tDAO.getexpensebyaccountid(1));
			User u4 = new User("username3","password","useremail3");
			uDAO.uniquechecker(u4.getUsername(), u4.getEmail());
			//if username or email is not unique return false
			//System.out.println(uDAO.uniquechecker(u4.getUsername(), u4.getEmail()));
			//login checker
			uDAO.loginchecker("username", "password");
			//System.out.println(uDAO.loginchecker("username", "password"));
			
			System.out.println("Month of the year is  : "+t1.getTransdate().getMonth());
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(t1.getTransdate());
			int month = cal.get(Calendar.MONTH);
			System.out.println("Month of the year is  : "+month);
		} catch (HibernateException e) {
			System.out.println("Connection Failed!");
			e.printStackTrace();
		}
		
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins(); // allows the server to process JS requests from anywhere
				}
			).start(3001);
		
		app.get("/allaccount", ac.getallaccount);
		app.get("/income/{account_id}", tc.getaccountincome);
		app.get("/expense/{account_id}", tc.getaccountexpense);
		app.post("/registeruser", uc.insertNewUser);
		app.get("/allaccount/{user_id}", ac.getallaccountbyuserid);
		app.post("/registeraccount", ac.insertNewAccount);
		app.post("/trans", tc.inserttrans);
		app.get("/budget/{account_id}/{month}", tc.getmonthlybudget);
		app.get("/getuser/{user_id}", uc.getUserbyid);
		app.post("/login", uc.loginHandler);
		app.post("/updateprofile/{user_id}", uc.updateprofile);	
		app.get("/account/{account_id}", ac.getaccountbyaccountid);
		
		
	}

}
