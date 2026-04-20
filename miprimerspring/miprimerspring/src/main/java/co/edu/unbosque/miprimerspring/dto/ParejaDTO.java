package co.edu.unbosque.miprimerspring.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class ParejaDTO {

	private long id;
	private String nombre;
	private int edad;
	private LocalDateTime fechaAniversario;
	private String carrera;

	public ParejaDTO() {
		// TODO Auto-generated constructor stub
	}

	public ParejaDTO(String nombre, int edad, LocalDateTime fechaAniversario, String carrera) {
		this.nombre = nombre;
		this.edad = edad;
		this.fechaAniversario = fechaAniversario;
		this.carrera = carrera;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public LocalDateTime getFechaAniversario() {
		return fechaAniversario;
	}

	public void setFechaAniversario(LocalDateTime fechaAniversario) {
		this.fechaAniversario = fechaAniversario;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return "ParejaDTO [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", fechaAniversario="
				+ fechaAniversario + ", carrera=" + carrera + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(carrera, edad, fechaAniversario, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParejaDTO other = (ParejaDTO) obj;
		return Objects.equals(carrera, other.carrera) && edad == other.edad
				&& Objects.equals(fechaAniversario, other.fechaAniversario) && id == other.id
				&& Objects.equals(nombre, other.nombre);
	}

}
