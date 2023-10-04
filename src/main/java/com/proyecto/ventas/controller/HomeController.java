package com.proyecto.ventas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.ventas.service.ProductoService;

@Controller
@RequestMapping("/")
public class HomeController {

	//
	@Autowired //inyecte_el contenedor_al framefor_una instancia_de esta_clase
	private ProductoService productoService;//instanciar_nos_permite_obtener_todos_los_productos
	
	//
	@GetMapping("")
	public String home(Model model) {//utilizamos_un_obj_Model:_para llevar_los_productos_hacia la_vista
		model.addAttribute("productos",productoService.findAll());//param_:nombre_productos_
		                                                          //usamos_P.S_usamos_su-metodo_de_traer_lista de_Productos
		return "usuario/home";
	}
	
	
}
