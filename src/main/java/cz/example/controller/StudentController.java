package cz.example.controller;

import cz.example.dto.StudentDto;
import cz.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    StudentService studentService;

    //    MAPOVANI DELSI VERZE
    //    @RequestMapping(path = "/students", method = RequestMethod.GET)

    //    MAPOVANI ZKRACENA VERZE
    //  @GetMapping({"/students", "students/"}) // se dvema studenty
    @GetMapping("/students")        // bacha na nechtene mezery, mapping musi byt presne zapsany
    @CrossOrigin
    public List<StudentDto> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/students")
    @CrossOrigin
    public StudentDto addStudent(@RequestBody StudentDto studentDto) {
        return studentService.addStudent(studentDto);
    }

    @PutMapping("/students/{studentId}")
    @CrossOrigin
    public StudentDto editedStudent(@PathVariable int studentId, @RequestBody StudentDto studentDto) {
        return studentService.editStudent(studentId, studentDto);
    }

    @DeleteMapping("/students/{studentId}")
    @CrossOrigin
    public StudentDto deleteStudent(@PathVariable int studentId) {
        return studentService.deleteStudent(studentId);
    }
}