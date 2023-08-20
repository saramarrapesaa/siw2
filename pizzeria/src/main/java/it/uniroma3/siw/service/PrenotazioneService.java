package it.uniroma3.siw.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Prenotazione;
import it.uniroma3.siw.repository.PrenotazioneRepository;
import jakarta.transaction.Transactional;

@Service
public class PrenotazioneService {
	
	@Autowired
	private PrenotazioneRepository prenotazioneRepository;
	
	//salva nuova prenotazione
	@Transactional
	public void saveNewPrenotazione(Prenotazione prenotazione) {
		this.prenotazioneRepository.save(prenotazione);
	}
	
	//trova una prenotazione
	public Prenotazione findPrenotazioneById(Long p_id) {
		return this.prenotazioneRepository.findById(p_id).orElse(null);
	}
	
	//trova tutte le prenotazione
	public Iterable<Prenotazione> findAllPrenotazioni(){
		return this.prenotazioneRepository.findAll();
	}
	
	//trova le prenotazioni per data
	public List<Prenotazione> findPrenotazioniByDate(LocalDate data) {
		return this.prenotazioneRepository.findByData(data);
		
	}

}
