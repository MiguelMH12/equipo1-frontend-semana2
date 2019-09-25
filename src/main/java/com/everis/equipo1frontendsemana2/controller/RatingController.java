package com.everis.equipo1frontendsemana2.controller;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RateEvent;

////Controlador del lado del frontend  -> jsf
@ManagedBean
public class RatingController {
	private int calificacion;
	
	public void calificar(RateEvent evento) {
		System.out.println("Si estoy calificando: " + calificacion);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Calificacion", "Tu calificacion fue: " +  calificacion);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

}
