package com.luv2code.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	@Value("${coach.name}")
	String coachName;
	
	@Value("${team.name}")
	String teamName;

	@GetMapping("/")
	public String sayHello() {
		System.out.println(coachName);
		System.out.println(teamName);
		return "Hello World ! Time on server is "+LocalDateTime.now();
	}
	
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "Coach Name == "+coachName+" Team Name == "+teamName;
	}
}
