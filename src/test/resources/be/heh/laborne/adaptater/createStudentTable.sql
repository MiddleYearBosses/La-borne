CREATE TABLE IF NOT EXISTS students  (
    id_student SERIAL PRIMARY KEY,
    nom varchar(15),
    prenom varchar(15),
    date_anniversaire date
    );