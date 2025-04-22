package com.ArielMelo.Estoque.controller;

import com.ArielMelo.Estoque.entities.Categoria;
import com.ArielMelo.Estoque.services.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    public final CategoriaService service;

    public CategoriaController(CategoriaService service){
        this.service = service;
    }

    @GetMapping
    public List<Categoria> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria){
        return ResponseEntity.ok(service.save(categoria));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id,Categoria categoria){
        return ResponseEntity.ok(service.uptade(id, categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
