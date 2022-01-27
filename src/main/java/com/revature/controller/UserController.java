package com.revature.controller;

import com.google.gson.Gson;
import com.revature.models.User;
import com.revature.repositories.UserDAO;

import io.javalin.http.Handler;

public class UserController {
	UserDAO udao = new UserDAO();
	
	public Handler insertNewUser = (ctx) -> {
		
		if(ctx.req.getSession() != null) {
			
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			User user = gson.fromJson(body, User.class);
			
			udao.insertNewUser(user);
			
			ctx.result("User successfully registered");
			ctx.status(201);
			
		}else {
			ctx.result("An error occured while attempting to register this user");
			ctx.status(404);
			
		}
	};
}
