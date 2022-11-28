package be.heh.testarchitecturehexa.adaptater.in;

import be.heh.testarchitecturehexa.model.Student;
import be.heh.testarchitecturehexa.port.in.StudentListUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentListUseCase studentListUseCase;
    private List<Student> students;

    @GetMapping("/")
    public String studentList(Model model){
        students = studentListUseCase.getStudentList();
        model.addAttribute("students",students);
        return "studentList";
    }
}
