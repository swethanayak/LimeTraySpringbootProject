package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SignupDAO;
import com.example.demo.model.UsersRegisterSignup;
import com.example.demo.model.UsersSignin;



@Service
public class SignupService {

	@Autowired
	SignupDAO dao;
	public void addusers(UsersRegisterSignup obj) {
		// TODO Auto-generated method stub
		dao.addusers(obj);
	}
	public ArrayList<UsersRegisterSignup> displayusers() {
		// TODO Auto-generated method stub
		return dao.displayusers();
	}
	public Object getMessage() {
		// TODO Auto-generated method stub
		return "Good morning";
	}
	public boolean validate(String userid, String password) {
		// TODO Auto-generated method stub
		return dao.validate(userid,password);
	}
	public String postRegisteredUsers(UsersRegisterSignup obj) {
		// TODO Auto-generated method stub
		return dao.postRegisteredUsers(obj);
	}
	public boolean postValidateUsers(UsersSignin obj) {
		// TODO Auto-generated method stub
		return dao.postValidateUsers(obj);
	}
	
	}
	
	


