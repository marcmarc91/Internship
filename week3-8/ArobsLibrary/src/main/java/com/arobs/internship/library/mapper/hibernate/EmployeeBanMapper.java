package com.arobs.internship.library.mapper.hibernate;

import com.arobs.internship.library.entity.Employee;
import com.arobs.internship.library.entity.EmployeeBan;
import com.arobs.internship.library.entity.dto.EmployeeBanDto;
import com.arobs.internship.library.entity.dto.viewer.EmployeeBanDtoViewer;
import com.arobs.internship.library.service.EmployeeService;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeBanMapper {

    EmployeeBanDtoViewer toDtoViewer(EmployeeBan employeeBan);

    List<EmployeeBanDtoViewer> toListDtoViewers(List<EmployeeBan> employeeBans);

    @Mappings({
            @Mapping(target = "employee", source = "idEmployee"),
            @Mapping(target = "id", ignore = true),
    })
    EmployeeBan toEntity(EmployeeBanDto employeeBanDto, @Context EmployeeService employeeService);

    List<EmployeeBan> toListEntities(List<EmployeeBanDto> employeeBanDtos);

    @Mappings({
            @Mapping(target = "employee", source = "idEmployee"),
            @Mapping(target = "id", ignore = true),
    })
    EmployeeBan updateEntity(@MappingTarget EmployeeBan employeeBan,
                             EmployeeBanDto employeeBanDto,
                             @Context EmployeeService employeeService);

    default Employee mapIdEmployeeToEmployee(Integer idEmployee, @Context EmployeeService employeeService) {
        return employeeService.getEmployeeById(idEmployee);
    }
}
