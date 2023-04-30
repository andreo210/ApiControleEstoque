package br.com.triplex.domain.repository;

import br.com.triplex.domain.model.Pais;

import  org.springframework.data.jpa.repository.JpaRepository;

public interface IPaisRepository extends JpaRepository <Pais, Long> {
	

}
