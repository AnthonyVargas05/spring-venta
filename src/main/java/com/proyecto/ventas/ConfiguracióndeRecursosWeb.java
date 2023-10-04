package com.proyecto.ventas;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//MOSTRAR PRODUCTOS EN LA HOMEADMINISTRADOR

@Configuration
public class ConfiguracióndeRecursosWeb implements WebMvcConfigurer {//WebMvcConfigurer--clase_de_una_interfaz
	
	//METODO PARA APUNTAR DIRECTORIO IMAGEN_PARA MOSTRAR AL ADMIN
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//                                       //indicasion_a_donde_debe_apuntar
		registry.addResourceHandler("/images/**").addResourceLocations("file:images/");// **_tome todos_los_archivos_del_directorio

	}

}
