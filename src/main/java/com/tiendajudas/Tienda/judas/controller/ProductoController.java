package com.tiendajudas.Tienda.judas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendajudas.Tienda.judas.entity.Producto;
import com.tiendajudas.Tienda.judas.repository.ProductoRepository;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductoRepository repo;

    @GetMapping("/")
    public List<Producto> getProductos(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id){
        Optional<Producto> producto = repo.findById(id);

        if(producto.isPresent()){
            return ResponseEntity.ok(producto.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    } 

    @PostMapping("/create")
    public ResponseEntity<Producto> saveProducto(@RequestBody Producto producto){
        if (producto.getId() != null && repo.existsById(producto.getId())) {
            return ResponseEntity.badRequest().body(null); // Ya existe un producto con ese ID
        }
        Producto nuevoProducto = repo.save(producto);
        return ResponseEntity.ok(nuevoProducto); // Devuelve el producto guardado
    }

    @PutMapping("/update")
    public ResponseEntity<Producto> updateProducto(@RequestBody Producto producto){
        if(!repo.existsById(producto.getId())){
            return ResponseEntity.notFound().build();
        }

        Producto resultado = repo.save(producto);
        return ResponseEntity.ok(resultado);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Producto> deleteProducto(@PathVariable Long id){
        if(!repo.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
