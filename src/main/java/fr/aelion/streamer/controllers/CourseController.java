package fr.aelion.streamer.controllers;

import fr.aelion.streamer.dto.AddCourseDto;
import fr.aelion.streamer.dto.AddStudentDto;
import fr.aelion.streamer.dto.FullCourseDto;

import fr.aelion.streamer.entities.Course;
import fr.aelion.streamer.entities.Student;
import fr.aelion.streamer.services.CourseService;
import fr.aelion.streamer.services.exceptions.EmailAlreadyExistsException;
import fr.aelion.streamer.services.exceptions.LoginAlreadyExistsException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/v1/course")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping
    @CrossOrigin
    public List<FullCourseDto> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}") // Get http://127.0.0.1:5000/api/v1/students/1
    @CrossOrigin
    public ResponseEntity<?> findOne(@PathVariable int id) {
        try {
            return ResponseEntity.ok(service.findOne(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @CrossOrigin
    public ResponseEntity<?> add(@RequestBody AddCourseDto course) {
        FullCourseDto courseDto = this.service.add(course);
        return ResponseEntity.ok(courseDto);
    }

    @DeleteMapping("/{id}")
    @CrossOrigin
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> singleDelete(@PathVariable int id) {
        try {
            service.remove(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
