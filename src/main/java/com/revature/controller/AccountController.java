package com.revature.controller;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Account;
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
	
}
