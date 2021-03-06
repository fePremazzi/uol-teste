package com.uol.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private Integer idade;
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "idTemp")
	private Temperatura temp;
	
	
	//Getter, Setters and Constructors
	public Cliente() {
	}
	
	public Cliente(Long id, String nome, Integer idade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}
	
	public Cliente(Long id, String nome, Integer idade, Temperatura temp) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.temp = temp;
	}
	
	public Temperatura getTemp() {
		return temp;
	}
	
	public void setTemp(Temperatura temp) {
		this.temp = temp;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getIdade() {
		return idade;
	}
	
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	

}
