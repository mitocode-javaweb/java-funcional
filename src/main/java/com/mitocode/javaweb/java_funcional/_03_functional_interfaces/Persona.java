package com.mitocode.javaweb.java_funcional._03_functional_interfaces;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Persona {

	private String nombres;
	private LocalDate fechaNacimiento;
	private Integer salario;
	private Genero genero;

	public enum Genero {
		MASCULINO, FEMENINO;
	}

	public Persona(String nombres, LocalDate fechaNacimiento) {
		this.nombres = nombres;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Persona(String nombres, LocalDate fechaNacimiento, Genero genero) {
		this.nombres = nombres;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
	}

	public Persona(String nombres, LocalDate fechaNacimiento, Integer salario) {
		this.nombres = nombres;
		this.fechaNacimiento = fechaNacimiento;
		this.salario = salario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getSalario() {
		return salario;
	}

	public void setSalario(Integer salario) {
		this.salario = salario;
	}

	public int compararFecha(Persona otraPersona) {
		return this.getFechaNacimiento().compareTo(otraPersona.getFechaNacimiento());
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Integer getEdad() {
		return (int) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
	}
	
	public void imprimirDatos() {
		System.out.println("Persona [nombres=" + nombres + ", fechaNacimiento=" + fechaNacimiento + ", salario=" + salario
				+ ", genero=" + genero + ", getEdad()=" + getEdad() + "]");
	}

}
