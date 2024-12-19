package cz.example.mapper;

import cz.example.dto.StudentDto;
import cz.example.entity.StudentEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentEntity toEntity(StudentDto source) {
        if ( source == null ) {
            return null;
        }

        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setId( source.getId() );
        studentEntity.setFirstName( source.getFirstName() );
        studentEntity.setLastName( source.getLastName() );
        studentEntity.setDateOfBirth( source.getDateOfBirth() );

        return studentEntity;
    }

    @Override
    public StudentDto toDto(StudentEntity source) {
        if ( source == null ) {
            return null;
        }

        StudentDto studentDto = new StudentDto();

        studentDto.setId( source.getId() );
        studentDto.setFirstName( source.getFirstName() );
        studentDto.setLastName( source.getLastName() );
        studentDto.setDateOfBirth( source.getDateOfBirth() );

        studentDto.setGradeIds( getGradeIds(source) );

        return studentDto;
    }
}
