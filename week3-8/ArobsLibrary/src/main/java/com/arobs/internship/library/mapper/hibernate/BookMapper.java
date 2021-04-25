package com.arobs.internship.library.mapper.hibernate;

import com.arobs.internship.library.entity.Author;
import com.arobs.internship.library.entity.Book;
import com.arobs.internship.library.entity.Tag;
import com.arobs.internship.library.entity.dto.BookDto;
import com.arobs.internship.library.entity.dto.viewer.BookDtoViewer;
import com.arobs.internship.library.service.AuthorService;
import com.arobs.internship.library.service.TagService;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDtoViewer toDtoViewer(Book book);

    List<BookDtoViewer> toListDtoViewers(List<Book> books);

    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    Book toEntity(BookDto bookDto,
                  @Context TagService tagService,
                  @Context AuthorService authorService);

    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    Book updateEntity(@MappingTarget Book book,
                      BookDto bookDto,
                      @Context TagService tagService,
                      @Context AuthorService authorService);

    default List<Tag> mapIdTagsToTags(Set<Integer> ids, @Context TagService tagService) {
        return tagService.getTagsByIds(ids);
    }

    default List<Author> mapIdAuthorsToAuthors(Set<Integer> ids, @Context AuthorService authorService) {
        return authorService.getAuthorsByIds(ids);
    }
}
