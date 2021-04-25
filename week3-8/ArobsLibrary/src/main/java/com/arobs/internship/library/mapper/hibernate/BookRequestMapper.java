package com.arobs.internship.library.mapper.hibernate;

import com.arobs.internship.library.entity.Author;
import com.arobs.internship.library.entity.BookRequest;
import com.arobs.internship.library.entity.dto.BookRequestDto;
import com.arobs.internship.library.entity.dto.viewer.BookRequestDtoViewer;
import com.arobs.internship.library.service.AuthorService;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface BookRequestMapper {
    BookRequestDtoViewer toDtoViewer(BookRequest bookRequest);

    List<BookRequestDtoViewer> toListDtoViewers(List<BookRequest> bookRequests);

    @Mapping(target = "authors", source = "idAuthors")
    BookRequest toEntity(BookRequestDto bookRequestDto,
                         @Context AuthorService authorService);

    @Mapping(target = "authors", source = "idAuthors")
    BookRequest updateEntity(@MappingTarget BookRequest bookRequest,
                             BookRequestDto bookRequestDto,
                             @Context AuthorService authorService);

    default List<Author> mapIdAuthorsToAuthors(Set<Integer> ids, @Context AuthorService authorService) {
        return authorService.getAuthorsByIds(ids);
    }
}
