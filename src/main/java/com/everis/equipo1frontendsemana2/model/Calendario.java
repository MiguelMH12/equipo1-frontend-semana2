package com.everis.equipo1frontendsemana2.model;
// Generated 18/09/2019 12:21:43 PM by Hibernate Tools 5.2.12.Final



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * Calendario generated by hbm2java
 */

public class Calendario implements java.io.Serializable {

	private int id;
	private Curso curso;
	private Date inicio;
	private Date fin;
	private List<Inscripcion> inscripcions = new ArrayList<Inscripcion>(0);

	public Calendario() {
	}

	public Calendario(int id, Curso curso, Date inicio, Date fin) {
		this.id = id;
		this.curso = curso;
		this.inicio = inicio;
		this.fin = fin;
	}

	public Calendario(int id, Curso curso, Date inicio, Date fin, List<Inscripcion> inscripcions) {
		this.id = id;
		this.curso = curso;
		this.inicio = inicio;
		this.fin = fin;
		this.inscripcions = inscripcions;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Date getInicio() {
		return this.inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFin() {
		return this.fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public List<Inscripcion> getInscripcions() {
		return this.inscripcions;
	}

	public void setInscripcions(List<Inscripcion> inscripcions) {
		this.inscripcions = inscripcions;
	}

}
