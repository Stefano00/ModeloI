package com.edutecno.modeloI.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;
@Entity
@Table(name="libros")
public class Libro {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY) //autoincrementable en MySQL 
	private Integer id;
	private String anoPublicacion;
	private String titulo;
	private String nombreAutor;
	private String nombreImprenta;
	private String disponibilidad;
	
	public Libro() {
		
	}
	
	public Libro(Integer id, String anoPublicacion, String titulo, String nombreAutor, String nombreImprenta, String disponibilidad) {
		super();
		this.id = id;
		this.anoPublicacion = anoPublicacion;
		this.titulo = titulo;
		this.nombreAutor = nombreAutor;
		this.nombreImprenta = nombreImprenta;
		this.disponibilidad = disponibilidad;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAnoPublicacion() {
		return anoPublicacion;
	}
	public void setAnoPublicacion(String anoPublicacion) {
		this.anoPublicacion = anoPublicacion;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getNombreAutor() {
		return nombreAutor;
	}
	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}
	public String getNombreImprenta() {
		return nombreImprenta;
	}
	public void setNombreImprenta(String nombreImprenta) {
		this.nombreImprenta = nombreImprenta;
	}
	
	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	@Override
	public String toString() {
		
		return "Libro: ID: " +id +" Titulo: "+  titulo + " Autor: " + nombreAutor + " Ano Publicacion: " + anoPublicacion + " Imprenta: " + nombreImprenta+ " Disponibilidad: " + disponibilidad;
		
	}
	
	
	
	

}
