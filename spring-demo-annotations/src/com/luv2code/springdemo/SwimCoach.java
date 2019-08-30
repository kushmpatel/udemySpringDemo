package com.luv2code.springdemo;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	public SwimCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Swim for 1000 mtr";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
