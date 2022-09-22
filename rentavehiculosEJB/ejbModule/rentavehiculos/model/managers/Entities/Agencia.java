package rentavehiculos.model.managers.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the agencias database table.
 * 
 */
@Entity
@Table(name="agencias")
@NamedQuery(name="Agencia.findAll", query="SELECT a FROM Agencia a")
public class Agencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String idagencia;

	private String ciudadage;

	private String direccionage;

	private String nombreage;

	private String telefonoage;

	//bi-directional many-to-many association to Vehiculo
	@ManyToMany(mappedBy="agencias")
	private List<Vehiculo> vehiculos;

	public Agencia() {
	}

	public String getIdagencia() {
		return this.idagencia;
	}

	public void setIdagencia(String idagencia) {
		this.idagencia = idagencia;
	}

	public String getCiudadage() {
		return this.ciudadage;
	}

	public void setCiudadage(String ciudadage) {
		this.ciudadage = ciudadage;
	}

	public String getDireccionage() {
		return this.direccionage;
	}

	public void setDireccionage(String direccionage) {
		this.direccionage = direccionage;
	}

	public String getNombreage() {
		return this.nombreage;
	}

	public void setNombreage(String nombreage) {
		this.nombreage = nombreage;
	}

	public String getTelefonoage() {
		return this.telefonoage;
	}

	public void setTelefonoage(String telefonoage) {
		this.telefonoage = telefonoage;
	}

	public List<Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

}