package cz.example.mapper;

import cz.example.dto.GradeDto;
import cz.example.entity.GradeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {StudentMapper.class, SubjectMapper.class})
public interface GradeMapper {
    GradeEntity toEntity(GradeDto source);
    @Mapping(target = "subjectId", source = "subject.id")
    @Mapping(target = "studentId", source = "student.id")

    GradeDto toDto(GradeEntity source);
    GradeEntity updateEntity(GradeDto source, @MappingTarget GradeEntity target);
}
