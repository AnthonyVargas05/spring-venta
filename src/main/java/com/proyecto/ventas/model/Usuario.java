package com.proyecto.ventas.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity //-->DEFINO-CLASE_ENTIDAD
@Table(name ="usuarios") //-->SIRVE PARA MODIFICAR_EL_NOMBRE_DE_LA_TABLA_AL_SER_CREADO_EN_BD
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //-->PARA QUE ID SEA AUTOINCREMET
	//atributos_de_la_clase_Usuario
	private Integer id;
	private String nombre;
	private String username;
	private String email;
	private String direccion;
	private String telefono;
	private String tipo;
	private String password;
	
	
	
	@OneToMany(mappedBy = "usuario") //-->RELACIONAMOS UNO A MUCHOS / MAPEADO usuario_

	//CREAMOS UN ATRIBUTO QUE NOS VA DEVOLVER UNA LISTA DE PRODUCTOS
	private List<Producto>productos;
	
	
	@OneToMany(mappedBy="usuario")//MAPEAMOS_CLASE > 
	            
	//clase_obj
	private List<Orden> ordenes;//OBTENER UNA LISTA DE ORDENES PARA USUARIO
		
	
	//constructor_sin_parametros
	public Usuario() {	
	}
	
	
	//constructor_con parametros_
	public Usuario(Integer id, String nombre, String username, String email, String direccion, String telefono,
			String tipo, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.username = username;
		this.email = email;
		this.direccion = direccion;
		this.telefono = telefono;
		this.tipo = tipo;
		this.password = password;
	}
		
	//getters y setters_
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	//getters_y_setters _lista_productos
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}


	//METODO toString()_
	//VA RETORNAR TODOS LOS CAMPOS DE LA CLASE COMO UN SOLO STRING
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", username=" + username + ", email=" + email
				+ ", direccion=" + direccion + ", telefono=" + telefono + ", tipo=" + tipo + ", password=" + password
				+ "]";
	}

	
}











