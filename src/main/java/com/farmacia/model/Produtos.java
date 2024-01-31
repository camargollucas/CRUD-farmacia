package com.farmacia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")

public class Produtos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O nome do produto é obrigatório.")
	@Size(min = 1, max = 50, message = "O nome deve ter no mínimo 1 caracter e no máximo 50.")
	private String nome;

	@NotNull()
	private double preco;

	@NotBlank()
	@Size(min = 10, max = 10, message = "A data de validade deve ser informada no padrão DD/MM/AAAA")
	private String dataValidade;

	@Size(min = 2, max = 50, message = "O nome do fabricante deve ter no mínimo 2 caracteres e no máximo 50.")
	private String fabricante;

	@NotNull()
	@Size(min = 1, message = "A quantidade deve ser informada, no mínimo 01.")
	private String quantidade;

	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categorias categorias;

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

	public double getPreco() {
		return preco;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Categorias getCategorias() {
		return categorias;
	}

	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}

}
