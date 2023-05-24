package br.com.fiap.check3.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Veterinario {
	
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long idEspecialidade;
	
	private String nome;
	
	private String crv;
	
	private Long idDia;
	
	private int horarioInicio;
	
	private int horarioFinal;

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


	public Long getIdEspecialidade() {
		return idEspecialidade;
	}

	public void setIdEspecialidade(Long idEspecialidade) {
		this.idEspecialidade = idEspecialidade;
	}

	public String getCrv() {
		return crv;
	}

	public void setCrv(String crv) {
		this.crv = crv;
	}


	public Long getIdDia() {
		return idDia;
	}

	public void setIdDia(Long idDia) {
		this.idDia = idDia;
	}

	public int getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(int horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public int getHorarioFinal() {
		return horarioFinal;
	}

	public void setHorarioFinal(int horarioFinal) {
		this.horarioFinal = horarioFinal;
	}
}
