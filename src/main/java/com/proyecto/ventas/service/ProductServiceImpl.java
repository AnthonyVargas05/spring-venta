package com.proyecto.ventas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.ventas.model.Producto;
import com.proyecto.ventas.repository.ProductoRepository;

//nos_permita_inyectar_en el controlador_esta_clase_para hacer_el_llamado_a_metds_CRUD
@Service
public class ProductServiceImpl implements ProductoService{//implementamos_claseInterface

	
	
	@Autowired //-->sirve_para_decir_que_estamos_inyectanto _a_esta_clase_un objeto_
	private ProductoRepository productoRepository;//DECLARAMOS UN OBJETO DE TIPO ProductoRepository
	
	
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

}
