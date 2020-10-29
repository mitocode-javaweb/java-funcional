package com.mitocode.javaweb.java_funcional._00_Intro;

public class Programa00 {

	public static void main(String[] args) {
//		IntegerMaths suma = new IntegerSuma();
//		IntegerMaths resta = new IntegerResta();
		IntegerMaths multiplicacion = new IntegerMaths() {
			@Override
			public int operacion(int a, int b) {
				return a * b;
			}
		};
		
		IntegerMaths division = (int a, int b) -> { return a / b; } ;
		IntegerMaths suma = (int a, int b) -> a + b; 
		IntegerMaths resta = (a, b) -> a - b ;
		
		int a = 17;
		int b = 5;
		
		System.out.println("Suma: " + suma.operacion(a, b));
		System.out.println("Resta: " + resta.operacion(a, b));
		System.out.println("Multiplicacion: " + multiplicacion.operacion(a, b));
		System.out.println("Division: " + division.operacion(a, b));
	}
}

interface IntegerMaths {
	int operacion(int a, int b);
//	double promedio(double x, double y);
}

class IntegerSuma implements IntegerMaths {
	@Override
	public int operacion(int a, int b) {
		return a + b;
	}
}

class IntegerResta implements IntegerMaths {
	@Override
	public int operacion(int a, int b) {
		return a - b;
	}
}