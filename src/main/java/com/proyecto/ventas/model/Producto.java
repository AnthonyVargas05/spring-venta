package com.proyecto.ventas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity //-->DEFINO-CLASE_ENTIDAD
@Table(name ="productos") //-->SIRVE PARA MODIFICAR_EL_NOMBRE_DE_LA_TABLA_AL_SER_CREADO_EN_BD
public class Producto {
	
	  @Id //-->id
	  @GeneratedValue(strategy = GenerationType.IDENTITY) //-->PARA QUE ID SEA AUTOINCREMET
	//atributos_de_la_clase_Producto
		private Integer id;
		private String nombre;
		private String descripcion;
		private String imagen;
		private double precio;
		private int cantidad;

		//RELACIONAMOS
		@ManyToOne
		private Usuario usuario;//CREA UN CAMPO EN LA TABLA PRODUCTOS / PARA MANDAR ID_USUARIO O USUARIO COMO OBJ Y SE MAPÉ A ESTA CLASE
		
		//constructor_sin_parametros
		public Producto() {		
		}
		
	//constructor_con_parametros_usuario+
	public Producto(Integer id, String nombre, String descripcion, String imagen, double precio, int cantidad,
			Usuario usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precio = precio;
		this.cantidad = cantidad;
		this.usuario = usuario;
	}
	
	
	//getters y_setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	//getter y setter_Usuario
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	//METODO toString()_
	//VA RETORNAR TODOS LOS CAMPOS DE LA CLASE COMO UN SOLO STRING
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", imagen=" + imagen
				+ ", precio=" + precio + ", cantidad=" + cantidad + "]";
	}
	
		
}
