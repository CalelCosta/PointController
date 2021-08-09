package br.com.dio.pointcontrol.repository;

import br.com.dio.pointcontrol.model.Occurrence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OccurrenceRepository extends JpaRepository<Occurrence, Long> {
}
