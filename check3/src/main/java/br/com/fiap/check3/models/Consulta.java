package br.com.fiap.check3.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Consulta {
	@Id //primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long idAnimal;
	private Long idDia;
	private Long idVeterinario;
	private String horario;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(Long idAnimal) {
		this.idAnimal = idAnimal;
	}
	public Long getIdDia() {
		return idDia;
	}
	public void setIdDia(Long idDia) {
		this.idDia = idDia;
	}
	public Long getIdVeterinario() {
		return idVeterinario;
	}
	public void setIdVeterinario(Long idVeterinario) {
		this.idVeterinario = idVeterinario;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
}
