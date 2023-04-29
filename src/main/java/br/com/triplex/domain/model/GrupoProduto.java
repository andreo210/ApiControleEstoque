package br.com.triplex.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data //ja faz os getter e setter, construtores, toString, 
@Entity// cria entidade Cidade
@EqualsAndHashCode(onlyExplicitlyIncluded = true)//lombok cria os hashcode
public class GrupoProduto {
	 @EqualsAndHashCode.Include//lombok hash code
	 @Id//defini como id
	 @GeneratedValue(strategy = GenerationType.IDENTITY) //auto incremento
	 public int id;
	 
	 @Column(nullable = false)//campo não nulo
     public String nome ;
	 
	 @Column(nullable = false)//campo não nulo
     public boolean ativo ;
}
