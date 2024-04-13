package com.flussen.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flussen.apirest.apirest.Entities.Producto;
import com.flussen.apirest.apirest.Repositories.ProductoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Producto> getAllProductos(){
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto getProductByID(@PathVariable Long id){
        return productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el id " + id));
    }

    @PostMapping
    public Producto createProducto(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto detailsProducto){
        Producto producto = productoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("No se encontró el id " + id));

        producto.setNombre(detailsProducto.getNombre());
        producto.setPrecio(detailsProducto.getPrecio());
        
        return productoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
    Producto producto = productoRepository.findById(id)
    .orElseThrow(() -> new RuntimeException("No se encontró el id " + id));
    
    productoRepository.delete(producto);
    return "producto ID " + id + " fue eliminado correctamente";
    
    }
}
