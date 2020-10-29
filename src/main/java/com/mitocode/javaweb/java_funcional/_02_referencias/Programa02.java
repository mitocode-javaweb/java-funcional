package com.mitocode.javaweb.java_funcional._02_referencias;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Programa02 {

	public static void main(String[] args) {
		List<Persona> personas = Arrays.asList(
				new Persona("Pablo", LocalDate.of(2000, 4, 15), 2000),
				new Persona("Cristian", LocalDate.of(2005, 12, 4), 3000),
				new Persona("Emilio", LocalDate.of(1995, 8, 22), 1800),
				new Persona("Juan Pablo", LocalDate.of(1990, 3, 29), 2200),
				new Persona("Karla", LocalDate.of(1997, 2, 2), 2700));
		imprimirLista(personas);
		
		// referencia a metodo estatico
//		personas.sort(  (persona1, persona2) ->  persona1.getEdad().compareTo(persona2.getEdad()) );
		personas.sort(  (persona1, persona2) ->  PersonaUtil.compararEdad(persona1, persona2) );
		personas.sort( PersonaUtil::compararEdad );
		imprimirLista(personas);
		
		// referencia a metodo de instancia
		PersonaUtil comparador = new PersonaUtil();
//		personas.sort(  (persona1, persona2) ->  persona1.getNombres().compareTo(persona2.getNombres()) );
//		personas.sort(  (persona1, persona2) ->  comparador.compararNombres(persona1, persona2) );
		personas.sort( comparador::compararNombres );
		imprimirLista(personas);
		
		// referencia a metodo de instancia de un objeto arbitrario
//		personas.sort(  (persona1, persona2) ->  persona1.getFechaNacimiento().compareTo(persona2.getFechaNacimiento()) );
//		personas.sort(  (persona1, persona2) ->  persona1.compararFecha(persona2) );
		personas.sort( Persona::compararFecha );
		imprimirLista(personas);
		
		// referencia a constructor
		System.out.println(" ******** ");
//		CrearPersonaInterface factory = (nombres, fechaNacimiento, salario) -> new Persona(nombres, fechaNacimiento, salario);
		CrearPersonaInterface factory = Persona::new;
		System.out.println("Persona: " + factory.crearPersona("Diego", LocalDate.of(1988, 1, 19), 1500));
		
	}
	
	private static void imprimirLista(List<Persona> personas) {
		System.out.println(" ******** ");
		for (Persona persona : personas) {
			System.out.println(persona);
		}
	}
}

interface CrearPersonaInterface {
	Persona crearPersona(String nombres, LocalDate fechaNacimiento, Integer salario);
}
