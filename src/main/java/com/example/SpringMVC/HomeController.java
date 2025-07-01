package com.example.SpringMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringMVC.dao.UserDao;
import com.example.SpringMVC.model.User_data;


@Controller
public class HomeController {
	
	@Autowired
	private UserDao userdao;

//	1. working with login page
	@RequestMapping("/")
	public String getLogin(){
		return "Login";
	}


//	one method than when it called by another method it will not render the same name
	@ModelAttribute
	public void addName(Model m) {
		m.addAttribute("name", "Queen");
	}

//	6 code will work without passing @ModelAttribute . we can call it by "user" attribute in jsp
	@RequestMapping("/addUser")
	public String addUser(User_data u) {
		return "LoginResult";
	}

	@RequestMapping("/getusers")
	public String getAlien(Model m) {
		m.addAttribute("users", userdao.getAll());
		return "result";
	}

}
