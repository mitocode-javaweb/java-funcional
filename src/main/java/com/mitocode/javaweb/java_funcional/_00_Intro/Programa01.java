package com.mitocode.javaweb.java_funcional._00_Intro;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Programa01 {

	public static void main(String[] args) {
		List<Persona> personas = Arrays.asList(
				new Persona("Pablo", LocalDate.of(2000, 4, 15), 2000),
				new Persona("Cristian", LocalDate.of(2005, 12, 4), 3000),
				new Persona("Emilio", LocalDate.of(1995, 8, 22), 1800),
				new Persona("Juan Pablo", LocalDate.of(1990, 3, 29), 2200),
				new Persona("Karla", LocalDate.of(1997, 2, 2), 2700));
		imprimirLista(personas);

		personas.sort(new Comparator<Persona>() {
			@Override
			public int compare(Persona o1, Persona o2) {
				return o1.getNombres().compareTo(o2.getNombres());
			}
		});
		imprimirLista(personas);
		
		personas.sort(  (persona1, persona2) ->  persona1.getEdad().compareTo(persona2.getEdad()) );
		imprimirLista(personas);
	}

	private static void imprimirLista(List<Persona> personas) {
		System.out.println(" ******** ");
		for (Persona persona : personas) {
			System.out.println(persona);
		}
	}

}
