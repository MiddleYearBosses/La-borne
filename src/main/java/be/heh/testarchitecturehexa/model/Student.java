package be.heh.testarchitecturehexa.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public class Student {

    @Getter
    private final String nom;
    @Getter
    private final String prenom;
    @Getter
    private final LocalDate dateAnniversaire;

    public int getAge() {
        int age = LocalDate.now().getYear() - dateAnniversaire.getYear();
        return age ;
    }

}
