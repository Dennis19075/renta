package minimarketdemo.controller.seguridades;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import rentavehiculos.model.managers.ManagerEmpleado;
import rentavehiculos.model.managers.Entities.Empleado;

@Named
@SessionScoped
public class BeanEmpleados implements Serializable {

	public BeanEmpleados() {
		// TODO Auto-generated constructor stub
	}
	
	@EJB
	private ManagerEmpleado mEmpleado;
	private List<Empleado> listaEmpleados;
	
	private Empleado nuevoEmpleado;
	private Empleado editarEmpleado;
	
	@PostConstruct
	public void inicializacion() {
		System.out.println("BeanEmpleados inicializado...");
		this.cargarEmpleados();
		nuevoEmpleado = new Empleado();
		editarEmpleado = new Empleado();
	}

	public void cargarEmpleados() {
		listaEmpleados=mEmpleado.findAllEmpleado();
	}
	
	
	public String actionMenuNuevoEmpleado() {
		nuevoEmpleado=new Empleado();
		return "empleados_nuevo";
	}
	
	public void actionListenerInsertarNuevoEmpleado() {
		try {
//			managerSeguridades.insertarEmpleado(nuevoEmpleado);
			this.cargarEmpleados();
			System.out.println("Usuario insertado.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public Empleado getNuevoEmpleado() {
		return nuevoEmpleado;
	}

	public void setNuevoEmpleado(Empleado nuevoEmpleado) {
		this.nuevoEmpleado = nuevoEmpleado;
	}

	public Empleado getEditarEmpleado() {
		return editarEmpleado;
	}

	public void setEditarEmpleado(Empleado editarEmpleado) {
		this.editarEmpleado = editarEmpleado;
	}
	
	
	
	
}
