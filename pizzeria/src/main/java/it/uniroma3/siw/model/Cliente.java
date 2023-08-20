package it.uniroma3.siw.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "CLIENTI")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "nome_cliente")
	@Max(20)
	@Min(2)
	@NotBlank
	private String nome;
	@Column(name = "cognome_cliente")
	@Max(20)
	@Min(2)
	@NotBlank
	private String cognome;
	@NotBlank
	@Column(unique=true)
	private String email;
	
	@Column(unique = true)
	@Max(10)
	@Min(10)
	private String cellulare;
	
	@OneToMany(mappedBy="cliente", fetch = FetchType.LAZY)
	private List<Prenotazione> prenotazioni ;
	
	public Cliente (String nome , String cognome , String email , String cellulare) {
		this.nome= nome ;
		this.cognome=cognome; 
		this.email= email ;
		this.cellulare=cellulare;
		this.prenotazioni= new ArrayList<>();
		
	}
	
    public Cliente () {
		
	}
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCellulare() {
		return cellulare;
	}
	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}


	public List<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}


	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}
	
}
