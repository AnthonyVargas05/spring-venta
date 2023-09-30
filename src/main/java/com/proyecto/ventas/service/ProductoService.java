package com.proyecto.ventas.service;
//EN ESTA CLASE DEFINO LOS METODOS CRUD PARA TABLA PRODUCTO

import java.util.Optional;

import com.proyecto.ventas.model.Producto;

public interface ProductoService {
	
	//metodos_
	public Producto save(Producto producto);
	//optional_PERMITE VALIDAR SI EL OBJETO QUE LLAMAMOS EXISTE O NO
	public Optional<Producto> get(Integer id);
	public void update(Producto producto);
	public void delete(Integer id);
}
