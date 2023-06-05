package fr.aelion.streamer.controllers;

import fr.aelion.streamer.dto.AddStudentDto;
import fr.aelion.streamer.dto.SimpleStudentDto;
import fr.aelion.streamer.dto.SimpleStudentProjection;
import fr.aelion.streamer.entities.Student;
import fr.aelion.streamer.services.StudentService;
import fr.aelion.streamer.services.exceptions.EmailAlreadyExistsException;
import fr.aelion.streamer.services.exceptions.LoginAlreadyExistsException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@RestController
@RequestMapping("api/v1/students") //http://127.0.0.1:8080/api/v1/students
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    @CrossOrigin
    public List<Student> findAll() {

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

    @GetMapping("{id}") // Get http://127.0.0.1:5000/api/v1/students/1
    @CrossOrigin
    public ResponseEntity<?> findOne(@PathVariable int id) {
        try {
            return ResponseEntity.ok(studentService.findOne(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("simple")
    @CrossOrigin
    public List<SimpleStudentProjection> findSimpleStudents() {
        return studentService.fromProjection();
    }

    @CrossOrigin
    @GetMapping("dto")
    public List<SimpleStudentDto> simpleStudentDtos() {
        return studentService.findSimpleStudents();
    }

    /**
     * POST a new student
     * uri : POST http://127.0.0.1:5000/api/v1/students
     *
     * @param student
     * @return
     */
    @PostMapping
    @CrossOrigin
    public ResponseEntity<?> add(@Valid @RequestBody AddStudentDto student) {
        try {
            Student newStudent = studentService.add(student);
            return ResponseEntity.created(null).body(newStudent);
        } catch (EmailAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.reject());
        } catch (LoginAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body((e.reject()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping
    @CrossOrigin
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> update(@RequestBody Student student) {
        try {
            studentService.update(student);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    @CrossOrigin
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> singleDelete(@PathVariable int id) {
        try {
            studentService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping()
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> multipleDelete(@RequestBody Set<Integer> ids) {
        return ResponseEntity.ok(studentService.multipleDelete(ids));
    }
}