package minimarketdemo.controller.seguridades;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import rentavehiculos.model.managers.ManagerReserva;
import rentavehiculos.model.managers.Entities.Reserva;

@Named
@SessionScoped
public class BeanReserva implements Serializable {
	
	@EJB
	private ManagerReserva mReserva;
	private List<Reserva> listaReserva;
	
	public BeanReserva() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void Inicializacion() {
		this.cargarReserva();
	}
	
	public void cargarReserva() {
		listaReserva = mReserva.findAllReserva();
	}

	public List<Reserva> getListaReserva() {
		return listaReserva;
	}

	public void setListaReserva(List<Reserva> listaReserva) {
		this.listaReserva = listaReserva;
	}
	
	

}
