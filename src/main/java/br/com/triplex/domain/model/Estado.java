package br.com.triplex.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data //ja faz os getter e setter, construtores, toString, 
@Entity// cria entidade Cidade
@EqualsAndHashCode(onlyExplicitlyIncluded = true)//lombok cria os hashcode
public class Estado {

	@EqualsAndHashCode.Include//lombok hash code
	@Id//defini como id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto incremento
	public int id ;
	
	@Column(nullable = false)//campo não nulo
    public String nome;
	
	@Column(nullable = false)//campo não nulo
    public String uf ;
	
	@JsonIgnore
	@JoinColumn(nullable = false)//coluna não nulo
	@ManyToOne//muitas Cidade para um Estado
	private Pais pais;
}
