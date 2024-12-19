package cz.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "grade")
@Getter
@Setter
public class GradeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne  // hodne znamek k jednomu zakovi
    private StudentEntity student;  // povazani s entitou a ne s DTOckem
    @ManyToOne  // hodne znamek k jednomu predmetu
    private SubjectEntity subject;
    private int mark;
    private String topic;


}
