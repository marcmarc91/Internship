package com.arobs.internship.library.mapper.hibernate;


import com.arobs.internship.library.entity.Author;
import com.arobs.internship.library.entity.dto.AuthorDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDto toDto(Author author);

    List<AuthorDto> toListDtos(List<Author> authors);

    @Mapping(target = "id", ignore = true)
    Author toEntity(AuthorDto authorDto);

    List<Author> toListEntities(List<AuthorDto> authorDtos);

    @Mapping(target = "id", ignore = true)
    Author updateEntity(@MappingTarget Author author,
                        AuthorDto authorDto);
}
