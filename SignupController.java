package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.UsersRegisterSignup;
import com.example.demo.model.UsersSignin;
import com.example.demo.services.SignupService;

@Controller
@ResponseBody
public class SignupController {
	
	@Autowired
	SignupService service;
	
	
	@PostMapping("/addusers1")
	public  String addusers(@RequestBody UsersRegisterSignup obj) {
		
		service.addusers(obj);
		return "User successfully added";
	
	}
	
	@RequestMapping("/displayusers1")
	public ArrayList<UsersRegisterSignup> displayusers() {
		return service.displayusers();
		
	}
	
	/*@GetMapping("/usersdisplay")
	
	public ModelAndView myMethod() {
		
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("usersdisplay");
		modelandview.addObject("test",service.getMessage());
			
		return modelandview;
	
	}*/
	
@GetMapping("/signinform")
	
	public ModelAndView myMethod1() {
		
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("Signin");
		
		return modelandview;
	
}

@PostMapping("/signinformsubmit")
public ModelAndView myMethod1(UsersSignin obj) {
	ModelAndView modelAndView = new ModelAndView();
	//modelAndView.setViewName("Signin");
	
	if(obj.getUserid().matches("admin")&&obj.getPassword().matches("admin1234")) {
		modelAndView.setViewName("AdminWelcome");
		modelAndView.addObject("msg2","");
	}
	else {
	boolean flag=service.postValidateUsers(obj);
	System.out.println(flag);
	modelAndView.addObject("test1", flag);
	//modelAndView.addObject("test1",flag);
	
	if(flag) {
		modelAndView.setViewName("Welcome");
		modelAndView.addObject("msg","Valid user");
	}
	else {
	modelAndView.setViewName("Signin");
	modelAndView.addObject("test1","You are invalid user");
	}}
	return modelAndView;
	
	
}
	
	
	/*@GetMapping("/login")
	public ModelAndView login(@RequestParam("userid") String userid,@RequestParam("password") String password){
		System.out.println("userid ="+userid);
		System.out.println("password ="+password);
		ModelAndView modelandview = new ModelAndView();
		modelandview.setViewName("Signin");
		boolean flag=service.validate(userid, password);
		System.out.println(flag);
		modelandview.addObject("test1",flag);
		if(flag) {
			modelandview.setViewName("Welcome");
			modelandview.addObject("msg",userid);
		}
		else {
		modelandview.setViewName("Signin");
		modelandview.addObject("test1","You are invalid user");
		}
		return modelandview;
		
	}*/
	
@RequestMapping("/signupform")
public ModelAndView displaySignup() {
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("Signup");
	return modelAndView;
	
}

@PostMapping("/submitsignupform")
public ModelAndView myMethod(UsersRegisterSignup obj) {
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("Signin");
	return modelAndView.addObject("result",service.postRegisteredUsers(obj));
	
}

@RequestMapping("/homepage")
public ModelAndView home() {
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("HomePage");
	return modelAndView;
	
}

@RequestMapping("/form3")
public ModelAndView adminwelcome() {
	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("AdminWelcome");
	return modelAndView;
	
}
	

}




	
	

	
	

