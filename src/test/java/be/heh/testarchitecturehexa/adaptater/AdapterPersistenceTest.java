package be.heh.testarchitecturehexa.adaptater;

import be.heh.testarchitecturehexa.adaptater.out.StudentMapper;
import be.heh.testarchitecturehexa.adaptater.out.StudentPersistenceAdapter;
import be.heh.testarchitecturehexa.adaptater.out.StudentRepository;
import be.heh.testarchitecturehexa.model.Student;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Testcontainers
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class AdapterPersistenceTest extends AbstractIntegrationTest{

    @Autowired
    private StudentRepository studentRepository;
    private  StudentMapper studentMapper;

    private StudentPersistenceAdapter studentPersistenceAdapter;

    @Test
    @Sql({"createStudentTable.sql","dataStudent.sql"})
    void getStudentsList(){
        studentMapper = new StudentMapper();
        studentPersistenceAdapter = new StudentPersistenceAdapter(studentRepository,studentMapper);

        List<Student> students;

        students = studentPersistenceAdapter.getStudentList();


        assertEquals("tata1",students.get(1).getNom());
        assertEquals("tutu1",students.get(1).getPrenom());
        assertEquals(2000,students.get(1).getDateAnniversaire().getYear());
    }
}
