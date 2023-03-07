package fr.aelion.streamer.controllers;

import fr.aelion.streamer.entities.Student;
import fr.aelion.streamer.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/students") //http://127.0.0.1:8080/api/v1/students
public class StudentController {

    @Autowired
    private StudentService studentService;

@GetMapping
@CrossOrigin
    public List<Student> findAll(){

    /*List<Student> students = new ArrayList<>();
    Student student = new Student();
    student.setId(1);
    student.setLastName("Aubert");
    student.setFirstname("Jean-Luc");
    student.setEmail("jl@aelion.fr");
    student.setPhoneNumber("06 11 45 78 96");
    student.setLogin("jlaubert");
    student.setPassword("jla");
    students.add(student);*/
    return studentService.findAll();
}
}
