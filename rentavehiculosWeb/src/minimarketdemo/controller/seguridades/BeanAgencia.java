package minimarketdemo.controller.seguridades;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import rentavehiculos.model.managers.ManagerAgencia;
import rentavehiculos.model.managers.Entities.Agencia;

@Named
@SessionScoped
public class BeanAgencia implements Serializable {
	@EJB
	private ManagerAgencia mAgencia;
	private List<Agencia> listaAgencia;
	private Agencia nuevaAgencia;
	private Agencia editarAgencia;
	private String idAgencia;

	public BeanAgencia() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void Inicializacion() {
		this.cargarAgencia();
		nuevaAgencia = new Agencia();
	}
	
	public void cargarAgencia() {
		listaAgencia = mAgencia.findAllAgencia();
	}
	
	public void crearAgencia() {
		try {
			mAgencia.insertarAgencia(nuevaAgencia);
			nuevaAgencia = new Agencia();
			this.cargarAgencia();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void eliminarAgencia(String idAgencia) {
		try {
			mAgencia.eliminarAgencia(idAgencia);
			this.cargarAgencia();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String SeleccionarEditarAgencia(Agencia agencia) {
		editarAgencia = agencia;
		return "EditarAgencia";
	}
	
	public String actualizarAgencia() {
		try {
			mAgencia.editarAgencia(editarAgencia);
			this.cargarAgencia();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "Agencia";
	}

	public List<Agencia> getListaAgencia() {
		return listaAgencia;
	}

	public void setListaAgencia(List<Agencia> listaAgencia) {
		this.listaAgencia = listaAgencia;
	}

	public Agencia getNuevaAgencia() {
		return nuevaAgencia;
	}

	public void setNuevaAgencia(Agencia nuevaAgencia) {
		this.nuevaAgencia = nuevaAgencia;
	}

	public Agencia getEditarAgencia() {
		return editarAgencia;
	}

	public void setEditarAgencia(Agencia editarAgencia) {
		this.editarAgencia = editarAgencia;
	}

	public String getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(String idAgencia) {
		this.idAgencia = idAgencia;
	}
	
	

}
