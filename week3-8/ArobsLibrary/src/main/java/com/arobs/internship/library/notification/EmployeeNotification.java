package com.arobs.internship.library.notification;

import com.arobs.internship.library.entity.Book;
import com.arobs.internship.library.entity.Employee;
import com.arobs.internship.library.entity.RentRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class EmployeeNotification {
    private static final Logger log = LoggerFactory.getLogger(EmployeeNotification.class);

    @Autowired
    private JavaMailSender senderEmail;

    public void notifyForCopyAvailable(RentRequest rentRequest) {
        Employee employee = rentRequest.getEmployee();
        Book book = rentRequest.getBook();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");

        sendEmail(employee.getEmail(),
                "RentRequest " + rentRequest.getRequestDate().format(dateFormat) + ": Copy available for " + book.getTitle() + " book",
                "A copy of the " + book.getTitle() + " has become available. You have 24 hours to rent it.");
    }

    private void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        senderEmail.send(message);
        log.info("An email has been sent to '{}' with subject '{}' and content '{}'",
                to, subject, text);
    }
}
