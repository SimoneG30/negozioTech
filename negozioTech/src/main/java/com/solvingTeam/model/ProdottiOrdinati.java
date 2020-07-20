package com.solvingTeam.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the prodotti_ordinati database table.
 * 
 */
@Entity
@Table(name="prodotti_ordinati")
@NamedQuery(name="ProdottiOrdinati.findAll", query="SELECT p FROM ProdottiOrdinati p")
public class ProdottiOrdinati implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_prodotti_ordinati")
	private int idProdottiOrdinati;

	private int quantita;

	//bi-directional many-to-one association to Ordini
	@ManyToOne
	@JoinColumn(name="id_ordine")
	private Ordini ordini;

	//bi-directional many-to-one association to Prodotti
	@ManyToOne
	@JoinColumn(name="id_prodotto")
	private Prodotti prodotti;

	public ProdottiOrdinati() {
	}

	public int getIdProdottiOrdinati() {
		return this.idProdottiOrdinati;
	}

	public void setIdProdottiOrdinati(int idProdottiOrdinati) {
		this.idProdottiOrdinati = idProdottiOrdinati;
	}

	public int getQuantita() {
		return this.quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public Ordini getOrdini() {
		return this.ordini;
	}

	public void setOrdini(Ordini ordini) {
		this.ordini = ordini;
	}

	public Prodotti getProdotti() {
		return this.prodotti;
	}

	public void setProdotti(Prodotti prodotti) {
		this.prodotti = prodotti;
	}

}