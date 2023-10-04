package com.proyecto.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyecto.ventas.model.Producto;
import com.proyecto.ventas.service.ProductoService;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {
	
	@Autowired//inyectar_este objeto_al administradorControle
	private ProductoService productoService;//para_poder acceder_alos_productos
	
	@GetMapping("")
	public String home(Model model) {//Model:para_mandar_los_productos_ala_vista_home
		
		List<Producto> productos= productoService.findAll();//lista_productos en_producto= nos_retorne_los_datos_de_la_BD
			model.addAttribute("productos",productos);//pasamos_los productos_obtenidos_ala_variable_productos
		return"administrador/home";//devuelve_vista_home_admin
	}
	
	
	
}
