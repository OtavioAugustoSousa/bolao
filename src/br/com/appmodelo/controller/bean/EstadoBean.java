package br.com.appmodelo.controller.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.core.env.Environment;

import br.com.appmodelo.model.entity.Estado;
import br.com.appmodelo.model.service.EstadoService;

@ManagedBean	
@SessionScoped
public class EstadoBean {
	 @ManagedProperty("#{estadoService}")
	 private EstadoService estadoService;
	 
	 @ManagedProperty("#{environment}")
	 private Environment environment;
	 
	private Estado estado;
	
	private List<Estado> estados;
	
	public void setEstadoService(EstadoService estadoService) {
		this.estadoService = estadoService;
	}
	
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	
	public String listar() {
		estados = estadoService.buscarTodos();
		return "/estado/estadoList";
	}
	
	public String prepararInserir() {
		estado = new Estado();
		return "/estado/estadoForm";
	}
	
	public String prepararEditar() {
		estado = estadoService.buscarPorId(estado.getId());
		return "/estado/estadoForm";
	}
	
	public String salvar() {
		estadoService.salvar(estado);
		adicionarMenssagemSalvoSucesso();
		return listar();
	}
	
	public String excluir() {
		estadoService.excluir(estado);
		adicionarMenssagemExcluidoSalvoSucesso();
		return listar();
	}
	
	private void adicionarMenssagemSalvoSucesso() {
		String mensagem = environment.getProperty("messagem.registro.salvo");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(mensagem));
    }
	
	private void adicionarMenssagemExcluidoSalvoSucesso() {
		String mensagem = environment.getProperty("messagem.registro.excluido");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(mensagem));
    }

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
