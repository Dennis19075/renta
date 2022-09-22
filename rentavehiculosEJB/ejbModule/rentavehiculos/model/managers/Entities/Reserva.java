package rentavehiculos.model.managers.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the reservas database table.
 * 
 */
@Entity
@Table(name="reservas")
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idreservasre;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_finre")
	private Date fechaFinre;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_iniciore")
	private Date fechaIniciore;

	//bi-directional many-to-one association to Facturasdetalle
	@OneToMany(mappedBy="reserva")
	private List<Facturasdetalle> facturasdetalles;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="cedulacli")
	private Cliente cliente;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="cedulaemp")
	private Empleado empleado;

	//bi-directional many-to-one association to Vehiculo
	@ManyToOne
	@JoinColumn(name="placaveh")
	private Vehiculo vehiculo;

	public Reserva() {
	}

	public Integer getIdreservasre() {
		return this.idreservasre;
	}

	public void setIdreservasre(Integer idreservasre) {
		this.idreservasre = idreservasre;
	}

	public Date getFechaFinre() {
		return this.fechaFinre;
	}

	public void setFechaFinre(Date fechaFinre) {
		this.fechaFinre = fechaFinre;
	}

	public Date getFechaIniciore() {
		return this.fechaIniciore;
	}

	public void setFechaIniciore(Date fechaIniciore) {
		this.fechaIniciore = fechaIniciore;
	}

	public List<Facturasdetalle> getFacturasdetalles() {
		return this.facturasdetalles;
	}

	public void setFacturasdetalles(List<Facturasdetalle> facturasdetalles) {
		this.facturasdetalles = facturasdetalles;
	}

	public Facturasdetalle addFacturasdetalle(Facturasdetalle facturasdetalle) {
		getFacturasdetalles().add(facturasdetalle);
		facturasdetalle.setReserva(this);

		return facturasdetalle;
	}

	public Facturasdetalle removeFacturasdetalle(Facturasdetalle facturasdetalle) {
		getFacturasdetalles().remove(facturasdetalle);
		facturasdetalle.setReserva(null);

		return facturasdetalle;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

}