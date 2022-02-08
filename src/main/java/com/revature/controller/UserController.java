package com.revature.controller;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Account;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.repositories.UserDAO;

import io.javalin.http.Handler;

public class UserController {
	UserDAO udao = new UserDAO();
	
	public Handler insertNewUser = (ctx) -> {
		
		if(ctx.req.getSession() != null) {
			
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			
			gson.fromJson(body, User.class).getUsername();
			gson.fromJson(body, User.class).getEmail();
			User user = gson.fromJson(body, User.class);
			if(udao.uniquechecker(user.getUsername(), user.getEmail())) {
				udao.insertNewUser(user);
				ctx.result(gson.toJson(user));
				ctx.status(201);
			}
			else {
				ctx.result("username or email is not unique");
				ctx.status(405);
			}
			
			
			
		}else {
			ctx.result("An error occured while attempting to register this user");
			ctx.status(404);
			
		}
	};
	public Handler getUserbyid = (ctx) -> {
		if(ctx.req.getSession() != null) {
			int id = 0;
			id = Integer.parseInt(ctx.pathParam("user_id"));
			User userresult = udao.getUserbyuserid(id);
			Gson gson = new Gson();
			String JSONuser = gson.toJson(userresult);
			
			ctx.result(JSONuser);
			ctx.status(200);
		}else {
			ctx.result("failed");
			ctx.status(404);
		}
		
	};
	public Handler loginHandler = (ctx) ->{
		String body = ctx.body();
		
		Gson gson = new Gson();
		LoginDTO LDTO = gson.fromJson(body,LoginDTO.class);
		User loginuser = udao.loginchecker(LDTO.getUsername(),LDTO.getPassword());
		if(loginuser != null) {
			ctx.req.getSession();
			ctx.res.setHeader("Set-Cookie", "key=value; HttpOnly; SameSite=None; Secure");
			ctx.status(202);
			ctx.result(gson.toJson(loginuser));
		}
		else {
			ctx.status(401);
			ctx.result("login failed");
		}
		
	};
	public Handler updateprofile = (ctx) ->{
		if(ctx.req.getSession() != null) {
			int id = 0;
			id = Integer.parseInt(ctx.pathParam("user_id"));
			String body = ctx.body();
			
			Gson gson = new Gson();
			User user = udao.getUserbyuserid(id);
			
			user.setAddress(gson.fromJson(body, User.class).getAddress());
			user.setEmail(gson.fromJson(body, User.class).getEmail());
			user.setFirstname(gson.fromJson(body, User.class).getFirstname());
			user.setLastname(gson.fromJson(body, User.class).getLastname());
			user.setPhonenumber(gson.fromJson(body, User.class).getPhonenumber());
			System.out.println(user);
			udao.updateuserprofile(user);
			
			ctx.result(gson.toJson(user));
			ctx.status(201);
			
		}else {
			ctx.result("An error occured while attempting to update this user's profile");
			ctx.status(404);
			
		}
		
	};
}
