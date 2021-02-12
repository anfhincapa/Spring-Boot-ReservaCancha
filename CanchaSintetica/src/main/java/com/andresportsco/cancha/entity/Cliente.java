package com.andresportsco.cancha.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="cliente")
public class Cliente {
	@Id
	@Column
	@NotNull
	private Long identificacion;
	@Column
	@NotBlank
	private String tipoId;
	@Column
	@NotBlank
	private String nombre;
	@Column
	@NotBlank
	private String apellido;
	@Column
	private int edad;
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Reserva> reserva;
	
	
	public Cliente(Long identificacion, String tipoId, String nombre,
			  String apellido, int edad, Set<Reserva> reserva) {
		
		this.identificacion = identificacion;
		this.tipoId = tipoId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.reserva = reserva;
	}


	public Long getIdentificacion() {
		return identificacion;
	}


	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}


	public String getTipoId() {
		return tipoId;
	}


	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public Set<Reserva> getReserva() {
		return reserva;
	}


	public void setReserva(Set<Reserva> reserva) {
		this.reserva = reserva;
	}


	@Override
	public String toString() {
		return "Cliente [identificacion=" + identificacion + ", tipoId=" + tipoId + ", nombre=" + nombre + ", apellido="
				+ apellido + ", edad=" + edad + ", reserva=" + reserva + "]";
	}
	
		

}
