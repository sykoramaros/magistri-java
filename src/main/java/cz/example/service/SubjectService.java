package cz.example.service;

import cz.example.dto.SubjectDto;
import cz.example.entity.SubjectEntity;
import cz.example.mapper.SubjectMapper;
import cz.example.repository.SubjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {
    @Autowired
    SubjectMapper subjectMapper;

    @Autowired
    SubjectRepository subjectRepository;

    public List<SubjectDto> getSubjects() {
        List<SubjectEntity> subjectEntities = subjectRepository.findAll();
        List<SubjectDto> subjectDtos = new ArrayList<>();
        for(SubjectEntity subjectEntity : subjectEntities) {
            subjectDtos.add(subjectMapper.toDto(subjectEntity));
        }
        return subjectDtos;
    }
    public SubjectDto addSubject(SubjectDto subjectDto) {
        SubjectEntity subjectEntity = subjectMapper.toEntity(subjectDto);
        SubjectEntity savedEntity = subjectRepository.save(subjectEntity);
        return subjectMapper.toDto(savedEntity);
    }

    public SubjectDto editSubject(int subjectId, SubjectDto editedSubject) {
        if (!subjectRepository.existsById(subjectId)) {
            throw new EntityNotFoundException("Subject with id: " + subjectId + " does not exist");
        }
        SubjectEntity subjectEntity = subjectMapper.toEntity(editedSubject);
        subjectEntity.setId(subjectId);
        SubjectEntity savedSubject = subjectRepository.save(subjectEntity);
        return subjectMapper.toDto(savedSubject);
    }

    public SubjectDto deleteSubject(int subjectId) {
        SubjectEntity subjectEntity = subjectRepository.findById(subjectId).orElseThrow(EntityNotFoundException::new);
        SubjectDto deletedSubject = subjectMapper.toDto(subjectEntity);
        subjectRepository.delete(subjectEntity);
        return deletedSubject;
    }
}
