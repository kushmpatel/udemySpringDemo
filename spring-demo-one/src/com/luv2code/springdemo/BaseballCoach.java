package com.luv2code.springdemo;

public class BaseballCoach implements Coach{
	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService fortuneService) {
		// TODO Auto-generated constructor stub
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 min working";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}

