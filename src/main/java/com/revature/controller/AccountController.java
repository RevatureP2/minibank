package com.revature.controller;

import java.util.List;
import java.util.Optional;

import com.google.gson.Gson;
import com.revature.models.Account;
import com.revature.models.User;
import com.revature.repositories.AccountDAO;

import io.javalin.http.Handler;

public class AccountController {
	AccountDAO aDAO = new AccountDAO();
	public Handler getallaccount = (ctx) -> {
		if(ctx.req.getSession() != null) {
			List<Account> accountresult = aDAO.getAllAccount();
			Gson gson = new Gson();
			String JSONaccount = gson.toJson(accountresult);
			
			ctx.result(JSONaccount);
			ctx.status(200);
		}else {
			ctx.result("failed");
			ctx.status(404);
		}
		
	};
	public Handler getallaccountbyuserid = (ctx) -> {
		if(ctx.req.getSession() != null) {
			int id = 0;
			id = Integer.parseInt(ctx.pathParam("user_id"));
			List<Account> accountresult = aDAO.getAllAccountbyuserid(id);
			Gson gson = new Gson();
			String JSONaccount = gson.toJson(accountresult);
			
			ctx.result(JSONaccount);
			ctx.status(200);
		}else {
			ctx.result("failed");
			ctx.status(404);
		}
		
	};
	public Handler getaccountbyaccountid = (ctx) -> {
		if(ctx.req.getSession() != null) {
			int id = 0;
			id = Integer.parseInt(ctx.pathParam("account_id"));
			Account accountresult = aDAO.getAccountbyaccountid(id);
			Gson gson = new Gson();
			String JSONaccount = gson.toJson(accountresult);
			
			ctx.result(JSONaccount);
			ctx.status(200);
		}else {
			ctx.result("failed");
			ctx.status(404);
		}
		
	};
	
	public Handler insertNewAccount = (ctx) -> {
		
		if(ctx.req.getSession() != null) {
			
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			Account account = gson.fromJson(body, Account.class);
			
			aDAO.insertAccount(account);
			
			ctx.result(gson.toJson(account));
			ctx.status(201);
			
		}else {
			ctx.result("An error occured while attempting to register this user");
			ctx.status(404);
			
		}
	};
}
