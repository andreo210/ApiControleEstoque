package br.com.triplex.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data 
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Estado {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	public Long id ;
	
	@Column(nullable = false)
    public String nome;
	
	@Column(nullable = false)
    public String uf ;
	
	@JoinColumn(nullable = false)
	@ManyToOne
	private Pais pais;
}
