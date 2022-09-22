package rentavehiculos.model.managers.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_vehiculos database table.
 * 
 */
@Entity
@Table(name="tipo_vehiculos")
@NamedQuery(name="TipoVehiculo.findAll", query="SELECT t FROM TipoVehiculo t")
public class TipoVehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idtipovehiculoeh;

	private Boolean tipocamionetaveh;

	private Boolean tipoconvertibleeh;

	@Column(name="tipocoupe_")
	private Boolean tipocoupe;

	private Boolean tipojeepveh;

	private Boolean tipolimusinaeh;

	private Boolean tiposedaneh;

	private Boolean tipovaneh;

	//bi-directional many-to-one association to Vehiculo
	@OneToMany(mappedBy="tipoVehiculo")
	private List<Vehiculo> vehiculos;

	public TipoVehiculo() {
	}

	public Integer getIdtipovehiculoeh() {
		return this.idtipovehiculoeh;
	}

	public void setIdtipovehiculoeh(Integer idtipovehiculoeh) {
		this.idtipovehiculoeh = idtipovehiculoeh;
	}

	public Boolean getTipocamionetaveh() {
		return this.tipocamionetaveh;
	}

	public void setTipocamionetaveh(Boolean tipocamionetaveh) {
		this.tipocamionetaveh = tipocamionetaveh;
	}

	public Boolean getTipoconvertibleeh() {
		return this.tipoconvertibleeh;
	}

	public void setTipoconvertibleeh(Boolean tipoconvertibleeh) {
		this.tipoconvertibleeh = tipoconvertibleeh;
	}

	public Boolean getTipocoupe() {
		return this.tipocoupe;
	}

	public void setTipocoupe(Boolean tipocoupe) {
		this.tipocoupe = tipocoupe;
	}

	public Boolean getTipojeepveh() {
		return this.tipojeepveh;
	}

	public void setTipojeepveh(Boolean tipojeepveh) {
		this.tipojeepveh = tipojeepveh;
	}

	public Boolean getTipolimusinaeh() {
		return this.tipolimusinaeh;
	}

	public void setTipolimusinaeh(Boolean tipolimusinaeh) {
		this.tipolimusinaeh = tipolimusinaeh;
	}

	public Boolean getTiposedaneh() {
		return this.tiposedaneh;
	}

	public void setTiposedaneh(Boolean tiposedaneh) {
		this.tiposedaneh = tiposedaneh;
	}

	public Boolean getTipovaneh() {
		return this.tipovaneh;
	}

	public void setTipovaneh(Boolean tipovaneh) {
		this.tipovaneh = tipovaneh;
	}

	public List<Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Vehiculo addVehiculo(Vehiculo vehiculo) {
		getVehiculos().add(vehiculo);
		vehiculo.setTipoVehiculo(this);

		return vehiculo;
	}

	public Vehiculo removeVehiculo(Vehiculo vehiculo) {
		getVehiculos().remove(vehiculo);
		vehiculo.setTipoVehiculo(null);

		return vehiculo;
	}

}