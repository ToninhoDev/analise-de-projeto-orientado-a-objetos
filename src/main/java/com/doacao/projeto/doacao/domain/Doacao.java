package com.doacao.projeto.doacao.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Doacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String beneficiario;
	private Double valor;
	private String formaDePagamento;
	
	@JsonIgnore
	@OneToOne(mappedBy = "doacao", cascade = CascadeType.ALL)
	private HistoricoDoacao hitoricoDoacao;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "doacoes")
	private List<Doador> doadores = new ArrayList<>();

	public Doacao() {

	}

	public Doacao(Integer id, String beneficiario, String formaDePagamento, Double valor) {

		this.id = id;
		this.beneficiario = beneficiario;
		this.formaDePagamento = formaDePagamento;
		this.valor = valor;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public HistoricoDoacao getHitoricoDoacao() {
		return hitoricoDoacao;
	}

	public void setHitoricoDoacao(HistoricoDoacao hitoricoDoacao) {
		this.hitoricoDoacao = hitoricoDoacao;
	}

	public List<Doador> getDoadores() {
		return doadores;
	}

	public void setDoadores(List<Doador> doadores) {
		this.doadores = doadores;
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
		Doacao other = (Doacao) obj;
		return Objects.equals(id, other.id);
	}

}
