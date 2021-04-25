package com.arobs.internship.library.mapper.hibernate;

import com.arobs.internship.library.entity.Book;
import com.arobs.internship.library.entity.Copy;
import com.arobs.internship.library.entity.dto.CopyDto;
import com.arobs.internship.library.entity.dto.viewer.CopyDtoViewer;
import com.arobs.internship.library.service.BookService;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CopyMapper {
    CopyDtoViewer toDto(Copy copy);

    List<CopyDtoViewer> toListDtos(List<Copy> copies);

    Copy toEntity(CopyDtoViewer copyDtoViewer);

    List<Copy> toListEntities(List<CopyDtoViewer> copyDtoViewers);

    @Mappings({
            @Mapping(source = "idBook", target = "book"),
            @Mapping(target = "code", ignore = true)
    })
    Copy updateCopy(@MappingTarget Copy copy, CopyDto copyDto, @Context BookService bookService);

    @Mapping(source = "idBook", target = "book")
    Copy viewerToEntity(CopyDto copyDto, @Context BookService bookService);

    default Book mapIdBookToBook(Integer idBook, @Context BookService bookService) {
        return bookService.getBookById(idBook);
    }
}
