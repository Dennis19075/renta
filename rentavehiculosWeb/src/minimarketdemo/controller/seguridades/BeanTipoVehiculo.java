package minimarketdemo.controller.seguridades;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import rentavehiculos.model.managers.ManagerTipoVehiculo;
import rentavehiculos.model.managers.Entities.TipoVehiculo;

@Named
@SessionScoped
public class BeanTipoVehiculo implements Serializable {
	
	@EJB
	private ManagerTipoVehiculo mTipoVehiculo;
	private List<TipoVehiculo> listaTipoVehiculo;

	public BeanTipoVehiculo() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void Inicializacion() {
		this.cargarTipoVehiculo();
	}
	
	public void cargarTipoVehiculo() {
		listaTipoVehiculo = mTipoVehiculo.findAllTipoVehiculo();
	}

	public List<TipoVehiculo> getListaTipoVehiculo() {
		return listaTipoVehiculo;
	}

	public void setListaTipoVehiculo(List<TipoVehiculo> listaTipoVehiculo) {
		this.listaTipoVehiculo = listaTipoVehiculo;
	}

	
	
}
