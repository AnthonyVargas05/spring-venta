package com.proyecto.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.ventas.model.Producto;

//DAO

//extendemos_JPARepository_<tabla,tipoDato> //por_este_dato_se_realizar_CRUD
@Repository//-->permite_que_podamos_inyectar_ esta_inteface_donde_queramos
public interface ProductoRepository extends JpaRepository<Producto,Integer>{

}
