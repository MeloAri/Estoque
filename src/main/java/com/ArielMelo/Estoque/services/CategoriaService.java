package com.ArielMelo.Estoque.services;

import com.ArielMelo.Estoque.entities.Categoria;
import com.ArielMelo.Estoque.exception.CategoriaException;
import com.ArielMelo.Estoque.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository){
        this.repository = repository;
    }

    public List<Categoria> findAll(){
        return repository.findAll();
    }

    public Categoria findById(Long id){
        return repository.findById(id).orElseThrow(() -> new CategoriaException("Categoria Não Encontrada"));
    }

    public Categoria save(Categoria categoria){
        return repository.save(categoria);
    }

    public Categoria uptade(Long id, Categoria categoriaAtualizada){
        Categoria categoria = findById(id);
        categoria.setNome(categoriaAtualizada.getNome());
        return repository.save(categoria);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
