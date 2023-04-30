package br.com.triplex.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data 
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Produto {
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id ;
	
	@Column(nullable = false)
    public String codigo;
	
	@Column(nullable = false)
    public String nome ;

	@Column(nullable = false)
    public BigDecimal precoCusto ;
	
	@Column(nullable = false)
    public BigDecimal precoVenda ;
	
	@Column(nullable = false)
    public Long quantEstoque ;

	@JoinColumn(nullable = false)
	@ManyToOne
    public  UnidadeMedida unidadeMedida ;
 
	@JoinColumn(nullable = false)
	@ManyToOne
    public  GrupoProduto grupo ;
  
	@ManyToMany
	@JoinTable
    public  List<MarcasProduto>marcas = new ArrayList<>() ;

	@JoinColumn(nullable = false)
	@ManyToOne
    public  Fornecedor fornecedor ;
 
	@ManyToMany
	@JoinTable
    public List<LocalArmazenamento> localArmazenamentos = new ArrayList<>() ;
    
    @Column(nullable = false)
    public boolean Ativo ;
    
    @Column(nullable = false)
    public String Imagem ;

}
