package br.com.triplex.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.triplex.domain.model.Estado;

public interface IEstadoRepository extends JpaRepository <Estado, Long>{

}
