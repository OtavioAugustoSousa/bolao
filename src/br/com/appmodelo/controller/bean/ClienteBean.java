package br.com.appmodelo.controller.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.core.env.Environment;

import br.com.appmodelo.model.entity.Cliente;
import br.com.appmodelo.model.service.ClienteService;

@ManagedBean
@SessionScoped
public class ClienteBean {

	@ManagedProperty("#{clienteService}")
	private ClienteService clienteService;

	@ManagedProperty("#{environment}")
	private Environment environment;

	private Cliente cliente;

	private List<Cliente> clientes;

	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public String listar() {
		clientes = clienteService.buscarTodos();
		return "/cliente/clienteList";
	}

	public String prepararInserir() {
		cliente = new Cliente();
		return "/cliente/clienteForm";
	}

	public String prepararEditar() {
		cliente = clienteService.buscarPorId(cliente.getId());
		return "/cliente/clienteForm";
	}

	public String salvar() {
		clienteService.salvar(cliente);
		adicionarMenssagemSalvoSucesso();
		return listar();
	}

	public String excluir() {
		clienteService.excluir(cliente);
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

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
