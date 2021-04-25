package com.arobs.internship.library.mapper.hibernate;

import com.arobs.internship.library.entity.Tag;
import com.arobs.internship.library.entity.dto.TagDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {
    TagDto toDto(Tag tag);

    List<TagDto> toListDtos(List<Tag> tags);

    @Mapping(target = "id", ignore = true)
    Tag toEntity(TagDto tagDto);

    List<Tag> toListEntities(List<TagDto> tagDtos);

    @Mapping(target = "id", ignore = true)
    Tag updateEntity(@MappingTarget Tag tag,
                     TagDto tagDto);
}
