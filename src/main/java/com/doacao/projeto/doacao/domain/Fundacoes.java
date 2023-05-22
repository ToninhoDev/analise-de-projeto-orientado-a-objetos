package com.doacao.projeto.doacao.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
@Entity
public class Fundacoes implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String telefone;
	private String endereco;
	private String cnpj;
	
	@ManyToMany
	@JoinTable(name = "CAMPANHA_FUNDACOES", joinColumns = @JoinColumn(name = "fundacao_id"), inverseJoinColumns = @JoinColumn(name = "campanha_id"))
	private List<Campanha> campanhaFundacoes = new ArrayList<>();
	
	public Fundacoes() {
		
	}

	public Fundacoes(Integer id, String nome, String telefone, String endereco, String cnpj) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cnpj = cnpj;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public List<Campanha> getCampanhaFundacoes() {
		return campanhaFundacoes;
	}

	public void setCampanhaFundacoes(List<Campanha> campanhaFundacoes) {
		this.campanhaFundacoes = campanhaFundacoes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fundacoes other = (Fundacoes) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
