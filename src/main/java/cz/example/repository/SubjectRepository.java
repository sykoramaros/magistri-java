package cz.example.repository;

import cz.example.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Integer> {
    Optional<SubjectEntity> findByName (String name);
}
