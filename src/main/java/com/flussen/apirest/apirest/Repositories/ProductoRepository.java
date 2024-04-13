package com.flussen.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flussen.apirest.apirest.Entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}
