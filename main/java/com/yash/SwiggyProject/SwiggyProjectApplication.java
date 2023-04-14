package com.yash.SwiggyProject;

import com.yash.SwiggyProject.module.Logic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwiggyProjectApplication {

	public static void main(String[] args) throws Exception {

		Logic object = new Logic();
		object.playGame();

	}

}
