package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
				Coach coach = context.getBean("swimCoach", Coach.class);
		System.out.println(coach.getDailyWorkout());
		//FortuneService fortuneService = context.getBean("happyFortuneService", FortuneService.class);
		System.out.println(coach.getDailyFortune());
		
		context.close();
	}
}
