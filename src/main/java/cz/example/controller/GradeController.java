package cz.example.controller;

import cz.example.dto.GradeDto;
import cz.example.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GradeController {
    @Autowired
    GradeService gradeService;

    @GetMapping("/grades")
    @CrossOrigin
    public List<GradeDto> getAllGrades() {
        return gradeService.getAllGrades();
    }

    @GetMapping("/grades/{gradeId}")
    @CrossOrigin
    public GradeDto getGrade(@PathVariable long gradeId) {
        return gradeService.getGrade(gradeId);
    }

    @PostMapping("/grades")
    @CrossOrigin
    public GradeDto addGrade(GradeDto gradeDto) {
        return gradeService.addGrade(gradeDto);
    }

    @PutMapping("/grades/{gradeId}")
    @CrossOrigin
    public GradeDto editGrade(@PathVariable long gradeId, @RequestBody GradeDto gradeDto) {
        return gradeService.editGrade(gradeDto, gradeId);
    }

    @DeleteMapping("/grades/{gradeId}")
    @CrossOrigin
    public GradeDto deleteGrade(@PathVariable long gradeId) {
        return gradeService.deleteGrade(gradeId);
    }
}