package cz.example.mapper;

import cz.example.dto.SubjectDto;
import cz.example.entity.SubjectEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    SubjectEntity toEntity(SubjectDto source);
    SubjectDto toDto(SubjectEntity source);

}
