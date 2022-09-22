package minimarketdemo.controller.seguridades;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import rentavehiculos.model.managers.ManagerTipoVehiculo;
import rentavehiculos.model.managers.ManagerVehiculo;
import rentavehiculos.model.managers.Entities.TipoVehiculo;
import rentavehiculos.model.managers.Entities.Vehiculo;

@Named
@SessionScoped
public class BeanVehiculo implements Serializable {

	@EJB
	private ManagerVehiculo mVehiculo;
	@EJB
	private ManagerTipoVehiculo mTVehiculo;
	private List<Vehiculo> listaVehiculo;
	private Vehiculo nuevoVehiculo;
	private Vehiculo editarVehiculo;
	private int idTipoVehiculo;

	public BeanVehiculo() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void Inicializacion() {
		this.cargarVehiculo();
		nuevoVehiculo = new Vehiculo();
		editarVehiculo = new Vehiculo();
		idTipoVehiculo = 0;
	}

	public void cargarVehiculo() {
		listaVehiculo = mVehiculo.findAllVehiculo();
	}

	public void crearVehiculo() {
		try {
			TipoVehiculo tipoV = mTVehiculo.findByIdTipoVehiculo(idTipoVehiculo);
			nuevoVehiculo.setTipoVehiculo(tipoV);
			System.out.println(nuevoVehiculo.getTipoVehiculo().getIdtipovehiculoeh());
			mVehiculo.insertarVehiculo(nuevoVehiculo);
			nuevoVehiculo = new Vehiculo();
			this.cargarVehiculo();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void eliminarVehiculo(String placa) {
		try {
			mVehiculo.eliminarVehiculo(placa);
			this.cargarVehiculo();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public String SeleccionarEditarVehiculo(Vehiculo vehiculo) {
		editarVehiculo = vehiculo;
		return "EditarVehiculo";
	}

	public String actualizarVehiculo() {
		try {
			mVehiculo.editarVehiculo(editarVehiculo);
			this.cargarVehiculo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Vehiculo";
	}

	public List<Vehiculo> getListaVehiculo() {
		return listaVehiculo;
	}

	public void setListaVehiculo(List<Vehiculo> listaVehiculo) {
		this.listaVehiculo = listaVehiculo;
	}

	public Vehiculo getNuevoVehiculo() {
		return nuevoVehiculo;
	}

	public void setNuevoVehiculo(Vehiculo nuevoVehiculo) {
		this.nuevoVehiculo = nuevoVehiculo;
	}

	public int getIdTipoVehiculo() {
		return idTipoVehiculo;
	}

	public void setIdTipoVehiculo(int idTipoVehiculo) {
		this.idTipoVehiculo = idTipoVehiculo;
	}

	public Vehiculo getEditarVehiculo() {
		return editarVehiculo;
	}

	public void setEditarVehiculo(Vehiculo editarVehiculo) {
		this.editarVehiculo = editarVehiculo;
	}

}
