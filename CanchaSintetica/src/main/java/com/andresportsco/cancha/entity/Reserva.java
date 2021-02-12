package com.andresportsco.cancha.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {
	@Id
	@Column
	private Long id;
	@Column
	private LocalDateTime fecha;
	@Column
	private Usuario usuario;
	
	@ManyToOne()
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne()
	@JoinColumn(name = "cancha_id")
	private Cancha cancha;
	
	public Reserva(Long id, LocalDateTime fecha, Usuario usuario, Cliente cliente, Cancha cancha) {
		
		this.id = id;
		this.fecha = fecha;
		this.usuario = usuario;
		this.cliente = cliente;
		this.cancha = cancha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cancha getCancha() {
		return cancha;
	}

	public void setCancha(Cancha cancha) {
		this.cancha = cancha;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", fecha=" + fecha + ", usuario=" + usuario + ", cliente=" + cliente + ", cancha="
				+ cancha + "]";
	}
	
	
}
