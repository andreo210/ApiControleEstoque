package br.com.triplex.domain.model;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

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
public class EntradaProduto {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@Column(nullable = false)
    public String numero;
	
	//@JsonIgnore
	@CreationTimestamp
	@Column(nullable = false, columnDefinition = "datetime")
    public LocalDateTime dataEntrada;
    
    @Column(nullable = false)
    public Long quantidade;

    @JoinColumn(nullable = false)
	@ManyToOne
    public  Produto produto;
}
