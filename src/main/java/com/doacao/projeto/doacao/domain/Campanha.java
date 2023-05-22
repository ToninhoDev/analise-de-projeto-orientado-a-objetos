package com.doacao.projeto.doacao.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Campanha implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String dataInicial;
	private String dataFinal;
	private String valor;
	private String valorDaMeta;
	private String descricao;
	private String pessoas;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "campanha")
	private List<Doador> doador = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(mappedBy = "campanhaOng")
	private List<Ong> ongs = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(mappedBy = "campanhaFundacoes")
	private List<Fundacoes> fundacoes = new ArrayList<>();


	public Campanha() {
		super();
	}

	public Campanha(Integer id, String dataInicial, String dataFinal, String valor, String valorDaMeta,
			String descricao, String pessoas) {
		super();
		this.id = id;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
		this.valor = valor;
		this.valorDaMeta = valorDaMeta;
		this.descricao = descricao;
		this.pessoas = pessoas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getValorDaMeta() {
		return valorDaMeta;
	}

	public void setValorDaMeta(String valorDaMeta) {
		this.valorDaMeta = valorDaMeta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPessoas() {
		return pessoas;
	}

	public void setPessoas(String pessoas) {
		this.pessoas = pessoas;
	}

	public List<Doador> getDoador() {
		return doador;
	}

	public void setDoador(List<Doador> doador) {
		this.doador = doador;
	}

	public List<Ong> getOngs() {
		return ongs;
	}

	public void setOngs(List<Ong> ongs) {
		this.ongs = ongs;
	}
	public List<Fundacoes> getFundacoes() {
		return fundacoes;
	}

	public void setFundacoes(List<Fundacoes> fundacoes) {
		this.fundacoes = fundacoes;
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
		Campanha other = (Campanha) obj;
		return Objects.equals(id, other.id);
	}

}
