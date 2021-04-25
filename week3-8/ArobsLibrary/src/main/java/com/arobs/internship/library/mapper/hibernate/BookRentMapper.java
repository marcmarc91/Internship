package com.arobs.internship.library.mapper.hibernate;

import com.arobs.internship.library.entity.Book;
import com.arobs.internship.library.entity.BookRent;
import com.arobs.internship.library.entity.Copy;
import com.arobs.internship.library.entity.Employee;
import com.arobs.internship.library.entity.dto.BookRentDto;
import com.arobs.internship.library.entity.dto.viewer.BookRentDtoViewer;
import com.arobs.internship.library.service.BookService;
import com.arobs.internship.library.service.CopyService;
import com.arobs.internship.library.service.EmployeeService;
import org.mapstruct.*;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface BookRentMapper {

    BookRentDtoViewer toDtoViewer(BookRent bookRent);

    List<BookRentDtoViewer> toListDtoViewers(List<BookRent> bookRents);

    @Mappings({
            @Mapping(target = "book", source = "idBook"),
            @Mapping(target = "employee", source = "idEmployee"),
            @Mapping(target = "copy", source = "idCopy"),
    })
    BookRent toEntity(BookRentDto bookRentDto,
                      @Context BookService bookService,
                      @Context EmployeeService employeeService,
                      @Context CopyService copyService);

    @Mappings({
            @Mapping(target = "book", source = "idBook"),
            @Mapping(target = "employee", source = "idEmployee"),
            @Mapping(target = "copy", source = "idCopy"),
    })
    BookRent updateEntity(@MappingTarget BookRent bookRent,
                          BookRentDto bookRentDto,
                          @Context BookService bookService,
                          @Context EmployeeService employeeService,
                          @Context CopyService copyService);

    default Book mapIdBookToBook(Integer idBook,
                                 @Context BookService bookService) {
        return bookService.getBookById(idBook);
    }

    default Copy mapIdCopyToCopy(UUID idCopy,
                                 @Context CopyService copyService) {
        return copyService.getCopyById(idCopy);
    }

    default Employee mapIdEmployeeToEmployee(Integer idEmployee,
                                             @Context EmployeeService employeeService) {
        return employeeService.getEmployeeById(idEmployee);
    }

}
