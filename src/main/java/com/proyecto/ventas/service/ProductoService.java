package com.proyecto.ventas.service;
//EN ESTA CLASE DEFINO LOS METODOS CRUD PARA TABLA PRODUCTO

import java.util.List;
import java.util.Optional;

import com.proyecto.ventas.model.Producto;

public interface ProductoService {
	
	//metodos_
	public Producto save(Producto producto);
	//optional_PERMITE VALIDAR SI EL OBJETO QUE LLAMAMOS EXISTE O NO
	public Optional<Producto> get(Integer id);
	public void update(Producto producto);
	public void delete(Integer id);
	
	public List<Producto> findAll();//metodo_va traer_una_lista_productos
								   //obliga_que en_la clase_productoServiceImpl_añadir el_metodo_importar
}
