package cz.example.repository;

import cz.example.entity.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<GradeEntity, Long> {

}
