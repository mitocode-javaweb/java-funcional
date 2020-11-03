package com.mitocode.javaweb.java_funcional._05_supplier;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

public class Programa05 {

	public static void main(String[] args) {
//		supplierIntro();

		supplier2();
	}

	public static void supplier2() {
		Supplier<Persona> sPersona = Persona::new; // () -> new Persona()
		Persona p1 = getPersona(sPersona);
		p1.imprimirDatos();

		Persona p2 = getPersona(() -> new Persona("Pablo", LocalDate.of(1995, 5, 20)));
		p2.imprimirDatos();
	}

	private static Persona getPersona(Supplier<Persona> sPersona) {
		Persona persona = sPersona.get();
		if (persona.getFechaNacimiento() == null) {
			persona.setNombres("Anónimo");
			persona.setFechaNacimiento(LocalDate.of(2002, 1, 1));
		}
		return persona;
	}

	private static void supplierIntro() {
		Supplier<LocalDateTime> supplierHora = () -> LocalDateTime.now();
		LocalDateTime hora = supplierHora.get();
		System.out.println(hora);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/yyyy hh:mm:ss a");
		Supplier<String> supplierFormatoHora = () -> dtf.format(LocalDateTime.now());
		System.out.println(supplierFormatoHora.get());
	}
}
