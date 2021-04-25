package com.arobs.internship.library.controller;

import com.arobs.internship.library.entity.dto.RentRequestDto;
import com.arobs.internship.library.entity.dto.viewer.RentRequestDtoViewer;
import com.arobs.internship.library.entity.helper.StatusRentRequest;
import com.arobs.internship.library.service.RentRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("rentRequests")
public class RentRequestController {

    @Autowired
    RentRequestService rentRequestService;

    @GetMapping("/{id}")
    public ResponseEntity<RentRequestDtoViewer> getRentRequestById(Integer id) {
        return new ResponseEntity<>(rentRequestService.getRentRequestDto(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RentRequestDtoViewer>> getAllRentRequests() {
        return new ResponseEntity<>(rentRequestService.getAllRentRequestDtos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RentRequestDtoViewer> addRentRequest(@Valid @RequestBody RentRequestDto rentRequestDto) {
        return new ResponseEntity<>(rentRequestService.addRentRequestDto(rentRequestDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<RentRequestDtoViewer> updateRentRequest(@Valid @RequestBody RentRequestDto rentRequestDto) {
        return new ResponseEntity<>(rentRequestService.editRentRequestDto(rentRequestDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RentRequestDtoViewer> deleteRentRequest(@PathVariable Integer id) {
        return new ResponseEntity<>(rentRequestService.deleteRentRequest(id), HttpStatus.OK);
    }

    @GetMapping("/book/{idBook}/status/{status}")
    public ResponseEntity<List<RentRequestDtoViewer>> getAllRentRequestsByIdBookAndStatus(@PathVariable("idBook") Integer idBook,
                                                                                          @PathVariable("status") StatusRentRequest statusRentRequest) {
        return new ResponseEntity<>(rentRequestService.getAllRentRequestDtosByBookIdAndStatus(idBook, statusRentRequest), HttpStatus.OK);
    }

    @GetMapping("/book/{idBook}")
    public ResponseEntity<List<RentRequestDtoViewer>> getAllRentRequestsByIdBook(@PathVariable("idBook") Integer idBook) {
        return new ResponseEntity<>(rentRequestService.getAllRentRequestByBookId(idBook), HttpStatus.OK);
    }

    @PostMapping("/{id}/employee/{idEmployee}/accept")
    public ResponseEntity<RentRequestDtoViewer> acceptRentRequestByIdEmployeeAndId(@PathVariable Integer id,
                                                                                   @PathVariable Integer idEmployee) {
        return new ResponseEntity<>(rentRequestService.acceptRentRequestById(id, idEmployee), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/employee/{idEmployee}/decline")
    public ResponseEntity<RentRequestDtoViewer> declineRentRequestByIdEmployeeAndId(@PathVariable Integer id,
                                                                                    @PathVariable Integer idEmployee) {
        return new ResponseEntity<>(rentRequestService.declineRentRequestById(id, idEmployee), HttpStatus.CREATED);
    }

    @GetMapping("/employee/{idEmployee}")
    public ResponseEntity<List<RentRequestDtoViewer>> getAllRentRequestsByEmployeeId(@PathVariable("employeeId") Integer id) {
        return new ResponseEntity<>(rentRequestService.getAllRentRequestByEmployeeId(id), HttpStatus.OK);
    }
}

