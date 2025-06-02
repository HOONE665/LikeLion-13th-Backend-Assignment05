package com.likelion.likelioncrud.tag.api.dto.response;

import com.likelion.likelioncrud.tag.domain.Tag;

public record TagListResponseDto(Long id, String name) {
    public static TagListResponseDto from(Tag tag) {
        return new TagListResponseDto(tag.getId(), tag.getName());
    }
}
