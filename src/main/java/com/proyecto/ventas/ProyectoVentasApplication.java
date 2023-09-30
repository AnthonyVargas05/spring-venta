package com.proyecto.ventas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//(exclude = DataSourceAutoConfiguration.class)  -->Para_que_excluya_la_clase_configuracion_mysql_error_independencia
@SpringBootApplication//(exclude = DataSourceAutoConfiguration.class)
public class ProyectoVentasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoVentasApplication.class, args);
	}

}
