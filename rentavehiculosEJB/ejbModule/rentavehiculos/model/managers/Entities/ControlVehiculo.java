package rentavehiculos.model.managers.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the control_vehiculo database table.
 * 
 */
@Entity
@Table(name="control_vehiculo")
@NamedQuery(name="ControlVehiculo.findAll", query="SELECT c FROM ControlVehiculo c")
public class ControlVehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idcontrolvehiculocv;

	@Column(name="controlpolicial_")
	private Boolean controlpolicial;

	private String estadofisicocv;

	private BigDecimal kilometrajecv;

	private BigDecimal nivelcombustibleccv;

	private Boolean revisionmultascv;

	//bi-directional many-to-one association to Vehiculo
	@ManyToOne
	@JoinColumn(name="placaveh")
	private Vehiculo vehiculo;

	public ControlVehiculo() {
	}

	public Integer getIdcontrolvehiculocv() {
		return this.idcontrolvehiculocv;
	}

	public void setIdcontrolvehiculocv(Integer idcontrolvehiculocv) {
		this.idcontrolvehiculocv = idcontrolvehiculocv;
	}

	public Boolean getControlpolicial() {
		return this.controlpolicial;
	}

	public void setControlpolicial(Boolean controlpolicial) {
		this.controlpolicial = controlpolicial;
	}

	public String getEstadofisicocv() {
		return this.estadofisicocv;
	}

	public void setEstadofisicocv(String estadofisicocv) {
		this.estadofisicocv = estadofisicocv;
	}

	public BigDecimal getKilometrajecv() {
		return this.kilometrajecv;
	}

	public void setKilometrajecv(BigDecimal kilometrajecv) {
		this.kilometrajecv = kilometrajecv;
	}

	public BigDecimal getNivelcombustibleccv() {
		return this.nivelcombustibleccv;
	}

	public void setNivelcombustibleccv(BigDecimal nivelcombustibleccv) {
		this.nivelcombustibleccv = nivelcombustibleccv;
	}

	public Boolean getRevisionmultascv() {
		return this.revisionmultascv;
	}

	public void setRevisionmultascv(Boolean revisionmultascv) {
		this.revisionmultascv = revisionmultascv;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

}