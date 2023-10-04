package com.proyecto.ventas.service;

import java.util.List;

import java.util.Optional;//importe_FindALL

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.proyecto.ventas.model.Producto;

import com.proyecto.ventas.repository.ProductoRepository;

//nos_permita_inyectar_en el controlador_esta_clase_para hacer_el_llamado_a_metds_CRUD
@Service//componente_de servicio_de spring
public class ProductServiceImpl implements ProductoService{//implementamos_claseInterface

	
	
	@Autowired //-->inyectanto_auna_instancia_deProductoRepository_
	private ProductoRepository productoRepository;//DECLARAMOS UN OBJETO DE TIPO ProductoRepository
	/*Esto es conocido como inyección de dependencias
	 *  y permite que la clase ProductServiceImpl acceda 
	 *  a los métodos proporcionados por ProductoRepository 
	 *  para interactuar con la base de datos.*/
	
	//Implementacion_metodos_de_la_interfaz
	@Override
	public Producto save(Producto producto) {
		return productoRepository.save(producto);//
	}

	@Override
	public Optional<Producto> get(Integer id) {
		return productoRepository.findById(id);
	}

	@Override
	public void update(Producto producto) {
		productoRepository.save(producto);//save(cuando_al_objeto_le-mandamos_id_null_lo_crea_pero_si le_mandamos id_existente_actualiza)
	}

	@Override
	public void delete(Integer id) {	
		productoRepository.deleteById(id);
	}

	//UTILIZAMOS EL OBJ Y METODO
	@Override
	public List<Producto> findAll() {		
		return productoRepository.findAll();
	}

}
