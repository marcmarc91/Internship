package com.arobs.internship.library.mapper.hibernate;

import com.arobs.internship.library.entity.Book;
import com.arobs.internship.library.entity.Employee;
import com.arobs.internship.library.entity.RentRequest;
import com.arobs.internship.library.entity.dto.RentRequestDto;
import com.arobs.internship.library.entity.dto.viewer.RentRequestDtoViewer;
import com.arobs.internship.library.service.BookService;
import com.arobs.internship.library.service.EmployeeService;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RentRequestMapper {

    RentRequestDtoViewer toDtoViewer(RentRequest rentRequest);

    List<RentRequestDtoViewer> toListDtoViewers(List<RentRequest> rentRequests);

    @Mappings({
            @Mapping(target = "book", source = "idBook"),
            @Mapping(target = "employee", source = "idEmployee")
    })
    RentRequest toEntity(RentRequestDto rentRequestDto,
                         @Context BookService bookService,
                         @Context EmployeeService employeeService);

    @Mappings({
            @Mapping(target = "book", source = "idBook"),
            @Mapping(target = "employee", source = "idEmployee")
    })
    RentRequest updateEntity(@MappingTarget RentRequest rentRequest,
                             RentRequestDto rentRequestDto,
                             @Context BookService bookService,
                             @Context EmployeeService employeeService);

    default Book mapIdBookToBook(Integer idBook, @Context BookService bookService) {
        return bookService.getBookById(idBook);
    }

    default Employee mapIdEmployeeToEmployee(Integer idEmployee, @Context EmployeeService employeeService) {
        return employeeService.getEmployeeById(idEmployee);
    }
}
