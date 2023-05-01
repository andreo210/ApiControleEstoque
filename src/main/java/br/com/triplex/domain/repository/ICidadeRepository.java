package br.com.triplex.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.triplex.domain.model.Cidade;

public interface ICidadeRepository  extends JpaRepository <Cidade, Long>{

}
