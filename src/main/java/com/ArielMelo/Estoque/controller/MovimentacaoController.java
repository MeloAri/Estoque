package com.ArielMelo.Estoque.controller;

import com.ArielMelo.Estoque.entities.Movimentacao;
import com.ArielMelo.Estoque.services.MovimentacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewMethodReturnValueHandler;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    private final MovimentacaoService service;

    public  MovimentacaoController(MovimentacaoService service){
        this.service = service;
    }

    @GetMapping
    public List<Movimentacao> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movimentacao> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Movimentacao> uptade(@RequestBody Movimentacao movimentacao){
        return ResponseEntity.ok(service.save(movimentacao));
    }




}
