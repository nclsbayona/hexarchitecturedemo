package com.github.nclsbayona.hexarchitecturedemo.adapters.terminal.menu;

import java.util.Scanner;

import com.github.nclsbayona.hexarchitecturedemo.adapters.terminal.adapter.PersonCLIAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WelcomeMenu {
    private static final int OPCION_REGRESAR_MODULOS = 0;

    private static final int OPCION_OUTPUT_GRPC = 1;
	private static final int OPCION_OUTPUT_TEST = 2;

    private static final int OPCION_REGRESAR_SALIDA = 0;
	private static final int OPCION_VER_POR_ID = 1;

    public void iniciarMenu(PersonCLIAdapter personCLIAdapter, Scanner keyboard) {
		boolean isValid = false;
		do {
			try {
				mostrarMenuMotorPersistencia();
				int opcion = leerOpcion(keyboard);
				switch (opcion) {
					case OPCION_REGRESAR_MODULOS:
						isValid = true;
						break;
					case OPCION_OUTPUT_GRPC:
						personCLIAdapter.setOutput("GRPC");
						menuOpciones(personCLIAdapter, keyboard);
						break;
					case OPCION_OUTPUT_TEST:
						personCLIAdapter.setOutput("TEST");
						menuOpciones(personCLIAdapter, keyboard);
						break;
					default:
						log.warn("La opción elegida no es válida.");
				}
			} catch (Exception e) {
				log.warn(e.getMessage());
			}
		} while (!isValid);
	}

	private void menuOpciones(PersonCLIAdapter personCLIAdapter, Scanner keyboard) {
		boolean isValid = false;
		do {
			try {
				mostrarMenuOpciones();
				int opcion = leerOpcion(keyboard);
				switch (opcion) {
					case OPCION_REGRESAR_SALIDA:
						isValid = true;
						break;
					case OPCION_VER_POR_ID:
                        System.out.print("Ingrese el valor: ");
                        String id = keyboard.next();
						personCLIAdapter.printPerson(Integer.valueOf(id));
						break;
					default:
						log.warn("La opción elegida no es válida.");
				}
			} catch (Exception e) {
				log.warn("Solo se permiten números.");
			}
		} while (!isValid);
	}

	private void mostrarMenuOpciones() {
		System.out.println("----------------------");
		System.out.println(OPCION_VER_POR_ID + " para ver una persona por su ID");
		System.out.println(OPCION_REGRESAR_SALIDA + " para regresar");
	}

	private void mostrarMenuMotorPersistencia() {
		System.out.println("----------------------");
		System.out.println(OPCION_OUTPUT_GRPC + " para gRPC");
		System.out.println(OPCION_OUTPUT_TEST + " para TEST");
		System.out.println(OPCION_REGRESAR_MODULOS + " para regresar");
	}

	private int leerOpcion(Scanner keyboard) {
		try {
			System.out.print("Ingrese una opción: ");
			return keyboard.nextInt();
		} catch (Exception e) {
			log.warn("Solo se permiten números.");
			return leerOpcion(keyboard);
		}
	}
}
