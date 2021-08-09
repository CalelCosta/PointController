package br.com.dio.pointcontrol.repository;

import br.com.dio.pointcontrol.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {
}
