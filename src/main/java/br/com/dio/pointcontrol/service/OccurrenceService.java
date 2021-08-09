package br.com.dio.pointcontrol.service;


import br.com.dio.pointcontrol.model.Occurrence;
import br.com.dio.pointcontrol.repository.OccurrenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OccurrenceService {

    OccurrenceRepository occurrenceRepository;

    @Autowired
    public OccurrenceService(OccurrenceRepository occurrenceRepository) {
        this.occurrenceRepository = occurrenceRepository;
    }

    public Occurrence save(Occurrence occurrence) {
        return occurrenceRepository.save(occurrence);
    }

    public List<Occurrence> findAll() {
        return occurrenceRepository.findAll();
    }

    public Optional<Occurrence> findById(Long idOccurrence) {
        return occurrenceRepository.findById(idOccurrence);
    }

    public Occurrence updateOccurrence(Occurrence occurrence) {
        return occurrenceRepository.save(occurrence);
    }

    public void deleteOccurrence(Long idOccurrence) {
        occurrenceRepository.deleteById(idOccurrence);
    }
}
