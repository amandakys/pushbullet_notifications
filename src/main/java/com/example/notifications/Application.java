package com.example.notifications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

	public static List<User> users = new ArrayList<>() ;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public static User findUser(String username) {
		User target = null;
		for (User user: Application.users) {
			if (user.getUsername().equals(username)) {
				target = user;
				break;
			}
		}
		return target;
	}
}
