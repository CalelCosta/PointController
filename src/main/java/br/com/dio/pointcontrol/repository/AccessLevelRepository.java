package br.com.dio.pointcontrol.repository;

import br.com.dio.pointcontrol.model.AccessLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessLevelRepository extends JpaRepository<AccessLevel, Long> {
}
