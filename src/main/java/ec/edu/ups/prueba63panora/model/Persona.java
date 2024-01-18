package ec.edu.ups.prueba63panora.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Persona {

	@Id
	private int Codigo;
	private String Cedula;
	private String Nombre;
	private String Mes;
	private Double cantidad;
	public int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int codigo) {
		this.Codigo = codigo;
	}
	public String getCedula() {
		return Cedula;
	}
	public void setCedula(String cedula) {
		Cedula = cedula;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getMes() {
		return Mes;
	}
	public void setMes(String mes) {
		Mes = mes;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "Persona [codigo=" + Codigo + ", Cedula=" + Cedula + ", Nombre=" + Nombre + ", Mes=" + Mes
				+ ", cantidad=" + cantidad + "]";
	}
	
	
	
	
}
