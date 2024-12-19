package cz.example.mapper;

import cz.example.dto.GradeDto;
import cz.example.entity.GradeEntity;
import cz.example.entity.StudentEntity;
import cz.example.entity.SubjectEntity;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class GradeMapperImpl implements GradeMapper {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public GradeEntity toEntity(GradeDto source) {
        if ( source == null ) {
            return null;
        }

        GradeEntity gradeEntity = new GradeEntity();

        gradeEntity.setId( source.getId() );
        gradeEntity.setStudent( studentMapper.toEntity( source.getStudent() ) );
        gradeEntity.setSubject( subjectMapper.toEntity( source.getSubject() ) );
        gradeEntity.setMark( source.getMark() );
        gradeEntity.setTopic( source.getTopic() );

        return gradeEntity;
    }

    @Override
    public GradeDto toDto(GradeEntity source) {
        if ( source == null ) {
            return null;
        }

        GradeDto gradeDto = new GradeDto();

        gradeDto.setSubjectId( sourceSubjectId( source ) );
        gradeDto.setStudentId( sourceStudentId( source ) );
        gradeDto.setId( source.getId() );
        gradeDto.setStudent( studentMapper.toDto( source.getStudent() ) );
        gradeDto.setSubject( subjectMapper.toDto( source.getSubject() ) );
        gradeDto.setMark( source.getMark() );
        gradeDto.setTopic( source.getTopic() );

        return gradeDto;
    }

    @Override
    public GradeEntity updateEntity(GradeDto source, GradeEntity target) {
        if ( source == null ) {
            return target;
        }

        target.setId( source.getId() );
        target.setStudent( studentMapper.toEntity( source.getStudent() ) );
        target.setSubject( subjectMapper.toEntity( source.getSubject() ) );
        target.setMark( source.getMark() );
        target.setTopic( source.getTopic() );

        return target;
    }

    private int sourceSubjectId(GradeEntity gradeEntity) {
        if ( gradeEntity == null ) {
            return 0;
        }
        SubjectEntity subject = gradeEntity.getSubject();
        if ( subject == null ) {
            return 0;
        }
        int id = subject.getId();
        return id;
    }

    private int sourceStudentId(GradeEntity gradeEntity) {
        if ( gradeEntity == null ) {
            return 0;
        }
        StudentEntity student = gradeEntity.getStudent();
        if ( student == null ) {
            return 0;
        }
        int id = student.getId();
        return id;
    }
}
