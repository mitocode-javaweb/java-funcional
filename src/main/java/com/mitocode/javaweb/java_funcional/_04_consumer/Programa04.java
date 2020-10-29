package com.mitocode.javaweb.java_funcional._04_consumer;

import java.util.function.Consumer;

public class Programa04 {

	public static void main(String[] args) {
		Consumer<String> consumer = nombre -> System.out.println("Coder: " + nombre);
		
		consumer.accept("Karla");
		consumer.andThen(name -> System.out.println("Hola " + name)).accept("Karla");
	}
}
