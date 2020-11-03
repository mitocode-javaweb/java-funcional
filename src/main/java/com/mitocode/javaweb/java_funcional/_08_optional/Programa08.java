package com.mitocode.javaweb.java_funcional._08_optional;

import java.util.Optional;

public class Programa08 {

	public static void main(String[] args) {
//		optionalIntro();
		
		optionalIsPresentIfPresent();
	}
	
	private static void optionalIsPresentIfPresent() {
		Optional<String> gender = Optional.of("MALE");
		Optional<String> emptyGender = Optional.empty();
		
		if(gender.isPresent()) {
			System.out.println("Valor seteado");
		} else {
			System.out.println("Valor nulo o no presente");
		}
		
		gender.ifPresent(cadena -> System.out.println("gender: Valor presente"));
		emptyGender.ifPresent(cadena -> System.out.println("emptyGender : Valor presente"));
		
		System.out.println();
		System.out.println(gender.filter(g -> g.equals("male"))); // Optional.empty
		System.out.println(gender.filter(g -> g.equalsIgnoreCase("male"))); // Optional.empty
	}

	public static void optionalIntro() {
		Optional<String> gender = Optional.of("MALE");
		
		System.out.println();
		System.out.println("Non-Empty Optional:" + gender);
		System.out.println("Non-Empty Optional: Gender value : " + gender.get());
		System.out.println("Empty Optional: " + Optional.empty());
		
		gender = Optional.empty();
		if(gender.isPresent()) {
			System.out.println("Valor seteado");
		} else {
			System.out.println("Valor nulo o no presente");
		}
		
		System.out.println();
		
		String answer1 = "Yes";
		String answer2 = null;
		
		System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(answer1));
		System.out.println("ofNullable on Empty Optional: " + Optional.ofNullable(answer2));
		
	}
}
