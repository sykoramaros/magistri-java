package cz.example.mapper;

import cz.example.dto.SubjectDto;
import cz.example.entity.SubjectEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class SubjectMapperImpl implements SubjectMapper {

    @Override
    public SubjectEntity toEntity(SubjectDto source) {
        if ( source == null ) {
            return null;
        }

        SubjectEntity subjectEntity = new SubjectEntity();

        subjectEntity.setId( source.getId() );
        subjectEntity.setName( source.getName() );

        return subjectEntity;
    }

    @Override
    public SubjectDto toDto(SubjectEntity source) {
        if ( source == null ) {
            return null;
        }

        SubjectDto subjectDto = new SubjectDto();

        subjectDto.setId( source.getId() );
        subjectDto.setName( source.getName() );

        return subjectDto;
    }
}
