package com.solvingTeam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ordini database table.
 * 
 */
@Entity
@NamedQuery(name="Ordini.findAll", query="SELECT o FROM Ordini o")
public class Ordini implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ordine")
	private int idOrdine;

	@Temporal(TemporalType.DATE)
	private Date data;

	private double totale;

	//bi-directional many-to-one association to Clienti
	@ManyToOne
	@JoinColumn(name="id_cliente")
	private Clienti clienti;

	//bi-directional many-to-one association to ProdottiOrdinati
	@OneToMany(mappedBy="ordini")
	private List<ProdottiOrdinati> prodottiOrdinatis;

	public Ordini() {
	}

	public int getIdOrdine() {
		return this.idOrdine;
	}

	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getTotale() {
		return this.totale;
	}

	public void setTotale(double totale) {
		this.totale = totale;
	}

	public Clienti getClienti() {
		return this.clienti;
	}

	public void setClienti(Clienti clienti) {
		this.clienti = clienti;
	}

	public List<ProdottiOrdinati> getProdottiOrdinatis() {
		return this.prodottiOrdinatis;
	}

	public void setProdottiOrdinatis(List<ProdottiOrdinati> prodottiOrdinatis) {
		this.prodottiOrdinatis = prodottiOrdinatis;
	}

	public ProdottiOrdinati addProdottiOrdinati(ProdottiOrdinati prodottiOrdinati) {
		getProdottiOrdinatis().add(prodottiOrdinati);
		prodottiOrdinati.setOrdini(this);

		return prodottiOrdinati;
	}

	public ProdottiOrdinati removeProdottiOrdinati(ProdottiOrdinati prodottiOrdinati) {
		getProdottiOrdinatis().remove(prodottiOrdinati);
		prodottiOrdinati.setOrdini(null);

		return prodottiOrdinati;
	}

}