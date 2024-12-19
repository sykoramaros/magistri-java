package cz.example.entity;

// Importy pro anotace a typy z JPA (Java Persistence API) a Lombok.
import jakarta.persistence.*; // Obsahuje anotace pro práci s databázemi (např. @Entity, @Id, @Column).
import lombok.Getter;       // Automaticky generuje getter metody.
import lombok.Setter;       // Automaticky generuje setter metody.
import java.time.LocalDate; // Importuje třídu LocalDate pro práci s datem.
import java.util.List;

// Označuje tuto třídu jako **entitu** pro JPA (Java Persistence API).
// Každá instance této třídy bude reprezentovat záznam v databázové tabulce.
// `name = "student"` specifikuje název tabulky v databázi.
@Entity(name = "student")

// Anotace z Lomboku, které automaticky vygenerují getter a setter metody
// pro všechny atributy třídy.
@Getter
@Setter
public class StudentEntity {
    // Označuje atribut `id` jako **primární klíč** tabulky.
    @Id

    // Definuje způsob generování hodnoty primárního klíče.
    // `GenerationType.IDENTITY` znamená, že hodnota ID bude automaticky
    // generována databází (např. auto-increment v MySQL).
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Označuje tento atribut jako sloupec v databázové tabulce.
    // Pokud není specifikován název sloupce, použije se název atributu `firstName`.
    @Column
    private String firstName;

    // Další atribut, který je mapován jako sloupec v databázi.
    @Column
    private String lastName;

    // Atribut pro datum narození, který je také mapován jako sloupec.
    // `LocalDate` je moderní typ pro práci s datem bez časové složky.
    @Column
    private LocalDate dateOfBirth;
    @OneToMany
    List<GradeEntity> grades;
}