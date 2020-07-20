package com.solvingTeam.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clienti database table.
 * 
 */
@Entity
@NamedQuery(name="Clienti.findAll", query="SELECT c FROM Clienti c")
public class Clienti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private int idCliente;

	private String cognome;

	private String nome;

	//bi-directional many-to-one association to Ordini
	@OneToMany(mappedBy="clienti")
	private List<Ordini> ordinis;

	public Clienti() {
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Ordini> getOrdinis() {
		return this.ordinis;
	}

	public void setOrdinis(List<Ordini> ordinis) {
		this.ordinis = ordinis;
	}

	public Ordini addOrdini(Ordini ordini) {
		getOrdinis().add(ordini);
		ordini.setClienti(this);

		return ordini;
	}

	public Ordini removeOrdini(Ordini ordini) {
		getOrdinis().remove(ordini);
		ordini.setClienti(null);

		return ordini;
	}

}