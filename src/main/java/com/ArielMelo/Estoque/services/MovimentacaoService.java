package com.ArielMelo.Estoque.services;

import com.ArielMelo.Estoque.entities.Movimentacao;
import com.ArielMelo.Estoque.entities.Produto;
import com.ArielMelo.Estoque.exception.MovimentacaoException;
import com.ArielMelo.Estoque.exception.ProdutoException;
import com.ArielMelo.Estoque.repositories.MovimentacaoRepository;
import com.ArielMelo.Estoque.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoService {

    private final MovimentacaoRepository repository;
    private final ProdutoRepository produtoRepository;

    public MovimentacaoService(MovimentacaoRepository repository, ProdutoRepository produtoRepository){
        this.repository = repository;
        this.produtoRepository = produtoRepository;
    }

    public List<Movimentacao> findAll(){
        return repository.findAll();
    }

    public Movimentacao findById(Long id){
        return repository.findById(id).orElseThrow(() -> new MovimentacaoException("Movimentação não Encontrada"));
    }

    public Movimentacao save(Movimentacao movimentacao){
        Produto produto = produtoRepository.findById(movimentacao.getProduto().getId())
                .orElseThrow(() -> new ProdutoException("Produto não Encontrado"));

        switch (movimentacao.getTipo()) {
            case ENTRADA:
                produto.setQuantidade(produto.getQuantidade() + movimentacao.getQuantidade());
                break;
            case SAIDA:
                if (produto.getQuantidade() < movimentacao.getQuantidade()) {
                    throw new MovimentacaoException("Estoque insuficiente para saída");
                }
                produto.setQuantidade(produto.getQuantidade() - movimentacao.getQuantidade());
                break;
            default:
                throw new MovimentacaoException("Tipo de movimentação inválido");
        }
        produtoRepository.save(produto);
        return repository.save(movimentacao);
    }

}
