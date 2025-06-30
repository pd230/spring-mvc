package com.example.SpringMVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringMVC.model.User;


@Controller
public class HomeController {

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
	public String addUser(User u) {
		return "LoginResult";
	}

	@RequestMapping("/add")
	public String addNum(@RequestParam("no1") int i, @RequestParam("no2") int j, Model m) {
		int k = i + j;
		m.addAttribute("no3", k);
		return "LoginResult";
	}

}
