package be.heh.testarchitecturehexa;

import be.heh.testarchitecturehexa.adaptater.out.StudentMapper;
import be.heh.testarchitecturehexa.adaptater.out.StudentPersistenceAdapter;
import be.heh.testarchitecturehexa.adaptater.out.StudentRepository;
import be.heh.testarchitecturehexa.port.in.StudentListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestArchitectureHexaApplication {


    public static void main(String[] args) {
        SpringApplication.run(TestArchitectureHexaApplication.class, args);
    }

}
