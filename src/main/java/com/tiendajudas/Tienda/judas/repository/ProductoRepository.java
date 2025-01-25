package com.tiendajudas.Tienda.judas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiendajudas.Tienda.judas.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
}
