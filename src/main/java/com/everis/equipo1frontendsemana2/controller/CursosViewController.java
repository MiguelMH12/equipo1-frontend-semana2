package com.everis.equipo1frontendsemana2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.everis.equipo1frontendsemana2.model.Curso;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//Controlador del lado de la vista, diferente al del backend
@ManagedBean
public class CursosViewController {
	private String url = "http://localhost:9999/rest/curso/";
	private List<Curso> cursos = new ArrayList<Curso>();
	
	private List<Curso> cursosFiltrados = new ArrayList<Curso>();
	//Resteasy peticiones HTTP GET, POST, PUT, DELETE
	ResteasyClient cliente = new ResteasyClientBuilder().build();
	
	private String nombre;
	private String descripcion;
	
	//en cuanto cargue la pagina inicia la lista de cursos
	@PostConstruct
	public void init() throws Exception {
		consultar();
	}
	
	private void consultar() throws Exception, JsonMappingException, IOException {
		ResteasyWebTarget target = cliente.target(UriBuilder.fromPath(url));
		Response response = target.request().get();
		String jsonRespuesta = response.readEntity(String.class);
		ObjectMapper mapper = new ObjectMapper();
		cursos =  mapper.readValue(jsonRespuesta, new TypeReference<List<Curso>>() {});
		cursosFiltrados = cursos;
	}
	
	public void guardar() throws Exception {
		//Invocamos lo que el usuario capturó
		Curso cursoNuevo = new Curso();
		cursoNuevo.setNombrecurso(nombre);
		cursoNuevo.setDescripcion(descripcion);
		
		//Convertimos a JSON
		ObjectMapper mapper = new ObjectMapper();
		String jsonCursoNuevo = mapper.writeValueAsString(cursoNuevo);
		ResteasyWebTarget target = cliente.target(UriBuilder.fromPath(url));
		Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.json(jsonCursoNuevo));
		//Nos regresa un json
		String jsonRespuesta = response.readEntity(String.class);
		Curso cursoInsertado = mapper.readValue(jsonRespuesta, Curso.class);
		String mensaje = "";
		if(cursoInsertado.getId() > 0) {
			mensaje = "Curso insertado con id: "+ cursoInsertado.getId();
			consultar();
		}else {
			mensaje = "Error al insertar el curso, intente más tarde";
		}
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Guardar Curso", mensaje);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public List<Curso> getCursosFiltrados() {
		return cursosFiltrados;
	}

	public void setCursosFiltrados(List<Curso> cursosFiltrados) {
		this.cursosFiltrados = cursosFiltrados;
	}



	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
}
