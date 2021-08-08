package br.com.dio.pointcontrol.repository;

import br.com.dio.pointcontrol.model.WorkingDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkingRepository extends JpaRepository<WorkingDay, Long> {
}
