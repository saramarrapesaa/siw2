package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;

@Entity
@Table(name= "PRENOTAZIONI")
public class Prenotazione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate data;
	
	private LocalTime orario ;
	
	@Column(name= "commensali")
	private int persone_per_prenotazione;
	
	@Max(40)
	@Column(name = "note")
	private String nota;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	public Cliente cliente ;
	
	@ManyToMany
	@JoinTable( joinColumns = {@JoinColumn(name = "prenotazioni_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "tavolo_id", nullable = false, updatable = false)})
	private List <Tavolo> tavoli;
	
	public Prenotazione (Cliente cliente ,LocalDate data , LocalTime ora , int numero_persone , String nota ) {
		this.cliente=cliente ; 
		this.orario=ora;
		this.data=data;
		this.persone_per_prenotazione=numero_persone;
		this.nota=nota;
		
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getOrario() {
		return orario;
	}

	public void setOrario(LocalTime orario) {
		this.orario = orario;
	}

	public int getPersone_per_prenotazione() {
		return persone_per_prenotazione;
	}

	public void setPersone_per_prenotazione(int persone_per_prenotazione) {
		this.persone_per_prenotazione = persone_per_prenotazione;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public Cliente getClienti() {
		return cliente;
	}

	public void setClienti(Cliente clienti) {
		this.cliente = clienti;
	}

	public List<Tavolo> getTavoli() {
		return tavoli;
	}

	public void setTavoli(List<Tavolo> tavoli) {
		this.tavoli = tavoli;
	}
	

}
