package com.arobs.internship.library.service;

import com.arobs.internship.library.entity.Employee;
import com.arobs.internship.library.entity.dto.EmployeeDto;
import com.arobs.internship.library.entity.types.RoleType;
import com.arobs.internship.library.exceptions.NoDataFoundException;
import com.arobs.internship.library.mapper.hibernate.EmployeeMapper;
import com.arobs.internship.library.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private BookRentService bookRentService;
    @Autowired
    private RentRequestService rentRequestService;
    @Autowired
    private EmployeeBanService employeeBanService;

    @Transactional(readOnly = true)
    public EmployeeDto getEmployeeDto(Integer id) {
        return (employeeMapper.toDto(getEmployeeById(id)));
    }

    @Transactional(readOnly = true)
    public List<EmployeeDto> getEmployeeDtos() {
        return employeeMapper.toListDtos(employeeRepository.findAll());
    }

    @Transactional
    public EmployeeDto addEmployeeDto(EmployeeDto employeeDto) {
        return employeeMapper.toDto(employeeRepository.save(employeeMapper.toEntity(employeeDto)));
    }

    @Transactional
    public EmployeeDto editEmployeeDto(EmployeeDto employeeDto) {
        Employee employeeToEdit = getEmployeeById(employeeDto.getId());
        return employeeMapper.toDto(employeeMapper.updateEmployee(employeeToEdit, employeeDto));
    }

    @Transactional
    public EmployeeDto deleteEmployeeDto(Integer id) {
        Employee employee = getEmployeeById(id);
        bookRentService.getAllBookRentsByEmployeeId(id)
                .forEach(b -> bookRentService.deleteBookRentDto(b.getId()));
        rentRequestService.getAllRentRequestByEmployeeId(id)
                .forEach(r -> rentRequestService.deleteRentRequest(r.getId()));
//        employeeBanService.deleteEmployeeBanByEmployee(employee);
        employeeRepository.delete(employee);
        return employeeMapper.toDto(employee);
    }

    @Transactional(readOnly = true)
    public List<EmployeeDto> getEmployeeDtosByRole(RoleType roleType) {
        return employeeMapper.toListDtos(employeeRepository.findByRole(roleType));
    }

    public Employee getEmployeeById(Integer id) {
        return (employeeRepository.findById(id)
                .orElseThrow(() -> {
                            log.info("Could not find employee with id {}", id);
                            return new NoDataFoundException("This employee could not be found", id);
                        }
                ));
    }

}
