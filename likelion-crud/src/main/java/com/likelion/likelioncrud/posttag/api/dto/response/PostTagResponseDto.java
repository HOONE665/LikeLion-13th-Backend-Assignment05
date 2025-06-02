package com.likelion.likelioncrud.posttag.api.dto.response;

import com.likelion.likelioncrud.tag.domain.Tag;

public record PostTagResponseDto(Long tagId, String tagName) {
    public static PostTagResponseDto from(Tag tag) {
        return new PostTagResponseDto(tag.getId(), tag.getName());
    }
}
