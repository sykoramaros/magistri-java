package cz.example.service;
import cz.example.dto.GradeDto;
import cz.example.entity.GradeEntity;
import cz.example.mapper.GradeMapper;
import cz.example.repository.GradeRepository;
import cz.example.repository.StudentRepository;
import cz.example.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class GradeService {
    @Autowired
    GradeMapper gradeMapper;
    @Autowired
    GradeRepository gradeRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SubjectRepository subjectRepository;

    public List<GradeDto> getAllGrades() {
        List<GradeDto> gradeDtos = new ArrayList<>();
        //        for (GradeEntity gradeEntity : gradeRepository.findAll()) {
        //            gradeDtos.add(gradeMapper.toDto(gradeEntity));
        //        }
        gradeRepository.findAll().stream().forEach(gradeEntity -> gradeDtos.add(gradeMapper.toDto(gradeEntity)));
        return gradeDtos;
    }

    public GradeDto getGrade(long id) {
        return gradeMapper.toDto(gradeRepository.getReferenceById(id));
    }

    public GradeDto addGrade(GradeDto gradeDto) {
        GradeEntity gradeToAdd = gradeMapper.toEntity(gradeDto);
        gradeToAdd.setStudent(studentRepository.getReferenceById(gradeDto.getStudentId()));
        gradeToAdd.setSubject(subjectRepository.getReferenceById(gradeDto.getSubjectId()));
        gradeToAdd.getStudent().getGrades().add(gradeToAdd);
        return gradeMapper.toDto(gradeRepository.save(gradeToAdd));
    }

    public GradeDto editGrade(GradeDto gradeDto, long gradeId) {
        gradeDto.setId(gradeId);
        GradeEntity gradeToEdit = gradeRepository.getReferenceById(gradeId);
        gradeMapper.updateEntity(gradeDto, gradeToEdit);
        gradeToEdit.setSubject(subjectRepository.getReferenceById(gradeDto.getSubjectId()));
        gradeToEdit.setStudent(studentRepository.getReferenceById(gradeDto.getStudentId()));
        return gradeMapper.toDto(gradeRepository.save(gradeToEdit));
    }

    public GradeDto deleteGrade(long gradeId) {
        GradeEntity gradeToRemove = gradeRepository.getReferenceById(gradeId);
        GradeDto deletedGrade = gradeMapper.toDto(gradeToRemove);
        gradeRepository.delete(gradeToRemove);
        return deletedGrade;
    }

}