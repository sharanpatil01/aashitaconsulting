package com.aashita.consulting;

import java.time.Duration;
import java.time.Instant;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulting/health")
public class HealthCheck extends Thread {

	private static long callctr = 0;
	public static Instant appStartDt = Instant.now();

	public void run() {
		try {
			Thread.sleep(5000);

			System.out.println(callctr++ + ". RandomGen-App is up and running from : " + appDuration());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/ping")
	public String ping() {
		return "Consulting App is up and running from : " + appDuration();
	}

	public static String appDuration() {
		
		StringBuilder sb = new StringBuilder();
		int mm,ss,hh, days;
		
		Duration duration = Duration.between(appStartDt, Instant.now());
		String dur = duration.toMillis() / 1000 + " seconds.";
		
		if (duration.toMinutes() > 0) 
			sb.append( duration.toMinutes()).append(" minutes, ");
		
			sb.append((duration.toMillis()/1000)%60).append(" seconds.");
		
		
		System.out.println(callctr++ + ". RandomGen-App is up and running from : " + dur);

		return sb.toString();

	}
}
