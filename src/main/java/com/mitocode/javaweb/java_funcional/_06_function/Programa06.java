package com.mitocode.javaweb.java_funcional._06_function;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

import org.apache.commons.codec.digest.DigestUtils;

public class Programa06 {

	public static void main(String[] args) {
//		functionIntro();
		
		function2();
	}

	private static void function2() {
		List<String> nombres = Arrays.asList("Alexis", "Cristian", "Elvis", "Emilio", "Juan Pablo", "Pablo");

		Map<String, Integer> mapaTamanio = convertirLista(nombres, cadena -> cadena.length());
		System.out.println(mapaTamanio);
		
		Map<String, String> mapaHash = convertirLista(nombres, cadena -> DigestUtils.sha256Hex(cadena));
		for (Entry<String, String> elemento : mapaHash.entrySet()) {
			System.out.println(elemento.getKey() + ": " + elemento.getValue());
		}
	}

	private static <T, R> Map<T, R> convertirLista(List<T> nombres, Function<T, R> funcion) {
		Map<T, R> mapa = new HashMap<>();
		for (T nombre : nombres) {
			mapa.put(nombre, funcion.apply(nombre));
		}
		return mapa;
	}

	private static void functionIntro() {
		String nombreCurso = "Java Web Developer 2020";
		Function<String, Integer> f1 = cadena -> cadena.length();
		int tamanio = f1.apply(nombreCurso);
		System.out.println(nombreCurso + " - " + tamanio);

		Function<Integer, Boolean> fEsPar = numero -> numero % 2 == 0;
		Boolean esPar = f1.andThen(fEsPar).apply(nombreCurso);
		System.out.println(nombreCurso + " es par: " + esPar);
	}
}
