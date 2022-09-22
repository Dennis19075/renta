package rentavehiculos.model.managers.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the clientes database table.
 * 
 */
@Entity
@Table(name="clientes")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String cedulacli;

	private String apellidoscli;

	private String direccioncli;

	@Temporal(TemporalType.DATE)
	private Date fechanacimientocli;

	private String licenciacli;

	private String nombrescli;

	private String telefonocli;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="cliente")
	private List<Factura> facturas;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="cliente")
	private List<Reserva> reservas;

	public Cliente() {
	}

	public String getCedulacli() {
		return this.cedulacli;
	}

	public void setCedulacli(String cedulacli) {
		this.cedulacli = cedulacli;
	}

	public String getApellidoscli() {
		return this.apellidoscli;
	}

	public void setApellidoscli(String apellidoscli) {
		this.apellidoscli = apellidoscli;
	}

	public String getDireccioncli() {
		return this.direccioncli;
	}

	public void setDireccioncli(String direccioncli) {
		this.direccioncli = direccioncli;
	}

	public Date getFechanacimientocli() {
		return this.fechanacimientocli;
	}

	public void setFechanacimientocli(Date fechanacimientocli) {
		this.fechanacimientocli = fechanacimientocli;
	}

	public String getLicenciacli() {
		return this.licenciacli;
	}

	public void setLicenciacli(String licenciacli) {
		this.licenciacli = licenciacli;
	}

	public String getNombrescli() {
		return this.nombrescli;
	}

	public void setNombrescli(String nombrescli) {
		this.nombrescli = nombrescli;
	}

	public String getTelefonocli() {
		return this.telefonocli;
	}

	public void setTelefonocli(String telefonocli) {
		this.telefonocli = telefonocli;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setCliente(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setCliente(null);

		return factura;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setCliente(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setCliente(null);

		return reserva;
	}

}