package cz.example.controller;

import cz.example.dto.SubjectDto;
import cz.example.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @GetMapping("/subjects")
    @CrossOrigin
    public List<SubjectDto> getSubjects() {
        return subjectService.getSubjects();
    }

    @PostMapping("/subjects")
    @CrossOrigin
    public SubjectDto addSubject(@RequestBody SubjectDto subjectDto) {
        return subjectService.addSubject(subjectDto);
    }   // RequestBody je ve swaggeru

    @PutMapping("/subjects/{subjectId}")
    @CrossOrigin
    public SubjectDto editedSubject(@PathVariable int subjectId, @RequestBody SubjectDto subjectDto) {
        return subjectService.editSubject(subjectId, subjectDto);
    }

    @DeleteMapping("/subjects/{subjectId}")
    @CrossOrigin
    public SubjectDto deleteSubject(@PathVariable int subjectId) {
        return subjectService.deleteSubject(subjectId);
    }
}
