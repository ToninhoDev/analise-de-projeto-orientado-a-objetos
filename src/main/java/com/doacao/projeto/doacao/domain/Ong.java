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
public class Ong implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cnpj;
	private String conta;
	private String telefone;
	private String status;
	
	@ManyToMany
	@JoinTable(name = "ONG_CAMPANHA", joinColumns = @JoinColumn(name = "ong_id"), inverseJoinColumns = @JoinColumn(name = "ongCampanha_id"))
	private List<Campanha> campanhaOng = new ArrayList<>();

	public Ong() {
		super();
	}

	public Ong(Integer id, String nome, String cnpj, String conta, String telefone, String status) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.conta = conta;
		this.telefone = telefone;
		this.status = status;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Campanha> getCampanhaOng() {
		return campanhaOng;
	}

	public void setCampanhaOng(List<Campanha> campanhaOng) {
		this.campanhaOng = campanhaOng;
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
		Ong other = (Ong) obj;
		return Objects.equals(id, other.id);
	}

}
