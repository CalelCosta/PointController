package br.com.dio.pointcontrol.repository;

import br.com.dio.pointcontrol.model.DataType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DataTypeRepository extends JpaRepository<DataType, Long> {
}
