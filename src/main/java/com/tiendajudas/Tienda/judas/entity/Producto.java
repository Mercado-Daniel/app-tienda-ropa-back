package com.tiendajudas.Tienda.judas.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nombre_indumentaria", nullable =  false)
    private String nombreIndumentaria;
    @Column(name = "tipo_indumentaria", nullable = false)
    private String tipoIndumentaria;
    @Column(name = "colores_disponibles", nullable = false)
    private Set<String> coloresDisponibles;
    @Column(name = "talles_disponibles", nullable = false)
    private Set<String> tallesDisponibles;
    @Column(name = "stock_disponible")
    private Long stockDisponible;
    @Column(length = 500)
    private String descripcion;
}
