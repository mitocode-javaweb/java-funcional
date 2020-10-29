package com.mitocode.javaweb.java_funcional._01_scopes;

public class Programa01 {

	public int x = 50;
	public static int y = 20;
	
	public static void main(String[] args) {
		Programa01 programa = new Programa01();
		programa.variableLocal();
		System.out.println("*******");
		programa.variableGlobal();
	}
	
	private void variableLocal() {
		final int c = 6;
		
		IntegerMaths suma = (a, b) -> {
			// dentro del scope de una lambda no puede modificar variables locales
//			c = a + b + c;
			return a + b + c; 
		};
		
		int a = 10;
		int b = 5;
		System.out.println("Suma: " + suma.operacion(a, b));
	}
	
	private void variableGlobal() {
		IntegerMaths resta = (a, b) -> {
			x = a - b;
			y = x;
			return x; 
		};
		
		int a = 10;
		int b = 5;
		
		System.out.println("X: " + x);
		System.out.println("Y: " + y);
		System.out.println("Resta: " + resta.operacion(a, b));
		System.out.println("X: " + x);
		System.out.println("Y: " + y);
	}
}

interface IntegerMaths {
	int operacion(int a, int b);
}