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

@Data //ja faz os getter e setter, construtores, toString, 
@Entity// cria entidade Cidade
@EqualsAndHashCode(onlyExplicitlyIncluded = true)//lombok cria os hashcode
public class Fornecedor {
	  @EqualsAndHashCode.Include//lombok hash code
	  @Id//defini como id
	  @GeneratedValue(strategy = GenerationType.IDENTITY) //auto incremento
	  public int id;
	  
	  @Column(nullable = false)//campo não nulo
      public String nome;
	  
	  @Column(nullable = false)//campo não nulo
      public String razaoSocial;
	  
	  @Column(nullable = false)//campo não nulo
      public String numDocumento;
	  
	  @Column(nullable = false)//campo não nulo
      public String telefone;
	  
	  @Column(nullable = false)//campo não nulo
      public String contato;
	  
	  @Column(nullable = false)//campo não nulo
      public String logradouro;
	  
	  @Column(nullable = false)//campo não nulo
      public String numero ;
	  
	  @Column(nullable = false)//campo não nulo
      public String complemento;
	  
	  @Column(nullable = false)//campo não nulo
      public String cep;
	  
	  @Column(nullable = false)//campo não nulo
	  public boolean Ativo;	  
	  
	  @JoinColumn(nullable = false)//coluna não nulo
	  @ManyToOne//muitas Cidade para um Estado
      public  Pais pais ;  
	  
	  @JoinColumn(nullable = false)//coluna não nulo
	  @ManyToOne//muitas Cidade para um Estado
      public  Estado estado; 
	  
	  @JoinColumn(nullable = false)//coluna não nulo
	  @ManyToOne//muitas Cidade para um Estado
      public Cidade cidade;
      
}