package com.doacao.projeto.doacao.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
@Entity
public class HistoricoDoacao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String dataDoacao;
	private String valorDoacao;
	private String beneficiado;
	
	@OneToOne
	@MapsId
	private Doacao doacao;
	
	public HistoricoDoacao() {

	}

	

	public HistoricoDoacao(Integer id, String dataDoacao, String valorDoacao, String beneficiado, Doacao doacao) {
		super();
		this.id = id;
		this.dataDoacao = dataDoacao;
		this.valorDoacao = valorDoacao;
		this.beneficiado = beneficiado;
		this.doacao = doacao;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDataDoacao() {
		return dataDoacao;
	}

	public void setDataDoacao(String dataDoacao) {
		this.dataDoacao = dataDoacao;
	}

	public String getValorDoacao() {
		return valorDoacao;
	}

	public void setValorDoacao(String valorDoacao) {
		this.valorDoacao = valorDoacao;
	}

	public String getBeneficiado() {
		return beneficiado;
	}

	public void setBeneficiado(String beneficiado) {
		this.beneficiado = beneficiado;
	}

	public Doacao getDoacao() {
		return doacao;
	}

	public void setDoacao(Doacao doacao) {
		this.doacao = doacao;
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
		HistoricoDoacao other = (HistoricoDoacao) obj;
		return Objects.equals(id, other.id);
	}
	
}
