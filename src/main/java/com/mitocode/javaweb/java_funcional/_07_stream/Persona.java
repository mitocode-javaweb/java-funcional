package com.mitocode.javaweb.java_funcional._07_stream;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Persona {

	private String nombres;
	private LocalDate fechaNacimiento;
	private Integer salario;
	
	private List<String> lenguajes;
	
	public Persona(String nombres) {
		this.nombres = nombres;
		this.fechaNacimiento = LocalDate.of(1990, 1, 1);
		
		this.lenguajes = new ArrayList<>();
	}

	public Persona(String nombres, LocalDate fechaNacimiento) {
		this.nombres = nombres;
		this.fechaNacimiento = fechaNacimiento;
		
		this.lenguajes = new ArrayList<>();
	}

	public Persona(String nombres, LocalDate fechaNacimiento, Integer salario) {
		this.nombres = nombres;
		this.fechaNacimiento = fechaNacimiento;
		this.salario = salario;
		
		this.lenguajes = new ArrayList<>();
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
	
	public Integer getEdad() {
		return (int) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
	}

	@Override
	public String toString() {
		return "Persona [nombres=" + nombres + ", fechaNacimiento=" + fechaNacimiento + ", salario=" + salario + ", edad=" + getEdad() + "]";
	}

	public List<String> getLenguajes() {
		return lenguajes;
	}

	public void setLenguajes(List<String> lenguajes) {
		this.lenguajes = lenguajes;
	}
	
}
