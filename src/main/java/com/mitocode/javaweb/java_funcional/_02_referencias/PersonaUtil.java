package com.mitocode.javaweb.java_funcional._02_referencias;

public class PersonaUtil {

	public static int compararEdad(Persona persona1, Persona persona2) {
		return persona1.getEdad().compareTo(persona2.getEdad());
	}
	
	public int compararNombres(Persona persona1, Persona persona2) {
		return persona1.getNombres().compareTo(persona2.getNombres());
	}
	
	public static int compararFechaNacimiento(Persona persona1, Persona persona2) {
		return persona1.getFechaNacimiento().compareTo(persona2.getFechaNacimiento());
	}
}
