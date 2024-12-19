package cz.example.service;

import cz.example.dto.StudentDto;
import cz.example.entity.StudentEntity;
import cz.example.mapper.StudentMapper;
import cz.example.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    StudentRepository studentRepository;

    //    nebo @Autowired injection pres konstruktor
    public List<StudentDto> getStudents() {
        List<StudentEntity> studentEntities = studentRepository.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        for (StudentEntity studentEntity : studentEntities) {

            //        VARIANTA NA DVA RADKY
            //        StudentDto studentDto = studentMapper.toDto(studentEntity);
            //        studentDtos.add(studentDto);

            //        VARIANTA NA JEDEN RADEK
            studentDtos.add(studentMapper.toDto(studentEntity));
        }
        return studentDtos;
    }
    public StudentDto addStudent(StudentDto studentDto) {
        StudentEntity studentEntity = studentMapper.toEntity(studentDto);
        StudentEntity savedEntity = studentRepository.save(studentEntity);
        return studentMapper.toDto(savedEntity);
    }

    public StudentDto editStudent(int studentId, StudentDto editedStudent) {
        if (!studentRepository.existsById(studentId)) {     // musi se zkontrolovat a POKUD SE NENAJDE STUDENT S ID TAK SE VYHODI VYJIMKA
            throw new EntityNotFoundException("Student with id " + studentId + " does not exist");
        }
        StudentEntity studentEntity = studentMapper.toEntity(editedStudent);
        studentEntity.setId(studentId);
        StudentEntity savedStudent = studentRepository.save(studentEntity);
        return studentMapper.toDto(savedStudent);
    }

    public StudentDto deleteStudent(int studentId) {
        StudentEntity studentEntity = studentRepository.findById(studentId).orElseThrow(EntityNotFoundException::new);  // zretezene metody zasebou
        StudentDto deletedStudent = studentMapper.toDto(studentEntity);
        studentRepository.delete(studentEntity);
        return deletedStudent;
    }

}
