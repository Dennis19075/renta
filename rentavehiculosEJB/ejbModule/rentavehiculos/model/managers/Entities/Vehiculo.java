package rentavehiculos.model.managers.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the vehiculos database table.
 * 
 */
@Entity
@Table(name="vehiculos")
@NamedQuery(name="Vehiculo.findAll", query="SELECT v FROM Vehiculo v")
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String placaveh;

	private String anomodeloveh;

	private Integer capacidadpersonaseh;

	private String colorveh;

	private Boolean disponibilidadeh;

	private String marcaveh;

	private String modeloveh;

	private BigDecimal preciorentaveh;

	//bi-directional many-to-one association to ControlVehiculo
	@OneToMany(mappedBy="vehiculo")
	private List<ControlVehiculo> controlVehiculos;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="vehiculo")
	private List<Reserva> reservas;

	//bi-directional many-to-many association to Agencia
	@ManyToMany
	@JoinTable(
		name="vehiculosagencia"
		, joinColumns={
			@JoinColumn(name="placaveh")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idagencia")
			}
		)
	private List<Agencia> agencias;

	//bi-directional many-to-one association to TipoVehiculo
	@ManyToOne
	@JoinColumn(name="idtipovehiculoeh")
	private TipoVehiculo tipoVehiculo;

	public Vehiculo() {
	}

	public String getPlacaveh() {
		return this.placaveh;
	}

	public void setPlacaveh(String placaveh) {
		this.placaveh = placaveh;
	}

	public String getAnomodeloveh() {
		return this.anomodeloveh;
	}

	public void setAnomodeloveh(String anomodeloveh) {
		this.anomodeloveh = anomodeloveh;
	}

	public Integer getCapacidadpersonaseh() {
		return this.capacidadpersonaseh;
	}

	public void setCapacidadpersonaseh(Integer capacidadpersonaseh) {
		this.capacidadpersonaseh = capacidadpersonaseh;
	}

	public String getColorveh() {
		return this.colorveh;
	}

	public void setColorveh(String colorveh) {
		this.colorveh = colorveh;
	}

	public Boolean getDisponibilidadeh() {
		return this.disponibilidadeh;
	}

	public void setDisponibilidadeh(Boolean disponibilidadeh) {
		this.disponibilidadeh = disponibilidadeh;
	}

	public String getMarcaveh() {
		return this.marcaveh;
	}

	public void setMarcaveh(String marcaveh) {
		this.marcaveh = marcaveh;
	}

	public String getModeloveh() {
		return this.modeloveh;
	}

	public void setModeloveh(String modeloveh) {
		this.modeloveh = modeloveh;
	}

	public BigDecimal getPreciorentaveh() {
		return this.preciorentaveh;
	}

	public void setPreciorentaveh(BigDecimal preciorentaveh) {
		this.preciorentaveh = preciorentaveh;
	}

	public List<ControlVehiculo> getControlVehiculos() {
		return this.controlVehiculos;
	}

	public void setControlVehiculos(List<ControlVehiculo> controlVehiculos) {
		this.controlVehiculos = controlVehiculos;
	}

	public ControlVehiculo addControlVehiculo(ControlVehiculo controlVehiculo) {
		getControlVehiculos().add(controlVehiculo);
		controlVehiculo.setVehiculo(this);

		return controlVehiculo;
	}

	public ControlVehiculo removeControlVehiculo(ControlVehiculo controlVehiculo) {
		getControlVehiculos().remove(controlVehiculo);
		controlVehiculo.setVehiculo(null);

		return controlVehiculo;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setVehiculo(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setVehiculo(null);

		return reserva;
	}

	public List<Agencia> getAgencias() {
		return this.agencias;
	}

	public void setAgencias(List<Agencia> agencias) {
		this.agencias = agencias;
	}

	public TipoVehiculo getTipoVehiculo() {
		return this.tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

}