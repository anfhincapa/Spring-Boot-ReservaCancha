package com.andresportsco.cancha.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "cancha")
public class Cancha {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name="native", strategy = "native")
	private int id;
	@Column
	@NotBlank
	private String nombre;
	@Column
	@NotBlank
	private int capacidad;
	@Column
	@NotBlank
	private String estado;
	@Column
	@NotBlank
	private double precio;
	
	@OneToMany(mappedBy = "cancha", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Reserva> reservas;
	
	public Cancha(int id, String nombre, int capacidad, String estado, double precio, Set<Reserva> reservas) {
		
		this.id = id;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.estado = estado;
		this.precio = precio;
		this.reservas = reservas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Set<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Set<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Cancha [id=" + id + ", nombre=" + nombre + ", capacidad=" + capacidad + ", estado=" + estado
				+ ", precio=" + precio + ", reservas=" + reservas + "]";
	}
	
	
}
