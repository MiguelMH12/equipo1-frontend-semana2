package com.everis.equipo1frontendsemana2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;

@ManagedBean  //vincular la vista con codigo java
public class AutoCompleteController {
	String [] lenguajes = {"php", "java", "python", "c sharp", "go", "kotlin", "cobol"};
	//Recibimos un filtro desde que lo introducimos en la caja
	public List<String> completar(String filtro){
		List<String> resultados = new ArrayList<String>();
		for(String lenguaje : lenguajes) {
			if(lenguaje.contains(filtro)) { //Solo muestra las palabras con el filtro que ponemos en la caja
				resultados.add(lenguaje);
			}
		}
		return resultados;
	}
}
