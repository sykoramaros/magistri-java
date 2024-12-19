package cz.example.mapper;

import cz.example.dto.StudentDto;
import cz.example.entity.GradeEntity;
import cz.example.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

// ALTERNATIVA ZAPISU
//@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentEntity toEntity(StudentDto source);
    @Mapping(target = "gradeIds", expression = "java(getGradeIds(source))")
    StudentDto toDto(StudentEntity source);

    default List<Long> getGradeIds(StudentEntity source) {
        List<Long> gradeIds = new ArrayList<>();
        if (source.getGrades() != null) {
            for (GradeEntity grade : source.getGrades()) {
                gradeIds.add(grade.getId());
            }
        }
        return gradeIds;
    }

}
