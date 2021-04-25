package com.arobs.internship.library.mapper.hibernate;

import com.arobs.internship.library.entity.Book;
import com.arobs.internship.library.entity.dto.viewer.BookDtoViewer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookViewerMapper {
    BookDtoViewer toDto(Book book);

    List<BookDtoViewer> toListDtos(List<Book> books);

    Book toEntity(BookDtoViewer bookDtoViewer);

    List<Book> toListEntities(List<BookDtoViewer> bookDtoViewers);
}
