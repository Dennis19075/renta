package rentavehiculos.model.managers.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the facturas database table.
 * 
 */
@Entity
@Table(name="facturas")
@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String numfac;

	private double descuentofac;

	@Temporal(TemporalType.DATE)
	private Date fechafac;

	private double ivafac;

	private double subtotalfac;

	private double tarifa0fac;

	private double tarifa12fac;

	private double totalfac;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="cedulacli")
	private Cliente cliente;

	//bi-directional many-to-one association to Facturasdetalle
	@OneToMany(mappedBy="factura")
	private List<Facturasdetalle> facturasdetalles;

	public Factura() {
	}

	public String getNumfac() {
		return this.numfac;
	}

	public void setNumfac(String numfac) {
		this.numfac = numfac;
	}

	public double getDescuentofac() {
		return this.descuentofac;
	}

	public void setDescuentofac(double descuentofac) {
		this.descuentofac = descuentofac;
	}

	public Date getFechafac() {
		return this.fechafac;
	}

	public void setFechafac(Date fechafac) {
		this.fechafac = fechafac;
	}

	public double getIvafac() {
		return this.ivafac;
	}

	public void setIvafac(double ivafac) {
		this.ivafac = ivafac;
	}

	public double getSubtotalfac() {
		return this.subtotalfac;
	}

	public void setSubtotalfac(double subtotalfac) {
		this.subtotalfac = subtotalfac;
	}

	public double getTarifa0fac() {
		return this.tarifa0fac;
	}

	public void setTarifa0fac(double tarifa0fac) {
		this.tarifa0fac = tarifa0fac;
	}

	public double getTarifa12fac() {
		return this.tarifa12fac;
	}

	public void setTarifa12fac(double tarifa12fac) {
		this.tarifa12fac = tarifa12fac;
	}

	public double getTotalfac() {
		return this.totalfac;
	}

	public void setTotalfac(double totalfac) {
		this.totalfac = totalfac;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Facturasdetalle> getFacturasdetalles() {
		return this.facturasdetalles;
	}

	public void setFacturasdetalles(List<Facturasdetalle> facturasdetalles) {
		this.facturasdetalles = facturasdetalles;
	}

	public Facturasdetalle addFacturasdetalle(Facturasdetalle facturasdetalle) {
		getFacturasdetalles().add(facturasdetalle);
		facturasdetalle.setFactura(this);

		return facturasdetalle;
	}

	public Facturasdetalle removeFacturasdetalle(Facturasdetalle facturasdetalle) {
		getFacturasdetalles().remove(facturasdetalle);
		facturasdetalle.setFactura(null);

		return facturasdetalle;
	}

}