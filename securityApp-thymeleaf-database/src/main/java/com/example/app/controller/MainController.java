package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String homePage() {
		return "main/index" ;
	}
	@GetMapping("/admin")
	public String adminPage() {
		return "admin/admin" ;
	}
	@GetMapping("/dpa")
	public String dpaPage() {
		return "DBA/dba" ;
	}
	@GetMapping("/user")
	public String user() {
		return "user/user" ;
	}
	@GetMapping("/myLogin")
	public String loginPage() {
		return "login" ;
	}
}
