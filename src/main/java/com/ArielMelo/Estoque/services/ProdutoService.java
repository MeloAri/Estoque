package com.ArielMelo.Estoque.services;

import com.ArielMelo.Estoque.entities.Produto;
import com.ArielMelo.Estoque.exception.ProdutoException;
import com.ArielMelo.Estoque.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository){
        this.repository = repository;
    }

    public List<Produto> findAll(){
        return repository.findAll();
    }

    public Produto findById(Long id){
        return repository.findById(id).orElseThrow(() -> new ProdutoException("Produto não Encontrado"));
    }

    public Produto save(Produto produto){
        return repository.save(produto);
    }

    public Produto update(Long id, Produto produtoAtualizado){
        Produto produto = findById(id);
        produto.setNome(produtoAtualizado.getNome());
        produto.setQuantidade(produtoAtualizado.getQuantidade());
        produto.setCategoria(produtoAtualizado.getCategoria());
        return repository.save(produto);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
