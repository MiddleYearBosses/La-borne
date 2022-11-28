package be.heh.testarchitecturehexa.adaptater.out;

import be.heh.testarchitecturehexa.model.Student;
import be.heh.testarchitecturehexa.port.in.StudentListUseCase;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class StudentPersistenceAdapter implements StudentListUseCase {

    private final StudentRepository studentRepository;
    private List<Student> students;

    private final StudentMapper studentMapper;

    @Override
    public List<Student> getStudentList() {
        List<StudentJpaEntity> studentEntity = studentRepository.findAll();
        return studentMapper.mapToDomainEntity(studentEntity);
    }
}
