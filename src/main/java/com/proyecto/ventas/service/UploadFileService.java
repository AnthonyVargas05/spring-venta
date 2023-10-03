package com.proyecto.ventas.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileService {

	// Va_tener_la_ubicacion en_nuestro_proyecto donde_se_va_cargar_las_imagenes 
	// Cargar_la_imagen_dentro del_proyecto_que va_pertenecer_a_un_producto y_tambien_vamos_a_almacenar_el_nombre_de_la_imagen_en_bd 
	// Vamos_a_almacenar_en_un_campo de_la base o_de_la_tabla_producto vamos_a_almacenar_el_nombre_de_la_imagen sin_embargo_la_imagen_como_la_vamos_almacenar_dentro_del_proyecto 
	private String folder="images//";
	
	
	
	public String saveImage(MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			byte [] bytes=file.getBytes();
			Path path =Paths.get(folder+file.getOriginalFilename());
			Files.write(path, bytes);
			return file.getOriginalFilename();
		}
		return "default.jpg";
	}
	
	public void deleteImage(String nombre) {
		String ruta="images//";
		File file= new File(ruta+nombre);
		file.delete();
	}
	
	
	
	/*
	//METODO GUARDAR IMAGEN
	public String saveImage(MultipartFile file) throws IOException {
		if(file.isEmpty()) {//file=image.no es_vacio_pasamos a_bits 01
			byte[] bytes=file.getBytes();//arreglo_de_tipo_byte
		    Path path = Paths.get(folder+file.getOriginalFilename());//folder le_pasamos_la ubicasion_donde_se_guarde
                                                                 //+ concatenamos_con file_el archivo_que_viene 
		                                                        //getOriginalFilename_que en_Path se_guarde
		   Files.write(path, bytes); //escribe_en_el_direcctorio en_el Path que_le_estamos_pasando                                            
		                            //path=ruta_ + byte = trae_a_trasformado nuestra_image_en_bits para_poder enviarla_al_servidor                          
		 
		   return file.getOriginalFilename();//retorno_el_nombre_de_la_imagen_subida/solo nombre_y extencion_para guardarla_en el campo_imagen_que esta_en _producto 
		}		
		//CUANDO NO CARGA IMAGEN_SE_PONE_IMAGEN_POR_DEFECTO
		return"defauld.jpg";		
	 }
	
	*/
	/*
	//METODO ELIMINAR IMAGEN
	public void deleteImage(String nombre) {//recibe_nombre_imagen
	String ruta = "image//";//ruta_se_guarda_la_imagen
	
	File file= new 	File(ruta+nombre);//constructor_
	file.delete();
	}
	*/
}
