package com.mitocode.javaweb.java_funcional._03_functional_interfaces;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.mitocode.javaweb.java_funcional._03_functional_interfaces.Persona.Genero;

public class Programa03_Intro {

	public static void main(String[] args) {
		List<Persona> personas = Arrays.asList(
				new Persona("Pablo", LocalDate.of(2000, 4, 15), Genero.MASCULINO),
				new Persona("Cristian", LocalDate.of(2005, 12, 4), Genero.MASCULINO),
				new Persona("Emilio", LocalDate.of(1995, 8, 22), Genero.MASCULINO),
				new Persona("Juan Pablo", LocalDate.of(1990, 3, 29), Genero.MASCULINO),
				new Persona("Karla", LocalDate.of(1997, 2, 2), Genero.FEMENINO));
		imprimirLista(personas);
		
//		personasMayoresA(personas, 20);
//		personasEnUnRangoDeEdad(personas, 20, 27);
		
		imprimirLista(personas, p -> p.getEdad() >= 20 );
		imprimirLista(personas, p -> p.getEdad() > 20 && p.getEdad() < 27 );
		imprimirListaConPredicate(personas, p -> p.getEdad() >= 18 && p.getGenero() == Genero.FEMENINO );
	}
	
	private static void imprimirLista(List<Persona> personas) {
		System.out.println(" ******** ");
		for (Persona persona : personas) {
			persona.imprimirDatos();
		}
	}
	
	private static void personasMayoresA(List<Persona> personas, int edad) {
		System.out.println(" ******** ");
		for (Persona persona : personas) {
			if(persona.getEdad() > edad) {
				persona.imprimirDatos();
			}
		}
	}
	
	private static void personasEnUnRangoDeEdad(List<Persona> personas, int edadInicial, int edadFinal) {
		System.out.println(" ******** ");
		for (Persona persona : personas) {
			if(persona.getEdad() > edadInicial && persona.getEdad() < edadFinal) {
				persona.imprimirDatos();
			}
		}
	}
	
	private static void imprimirLista(List<Persona> personas, EvaluarPersona evaluar) {
		System.out.println(" ******** ");
		for (Persona persona : personas) {
			if(evaluar.test(persona)) {
				persona.imprimirDatos();
			}
		}
	}
	
	private static void imprimirListaConPredicate(List<Persona> personas, Predicate<Persona> predicate) {
		System.out.println(" ******** ");
		for (Persona persona : personas) {
			if(predicate.test(persona)) {
				persona.imprimirDatos();
			}
		}
	}
	
}
