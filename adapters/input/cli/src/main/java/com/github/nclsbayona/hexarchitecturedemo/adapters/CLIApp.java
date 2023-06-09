package com.github.nclsbayona.hexarchitecturedemo.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.github.nclsbayona.hexarchitecturedemo.adapters.terminal.menu.MenuPrincipal;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class CLIApp implements CommandLineRunner {
	
	@Autowired
	private MenuPrincipal menuPrincipal;

	public static void main(String[] args) {
		log.info("Starting CLIApp ...");
		SpringApplication.run(CLIApp.class, args);
		log.info("Started CLIApp OK");
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("EXECUTING : command line runner");
		menuPrincipal.inicio();
		log.info("FINISHED : command line runner");
	}

}
