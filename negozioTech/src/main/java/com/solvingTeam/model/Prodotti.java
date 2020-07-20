package com.solvingTeam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the prodotti database table.
 * 
 */
@Entity
@NamedQuery(name="Prodotti.findAll", query="SELECT p FROM Prodotti p")
public class Prodotti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_prodotto")
	private int idProdotto;

	private String nome;

	private double prezzo;

	@Column(name="quantita_residua")
	private int quantitaResidua;

	//bi-directional many-to-one association to ProdottiOrdinati
	@OneToMany(mappedBy="prodotti")
	private List<ProdottiOrdinati> prodottiOrdinatis;

	public Prodotti() {
	}

	public int getIdProdotto() {
		return this.idProdotto;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrezzo() {
		return this.prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getQuantitaResidua() {
		return this.quantitaResidua;
	}

	public void setQuantitaResidua(int quantitaResidua) {
		this.quantitaResidua = quantitaResidua;
	}

	public List<ProdottiOrdinati> getProdottiOrdinatis() {
		return this.prodottiOrdinatis;
	}

	public void setProdottiOrdinatis(List<ProdottiOrdinati> prodottiOrdinatis) {
		this.prodottiOrdinatis = prodottiOrdinatis;
	}

	public ProdottiOrdinati addProdottiOrdinati(ProdottiOrdinati prodottiOrdinati) {
		getProdottiOrdinatis().add(prodottiOrdinati);
		prodottiOrdinati.setProdotti(this);

		return prodottiOrdinati;
	}

	public ProdottiOrdinati removeProdottiOrdinati(ProdottiOrdinati prodottiOrdinati) {
		getProdottiOrdinatis().remove(prodottiOrdinati);
		prodottiOrdinati.setProdotti(null);

		return prodottiOrdinati;
	}

}