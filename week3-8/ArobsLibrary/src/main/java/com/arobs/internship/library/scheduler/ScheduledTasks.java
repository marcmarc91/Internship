package com.arobs.internship.library.scheduler;

import com.arobs.internship.library.entity.BookRent;
import com.arobs.internship.library.entity.Copy;
import com.arobs.internship.library.entity.EmployeeBan;
import com.arobs.internship.library.entity.RentRequest;
import com.arobs.internship.library.entity.dto.EmployeeBanDto;
import com.arobs.internship.library.entity.helper.StatusBookRent;
import com.arobs.internship.library.entity.helper.StatusCopy;
import com.arobs.internship.library.entity.helper.StatusRentRequest;
import com.arobs.internship.library.notification.EmployeeNotification;
import com.arobs.internship.library.service.BookRentService;
import com.arobs.internship.library.service.CopyService;
import com.arobs.internship.library.service.EmployeeBanService;
import com.arobs.internship.library.service.RentRequestService;
import com.arobs.internship.library.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
@EnableScheduling
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    RentRequestService rentRequestService;
    @Autowired
    CopyService copyService;
    @Autowired
    BookRentService bookRentService;
    @Autowired
    EmployeeBanService employeeBanService;
    @Autowired
    private EmployeeNotification employeeNotification;

    @Scheduled(cron = "1 * * * * ?")
    @Transactional
    public void checkExpireRentRequests() {
        List<RentRequest> requestList = rentRequestService.getAllByStatusAndRequestDateLessThanEqual(StatusRentRequest.WAITING_FOR_CONFIRMATION,
                LocalDateTime.now().minusHours(Constants.WAITING_FOR_CONFIRMATION_HOURS));
        requestList.forEach(r -> {
            r.setStatus(StatusRentRequest.DECLINED);
            Copy copy = copyService.getCopyByBookIdAndStatus(r.getBook().getId(), StatusCopy.PENDING);
            rentRequestService.getNextRentRequest(r.getBook().getId(), copy)
                    .ifPresent(request -> {
                        employeeNotification.notifyForCopyAvailable(request);
                        request.setRequestDate(LocalDateTime.now());
                    });
        });
    }

    @Scheduled(cron = "1 * * * * ?")
    @Transactional
    public void checkExpireBannedEmployee() {
        List<EmployeeBan> employeeBans = employeeBanService.getEmployeeBanByEmployeeIsBannedAndStopDateLessThanEqual(true, LocalDateTime.now());
        employeeBans.forEach(e -> {
            e.getEmployee().setBanned(false);
            log.info("The employee with id {} has expired the banned period", e.getEmployee().getId());
        });
    }

    @Scheduled(cron = "1 * * * * ?")
    @Transactional
    public void checkLateRentalAndBanEmployee() {
        List<BookRent> bookRents =
                bookRentService.getBookRentsByStatusAndReturnDateLessThanEqual(StatusBookRent.ON_GOING,
                        LocalDateTime.now());
        bookRents.forEach(b -> {
            b.setStatus(StatusBookRent.LATE);
            b.getEmployee().setBanned(true);
            EmployeeBanDto employeeBanDto = new EmployeeBanDto();
            employeeBanDto.setStartDate(LocalDateTime.now());
            employeeBanDto.setStopDate(LocalDateTime.parse(Constants.MAX_BAN_DATE));
            employeeBanDto.setIdEmployee(b.getEmployee().getId());
            employeeBanService.saveOrUpdateEmployeeBan(employeeBanDto);
            log.info("The employee with id {} was banned", b.getEmployee().getId());
        });
    }
}
