package br.com.triplex.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data 
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UnidadeMedida {
	
	  @EqualsAndHashCode.Include
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY) 
	  public Long id;
	  
	  @Column(nullable = false)
      public String Nome;
	  
	  @Column(nullable = false)
      public String sigla ;
	  
	  @Column(nullable = false)
      public boolean ativo;
   
}
