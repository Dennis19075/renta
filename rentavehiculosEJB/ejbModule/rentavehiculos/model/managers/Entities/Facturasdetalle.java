package rentavehiculos.model.managers.Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the facturasdetalles database table.
 * 
 */
@Entity
@Table(name="facturasdetalles")
@NamedQuery(name="Facturasdetalle.findAll", query="SELECT f FROM Facturasdetalle f")
public class Facturasdetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idfacturadetalle;

	private float cantidadfde;

	private double preciofde;

	private double totalfde;

	//bi-directional many-to-one association to Factura
	@ManyToOne
	@JoinColumn(name="numfac")
	private Factura factura;

	//bi-directional many-to-one association to Reserva
	@ManyToOne
	@JoinColumn(name="idreservasre")
	private Reserva reserva;

	public Facturasdetalle() {
	}

	public Integer getIdfacturadetalle() {
		return this.idfacturadetalle;
	}

	public void setIdfacturadetalle(Integer idfacturadetalle) {
		this.idfacturadetalle = idfacturadetalle;
	}

	public float getCantidadfde() {
		return this.cantidadfde;
	}

	public void setCantidadfde(float cantidadfde) {
		this.cantidadfde = cantidadfde;
	}

	public double getPreciofde() {
		return this.preciofde;
	}

	public void setPreciofde(double preciofde) {
		this.preciofde = preciofde;
	}

	public double getTotalfde() {
		return this.totalfde;
	}

	public void setTotalfde(double totalfde) {
		this.totalfde = totalfde;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Reserva getReserva() {
		return this.reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}