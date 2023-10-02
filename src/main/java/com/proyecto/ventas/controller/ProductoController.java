package com.proyecto.ventas.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.ventas.model.Producto;
import com.proyecto.ventas.model.Usuario;
import com.proyecto.ventas.service.ProductoService;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.slf4j.*;


@Controller
@RequestMapping("/productos")
public class ProductoController {
		
	//nos_sirve_para_ver_la_imformacion_que se_le pasa_al_baked
	//MUESTRA EN LA CONSOLA_EN QUE CLASE ESTA REALIZANDO LA IMPRECION_
	private final Logger LOGGER =LoggerFactory.getLogger(ProductoController.class);
	
	
	@Autowired //-->PARA NO INSTANCIAR EN OBJ
	//DECLARAMOS_UNA VARIABLE DE TIPO PRODUCTOSERVICE_PARA ACCEDER ALOS METRODOS CRUD
	private ProductoService productoService;
	
	
	
	@GetMapping("")                      //se_agrega_parametro
		public String show(Model model) {//Model=llevar_informacion de_bd a_lista
			
		model.addAttribute("productos",productoService.findAll());//parametris_(NOMBREX,INTERFAZ_METODO)
		return "productos/show";
		}
	
	@GetMapping("/create")//url_
	 public String create() {
		 return"productos/create";//direccion_
	 }
	
	
	
	//MAPEAR LA IMFORMACION DESDE EL BOTON GUARDAR PARA QUE SE GUARDE EN BD
	@PostMapping("/save")//
	public String save(Producto producto) {//VAMOS A RECIBIR UN OBJ DE TIPO PRODUCTO
		LOGGER.info("Este es el objeto producto{}",producto);//SIRVE PARA TESTEAR_GUARDAR/ {}= FORMA DE DECIR QUE ACONTINUACION VA VENIR UNA VARI9ABLE O OBJ (producto_obj)  
	
		Usuario u = new Usuario(1,"","","","","","","");//creamos_un_usuario_respetar_tipodedato
		
		producto.setUsuario(u);//en_producto_vamos a pasar_usuario
		
		productoService.save(producto);//guardar_
		
		return "redirect:/productos";//PEDICION AL CONTROLADOR_VA CARGAR VISTA SHOW
	}
	
	
	//METODO PARA  EDITAR
	@GetMapping("/edit/{id}")	//url_ {id} obtener_id de_registro al_que bamos_a_buscarlo y_pasarlo a vista_para_editarlo
	public String edit(@PathVariable Integer id, Model model) {//@PathVariable-->PERMITE MAPEAR EL ID QUE VIENE EN LA URL PASARLA ALA VARIABLE continua_Integer id:
		Producto producto = new Producto(); //en_este_obj_almacenamos_el_obj_buscado
		//variable //tipo_producto//nombre_OptionalProducto=-->Esto_es lo_que_nos_devuelve cuando_hacemos la_busqueda_de_un_obj de_tipo_producto   
		Optional<Producto> optionalProducto = productoService.get(id);//utilizamos_obj_productoService_hacemos la_invocasion_del_metodo		
		//esto_trae_el_producto_buscado
		producto=optionalProducto.get();//le_pasamos_el_productobuscado(que_esta_en_OPTIONALPRODUCTO)a __producto
		
		//test
		LOGGER.info("Producto buscado: {}",producto);//{}=acontinuacion_viene una_variable_que_vamos a_imprimir
		
		//nos_envia_ala_vista_todo-el_obj_buscado
		model.addAttribute("producto", producto);//variable_producto le_lleve_ala vista y le_pasamos el valor de_lo_que tiene_producto
		
		return "Productos/edit";//direccion_
	}
	
	//METODO ACTUALIZAR
	@PostMapping("/update")//ESTE METODO VA RESPONDER A UNA PETICION TIPO POST
	public String update(Producto producto){//recibe_como parametros_un_obj_tipo_productos
		
		productoService.update(producto);//obj_productoService.update(pasamos_el_obj_producto)
		return"redirect:/productos" ;	//redireccionamos_a_vistaProductos
	}
	
	
	//METODO ELIMINAR
	@GetMapping("/delete/{id}")//determinacion_url/_papeo_id
	public String delete(@PathVariable Integer id) {//_notacion permite_mapeo_de la_variabe que_viene de_la URL y lo_pase ala_varible como_parametro
		productoService.delete(id);//
		return "redirect:/productos";
		
	}
	
	
	
	
}
