package com.arobs.internship.library.mapper.hibernate;

import com.arobs.internship.library.entity.Employee;
import com.arobs.internship.library.entity.dto.EmployeeDto;
import org.mapstruct.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    @Mapping(target = "password", ignore = true)
    EmployeeDto toDto(Employee employee);

    List<EmployeeDto> toListDtos(List<Employee> employeeList);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "password", qualifiedByName = "encodePassword")})
    Employee toEntity(EmployeeDto employeeDto);

    List<Employee> toListEntities(List<EmployeeDto> employeeDtos);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "password", qualifiedByName = "encodePassword")})
    Employee updateEmployee(@MappingTarget Employee employee, EmployeeDto employeeDto);

    @Named("encodePassword")
    default String encodePassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes(StandardCharsets.UTF_8));
    }
}
