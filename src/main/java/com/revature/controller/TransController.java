package com.revature.controller;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Trans;
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
}
