package com.arifkhan.devjobs.DevJobs;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DevJobsApplication {

	public static void main(String[] args) {
		System.out.println("Working dir: " + System.getProperty("user.dir"));

		Dotenv dotenv = Dotenv.configure()
				.load();

		setPropertyIfPresent(dotenv, "DB_USERNAME");
		setPropertyIfPresent(dotenv, "DB_URL");
		setPropertyIfPresent(dotenv, "DB_PASSWORD");
		setPropertyIfPresent(dotenv, "SECRET_KEY");

		SpringApplication.run(DevJobsApplication.class, args);
	}
	private static void setPropertyIfPresent(Dotenv dotenv, String key) {
		String value = dotenv.get(key);
		if (value != null) {
			System.setProperty(key, value);
		} else {
			System.out.println("Missing env key: " + key);
		}
	}

}
