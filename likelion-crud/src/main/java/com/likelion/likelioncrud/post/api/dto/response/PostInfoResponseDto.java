package com.likelion.likelioncrud.post.api.dto.response;

import com.likelion.likelioncrud.post.domain.Post;
import com.likelion.likelioncrud.posttag.domain.PostTag;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;

@Builder
public record PostInfoResponseDto(
        String title,
        String contents,
        String writer,
        List<String> tags
) {
    public static PostInfoResponseDto from(Post post) {
        // PostTag 리스트에서 Tag의 name을 추출하여 tags 리스트 생성
        List<String> tagNames = post.getPostTags().stream()
                .map(postTag -> postTag.getTag().getName()) // Tag 객체의 name을 가져옴
                .collect(Collectors.toList());

        return PostInfoResponseDto.builder()
                .title(post.getTitle())
                .contents(post.getContents())
                .writer(post.getMember().getName())
                .tags(tagNames) // tags 필드에 name 리스트 추가
                .build();
    }
}
