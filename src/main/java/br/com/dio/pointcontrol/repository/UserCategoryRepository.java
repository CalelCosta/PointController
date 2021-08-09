package br.com.dio.pointcontrol.repository;

import br.com.dio.pointcontrol.model.UserCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserCategoryRepository extends JpaRepository<UserCategory, Long> {
}
