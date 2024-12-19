package cz.example.repository;

import cz.example.entity.StudentEntity;
import cz.example.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.parser.Entity;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
}
