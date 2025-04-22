package com.ArielMelo.Estoque.repositories;

import com.ArielMelo.Estoque.entities.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
}
