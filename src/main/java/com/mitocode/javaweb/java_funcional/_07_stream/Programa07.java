package com.mitocode.javaweb.java_funcional._07_stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Programa07 {
	
	public static void main(String[] args) throws IOException {
//		streamIntro();
		
//		intStream();
		
//		summaryStatistics();
		
//		streamFile();
		
		mapFlat();
	}
	
	private static void mapFlat() {
		Persona persona1 = new Persona("Pablo");
		persona1.getLenguajes().add("Java");
		persona1.getLenguajes().add("Python");
		persona1.getLenguajes().add("PHP");
		
		Persona persona2 = new Persona("Emilio");
		persona2.getLenguajes().add("Java");
		persona1.getLenguajes().add("GoLang");
		persona1.getLenguajes().add("Scala");
		
		Persona persona3 = new Persona("Juan Pablo");
		persona3.getLenguajes().add("Java");
		persona3.getLenguajes().add("NodeJS");
		persona3.getLenguajes().add("JavaScript");
		
		List<Persona> personas = Arrays.asList(persona1, persona2, persona3);
		
		List<String> lenguajesDeProgramacion = personas.stream() // Stream<Persona>
			.map(persona -> persona.getLenguajes())  // Stream<List<String>>
			.flatMap(lenguajes -> lenguajes.stream() // Stream<String>
					) // Stream<String>
			.distinct()
			.collect(Collectors.toList());
		lenguajesDeProgramacion.forEach(System.out::println);
	}

	private static void streamFile() throws IOException {
		Stream<String> lineas = Files.lines(Paths.get("src/main/resources/estudiantes.txt"));
		
		lineas // Stream<String>
			.map(nombre -> new Persona(nombre)) // Stream<Persona>
			.filter(persona -> persona.getNombres().contains("i"))
			.forEach(System.out::println);
		
		Stream<String> lineas2 = Files.lines(Paths.get("src/main/resources/estudiantes.txt"));
		List<Persona> personas =  lineas2 // Stream<String>
				.map(Persona::new) // Stream<Persona>
				.collect(Collectors.toList());
		personas.forEach(System.out::println);
		
	}

	private static void summaryStatistics() {
		List<Persona> personas = Arrays.asList(
				new Persona("Pablo", LocalDate.of(2000, 4, 15), 2000),
				new Persona("Cristian", LocalDate.of(2005, 12, 4), 3000),
				new Persona("Emilio", LocalDate.of(1995, 8, 22), 1800),
				new Persona("Juan Pablo", LocalDate.of(1990, 3, 29), 2200),
				new Persona("Karla", LocalDate.of(1997, 2, 2), 2700),
				new Persona("Yenuri", LocalDate.of(1990, 5, 10), 2700),
				new Persona("Veiko", LocalDate.of(1997, 6, 10), 2700));
		
		IntSummaryStatistics statistics =  personas.stream() // Stream<Persona>
				.mapToInt(persona -> persona.getEdad())
				.summaryStatistics();
		System.out.println(statistics);
		
	}
	
	private static void intStream() {
		IntStream numeros = IntStream.rangeClosed(10, 1000).skip(100);
		numeros.forEach(System.out::println);
		
		IntStream suma = IntStream.rangeClosed(1, 999);
		System.out.println(suma.sum());
	}

	private static void streamIntro() {
		List<Persona> personas = Arrays.asList(
				new Persona("Pablo", LocalDate.of(2000, 4, 15), 2000),
				new Persona("Cristian", LocalDate.of(2005, 12, 4), 3000),
				new Persona("Emilio", LocalDate.of(1995, 8, 22), 1800),
				new Persona("Juan Pablo", LocalDate.of(1990, 3, 29), 2200),
				new Persona("Karla", LocalDate.of(1997, 2, 2), 2700),
				new Persona("Yenuri", LocalDate.of(1990, 5, 10), 2700),
				new Persona("Veiko", LocalDate.of(1997, 6, 10), 2700));
		
		personas.stream() // Stream<Persona>
			.forEach(System.out::println); // persona -> System.out.println(persona)
		
		System.out.println("******");
		List<Persona> listaFiltro = personas.stream() // Stream<Persona>
			.filter(persona -> persona.getEdad() >= 25) // Stream<Persona>
			.collect(Collectors.toList());
		listaFiltro.forEach(System.out::println);
			
		System.out.println("******");
		double promedioEdad = personas.stream() // Stream<Persona>
			.filter(persona -> persona.getEdad() >= 18)
			.mapToInt(persona -> persona.getEdad()) // IntStream equivalente a un Stream<Integer>
			.average()
			.getAsDouble();
		System.out.println("Edad promedio: " + promedioEdad);
		
	}
}
