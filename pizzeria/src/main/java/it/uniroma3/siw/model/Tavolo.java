package it.uniroma3.siw.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="TAVOLI")
public class Tavolo {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@Column(name="numero_tavolo", unique= true)
	private int numeTavolo;
	
	private int posti;
	
	 @ManyToMany
     @JoinTable(
	            name = "tavoli_prenotati",
	            joinColumns = {@JoinColumn(name = "tavolo_id", nullable = false, updatable = false)},
	            inverseJoinColumns = {@JoinColumn(name="prenotazioni_id", nullable = false, updatable = false)})
	private List<Prenotazione> prenotazioni;
	 
	 public Tavolo(int numTavolo, int posti) {
		 this.numeTavolo= numTavolo;
		 this.posti=posti;
		 this.prenotazioni= new ArrayList<>();
	 }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumeTavolo() {
		return numeTavolo;
	}

	public void setNumeTavolo(int numeTavolo) {
		this.numeTavolo = numeTavolo;
	}

	public int getPosti() {
		return posti;
	}

	public void setPosti(int posti) {
		this.posti = posti;
	}

	public List<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

}