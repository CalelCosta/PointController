package br.com.dio.pointcontrol.service;


import br.com.dio.pointcontrol.model.Movement;
import br.com.dio.pointcontrol.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovementService {

    MovementRepository movementRepository;

    @Autowired
    public MovementService(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public Movement save(Movement movement) {
        return movementRepository.save(movement);
    }

    public List<Movement> findAll() {
        return movementRepository.findAll();
    }

    public Optional<Movement> findById(Long idMovement) {
        return movementRepository.findById(idMovement);
    }

    public Movement updateMovement(Movement movement) {
        return movementRepository.save(movement);
    }

    public void deleteMovement(Long idMovement) {
        movementRepository.deleteById(idMovement);
    }
}
