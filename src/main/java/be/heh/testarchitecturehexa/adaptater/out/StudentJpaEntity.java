package be.heh.testarchitecturehexa.adaptater.out;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@Table(name = "students")
public class StudentJpaEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_student")
    private Long idStudent;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date_anniversaire")
    private LocalDate dateAnniversaire;
}