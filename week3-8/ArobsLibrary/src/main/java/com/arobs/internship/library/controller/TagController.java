package com.arobs.internship.library.controller;

import com.arobs.internship.library.entity.dto.TagDto;
import com.arobs.internship.library.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping("/{id}")
    public ResponseEntity<TagDto> getTagById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(tagService.getTagDto(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TagDto>> getAllTags() {
        return new ResponseEntity<>(tagService.getTagDtos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TagDto> addTag(@RequestBody TagDto tagDto) {
        return new ResponseEntity<>(tagService.addTagDto(tagDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TagDto> updateTag(@RequestBody TagDto tagDto) {
        return new ResponseEntity<>(tagService.editTagDto(tagDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TagDto> deleteTag(@PathVariable Integer id) {
        return new ResponseEntity<>(tagService.deleteTag(id), HttpStatus.OK);
    }

}
