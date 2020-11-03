package com.mitocode.javaweb.java_funcional._04_consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Programa04 {

	public static void main(String[] args) {
//		consumerBasico();
		
//		consumerConLista(Arrays.asList("Alexis", "Cristian", "Elvis", "Emilio", "Juan Pablo", "Pablo"));
		
		biConsumer();
	}

	private static void biConsumer() {
//		BiConsumer<Integer, Integer> biConsumer1 = (a, b) -> System.out.println(a + b);
//		BiConsumer<Integer, Integer> biConsumer2 = (a, b) -> System.out.println(a - b);
//		BiConsumer<Integer, Integer> biConsumer3 = (a, b) -> System.out.println(a * b);
//		BiConsumer<Integer, Integer> biConsumer4 = (a, b) -> System.out.println(a / b);
//		
//		biConsumer1.accept(25,  7);
//		biConsumer2.accept(25,  7);
//		biConsumer3.accept(25,  7);
//		biConsumer4.accept(25,  7);
		
		ejecutarOperacion(25, 7, (a, b) -> System.out.println(a + b));
		ejecutarOperacion(25, 7, (a, b) -> System.out.println(a - b));
		ejecutarOperacion(25, 7, (a, b) -> System.out.println(a * b));
		ejecutarOperacion(25, 7, (a, b) -> System.out.println(a / b));
	}
	
	private static void ejecutarOperacion(int i, int j, BiConsumer<Integer, Integer> biConsumer) {
		biConsumer.accept(i,  j);
	}

	private static void consumerConLista(List<String> nombres) {
		Consumer<List<String>> consumerPrint = lista -> {
			for (String cadena : lista) {
				System.out.println(cadena.length() + "-" + cadena);
			}
		};
		consumerPrint.accept(nombres);
		System.out.println("********");
		
		Consumer<List<String>> consumerModificacion = lista -> {
			for (int i = 0; i < lista.size(); i++) {
				lista.set(i, "Hola " + lista.get(i));
			}
		};
		consumerModificacion.andThen(consumerPrint).accept(nombres);
		
	}

	private static void consumerBasico() {
		Consumer<String> consumer = nombre -> System.out.println("Coder: " + nombre);
		
		consumer.accept("Karla");
		consumer.andThen(name -> System.out.println("Hola " + name)).accept("Karla");
	}
}
