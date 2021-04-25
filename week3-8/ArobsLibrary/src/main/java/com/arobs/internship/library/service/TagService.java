package com.arobs.internship.library.service;

import com.arobs.internship.library.entity.Tag;
import com.arobs.internship.library.entity.dto.TagDto;
import com.arobs.internship.library.exceptions.NoDataFoundException;
import com.arobs.internship.library.mapper.hibernate.TagMapper;
import com.arobs.internship.library.repository.TagRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class TagService {
    private static final Logger log = LoggerFactory.getLogger(TagService.class);

    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private TagMapper tagMapper;

    @Transactional(readOnly = true)
    public TagDto getTagDto(Integer id) {
        return tagMapper.toDto(getTagById(id));
    }

    @Transactional(readOnly = true)
    public List<TagDto> getTagDtos() {
        return tagMapper.toListDtos(tagRepository.findAll());
    }

    @Transactional
    public TagDto addTagDto(TagDto tagDto) {
        return tagMapper.toDto(tagRepository.save(tagMapper.toEntity(tagDto)));
    }

    @Transactional
    public TagDto editTagDto(TagDto tagDto) {
        Tag tagToEdit = getTagById(tagDto.getId());
        return tagMapper.toDto(tagMapper.updateEntity(tagToEdit, tagDto));
    }

    @Transactional
    public TagDto deleteTag(Integer id) {
        Tag tag = getTagById(id);
        tagRepository.delete(tag);
        return tagMapper.toDto(tag);
    }

    @Transactional(readOnly = true)
    public List<Tag> getTagsByIds(Set<Integer> ids) {
        return tagRepository.findAllByIdIn(ids);
    }

    public Tag getTagById(Integer id) {
        return (tagRepository.findById(id)
                .orElseThrow(() -> {
                    log.info("Could not find tag with id {}", id);
                    return new NoDataFoundException("This tag could not be found", id);
                }));
    }


}
