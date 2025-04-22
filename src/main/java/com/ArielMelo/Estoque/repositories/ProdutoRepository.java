package com.ArielMelo.Estoque.repositories;

import com.ArielMelo.Estoque.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
