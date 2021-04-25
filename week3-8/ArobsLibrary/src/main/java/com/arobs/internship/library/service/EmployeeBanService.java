package com.arobs.internship.library.service;

import com.arobs.internship.library.entity.EmployeeBan;
import com.arobs.internship.library.entity.dto.EmployeeBanDto;
import com.arobs.internship.library.mapper.hibernate.EmployeeBanMapper;
import com.arobs.internship.library.repository.EmployeeBanRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeBanService {
    private static final Logger log = LoggerFactory.getLogger(EmployeeBanService.class);

    @Autowired
    EmployeeBanRepository employeeBanRepository;
    @Autowired
    EmployeeBanMapper employeeBanMapper;
    @Autowired
    EmployeeService employeeService;

    public void saveOrUpdateEmployeeBan(EmployeeBanDto employeeBanDto) {
        Optional<EmployeeBan> employeeBanById = getEmployeeBanById(employeeBanDto.getIdEmployee());
        if (employeeBanById.isPresent()) {
            employeeBanMapper.updateEntity(employeeBanById.get(), employeeBanDto, employeeService);
        } else employeeBanRepository.save(employeeBanMapper.toEntity(employeeBanDto, employeeService));
    }

    protected Optional<EmployeeBan> getEmployeeBanById(Integer id) {
        return employeeBanRepository.findById(id);
    }

    public List<EmployeeBan> getEmployeeBanByEmployeeIsBannedAndStopDateLessThanEqual(boolean isBanned,
                                                                                      LocalDateTime date) {
        return employeeBanRepository.getAllBanByEmployeeIsBannedAndStopDateLessThanEqual(isBanned, date);
    }
//
//    private EmployeeBan getEmployeeBanByIdEmployee(Integer idEmployee) {
//        return employeeBanRepository.findByEmployeeId(idEmployee);
//    }
}
