package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	
private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		// TODO Auto-generated constructor stub
		this.fortuneService = fortuneService;
	}
	

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//add an init method
	public void doMyStartupStuff() {
		System.out.println("Do My Startup Stuff");
	}

	//add a destroy method
	public void doMyCleanupStuff() {
		System.out.println("Do My Clean Up Stuff");
	}
}
