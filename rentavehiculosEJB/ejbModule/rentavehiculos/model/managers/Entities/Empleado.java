package rentavehiculos.model.managers.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the empleados database table.
 * 
 */
@Entity
@Table(name="empleados")
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String cedulaemp;

	private String apellidosemp;

	private String direccionemp;

	private String nombresemp;

	private String telefonoemp;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="empleado")
	private List<Reserva> reservas;

	public Empleado() {
	}

	public String getCedulaemp() {
		return this.cedulaemp;
	}

	public void setCedulaemp(String cedulaemp) {
		this.cedulaemp = cedulaemp;
	}

	public String getApellidosemp() {
		return this.apellidosemp;
	}

	public void setApellidosemp(String apellidosemp) {
		this.apellidosemp = apellidosemp;
	}

	public String getDireccionemp() {
		return this.direccionemp;
	}

	public void setDireccionemp(String direccionemp) {
		this.direccionemp = direccionemp;
	}

	public String getNombresemp() {
		return this.nombresemp;
	}

	public void setNombresemp(String nombresemp) {
		this.nombresemp = nombresemp;
	}

	public String getTelefonoemp() {
		return this.telefonoemp;
	}

	public void setTelefonoemp(String telefonoemp) {
		this.telefonoemp = telefonoemp;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setEmpleado(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setEmpleado(null);

		return reserva;
	}

}