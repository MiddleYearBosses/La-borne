package be.heh.testarchitecturehexa;

import be.heh.testarchitecturehexa.adaptater.out.StudentMapper;
import be.heh.testarchitecturehexa.adaptater.out.StudentPersistenceAdapter;
import be.heh.testarchitecturehexa.adaptater.out.StudentRepository;
import be.heh.testarchitecturehexa.port.in.StudentListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@org.springframework.context.annotation.Configuration
@EnableJpaRepositories
public class Configuration {
        @Autowired
        private StudentRepository studentRepository;

        private StudentMapper studentMapper = new StudentMapper();

        @Bean
        StudentListUseCase getStudentListUseCase(){

            return new StudentPersistenceAdapter(studentRepository,studentMapper);
        }

}
