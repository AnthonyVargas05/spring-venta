package com.proyecto.ventas.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.ventas.model.Producto;
import com.proyecto.ventas.model.Usuario;
import com.proyecto.ventas.service.ProductoService;

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
	
}
