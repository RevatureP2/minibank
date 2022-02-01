package com.revature.controller;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Trans;
import com.revature.models.User;
import com.revature.repositories.TransDAO;

import io.javalin.http.Handler;

public class TransController {
	TransDAO tDAO = new TransDAO();
	public Handler getaccountincome = (ctx) -> {
		if(ctx.req.getSession() != null) {
			int id = 0;
			id = Integer.parseInt(ctx.pathParam("account_id"));
			List<Trans> incomelist = tDAO.getincomebyaccountid(id);
			Gson gson = new Gson();
			String JSONincome = gson.toJson(incomelist);
			
			ctx.result(JSONincome);
			ctx.status(200);
		}else {
			ctx.result("failed");
			ctx.status(404);
		}
		
	};
	public Handler getaccountexpense = (ctx) -> {
		if(ctx.req.getSession() != null) {
			int id = 0;
			id = Integer.parseInt(ctx.pathParam("account_id"));
			List<Trans> incomelist = tDAO.getexpensebyaccountid(id);
			Gson gson = new Gson();
			String JSONincome = gson.toJson(incomelist);
			
			ctx.result(JSONincome);
			ctx.status(200);
		}else {
			ctx.result("failed");
			ctx.status(404);
		}
		
	};
	public Handler inserttrans = (ctx) -> {
		if(ctx.req.getSession() != null) {
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			Trans tran = gson.fromJson(body, Trans.class);
			tDAO.insertTrans(tran);
			
			ctx.result("Trans successfully registered");
			ctx.status(201);
		}else {
			ctx.result("failed");
			ctx.status(404);
		}
		
	};
	public Handler getmonthlybudget = (ctx) -> {
		if(ctx.req.getSession() != null) {
			int id = 0;
			id = Integer.parseInt(ctx.pathParam("account_id"));
			int month = 0;
			month = Integer.parseInt(ctx.pathParam("month"));
			List<Trans> budget = tDAO.getbudgetbymonth(month,id);
			Gson gson = new Gson();
			String JSONbudget = gson.toJson(budget);
			
			ctx.result(JSONbudget);
			ctx.status(200);
		}else {
			ctx.result("failed");
			ctx.status(404);
		}
		
	};
}
