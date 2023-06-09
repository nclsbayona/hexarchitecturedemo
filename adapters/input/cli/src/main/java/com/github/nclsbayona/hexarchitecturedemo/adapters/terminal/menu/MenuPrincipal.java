package com.github.nclsbayona.hexarchitecturedemo.adapters.terminal.menu;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.github.nclsbayona.hexarchitecturedemo.adapters.terminal.adapter.PersonCLIAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MenuPrincipal {
	
	//Beans
	private static final int SALIR = 0;
	private static final int MENU_WELCOME = 1;
	@Autowired
	private PersonCLIAdapter personCLIAdapter;

	//Menus
	private final Scanner keyboard;
	private final WelcomeMenu welcomeMenu;

    public MenuPrincipal() {
        this.keyboard = new Scanner(System.in);
		this.welcomeMenu = new WelcomeMenu();
    }

	public void inicio() {

		boolean isValid = false;
		do {
			mostrarMenu();
			int opcion = leerOpcion();
			switch (opcion) {
			case SALIR:
				isValid = true;
				log.debug("Usuario eligió abandonar la aplicación");
				break;
			case MENU_WELCOME:
				log.debug("Usuario eligió menu welcome");
				welcomeMenu.iniciarMenu(personCLIAdapter, keyboard);
				break;
			default:
				log.warn("La opción elegida no es válida.");
			}

		} while (!isValid);
		keyboard.close();
	}

	private void mostrarMenu() {
		System.out.flush();

		System.out.println("----------------------");
		System.out.println(MENU_WELCOME + " para trabajar con el menu Welcome");
		System.out.println("");
		System.out.println(SALIR + " para Salir");
		System.out.println("----------------------");
	}

	private int leerOpcion() {
		try {
			System.out.print("Ingrese una opción: ");
			return keyboard.nextInt();
		} catch (Exception e) {
			log.warn("Solo se permiten números.");
			return leerOpcion();
		}
	}

}
