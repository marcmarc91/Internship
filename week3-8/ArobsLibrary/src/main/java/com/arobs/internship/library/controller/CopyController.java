package com.arobs.internship.library.controller;

import com.arobs.internship.library.entity.dto.CopyDto;
import com.arobs.internship.library.entity.dto.viewer.CopyDtoViewer;
import com.arobs.internship.library.entity.types.StatusCopy;
import com.arobs.internship.library.service.CopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("copies")
public class CopyController {

    @Autowired
    private CopyService copyService;

    @GetMapping("/{id}")
    public ResponseEntity<CopyDtoViewer> getCopyById(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(copyService.getCopy(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CopyDtoViewer>> getAllCopies() {
        return new ResponseEntity<>(copyService.getCopies(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CopyDtoViewer> addCopy(@RequestBody CopyDto copyDto) {
        return new ResponseEntity<>(copyService.addCopyDto(copyDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CopyDtoViewer> updateCopy(@RequestBody CopyDto copyDto) {
        return new ResponseEntity<>(copyService.editCopyDto(copyDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CopyDtoViewer> deleteCopy(@PathVariable UUID id) {
        return new ResponseEntity<>(copyService.deleteCopy(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/status/{status}")
    public ResponseEntity<CopyDtoViewer> updateStatusCopyById(@PathVariable UUID id,
                                                              @PathVariable("status") StatusCopy statusCopy) {
        return new ResponseEntity<>(copyService.editStatusCopy(id, statusCopy), HttpStatus.CREATED);
    }

    @PutMapping("{id}/flag/{flag}")
    public ResponseEntity<CopyDtoViewer> updateFlagCopyById(@PathVariable UUID id,
                                                            @PathVariable boolean flag) {
        return new ResponseEntity<>(copyService.editFlagCopy(id, flag), HttpStatus.CREATED);
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<CopyDtoViewer>> getCopiesByBookId(@PathVariable Integer bookId) {
        return new ResponseEntity<>(copyService.getAllCopiesByBookId(bookId), HttpStatus.OK);
    }

    @GetMapping("/book/{bookId}/status{status}")
    public ResponseEntity<List<CopyDtoViewer>> getCopiesByBookIdAndStatus(@PathVariable Integer bookId,
                                                                          @PathVariable("status") StatusCopy statusCopy) {
        return new ResponseEntity<>(copyService.getAllCopiesDtoByBookIdAndStatus(bookId, statusCopy), HttpStatus.OK);
    }

    @PostMapping("/book/{bookId}/{numberOfCopies}")
    public ResponseEntity<List<CopyDtoViewer>> addCopyToBook(@PathVariable Integer bookId,
                                                             @PathVariable Integer numberOfCopies) {
        return new ResponseEntity<>(copyService.addCopyDtoToBook(bookId, numberOfCopies), HttpStatus.CREATED);
    }
}
