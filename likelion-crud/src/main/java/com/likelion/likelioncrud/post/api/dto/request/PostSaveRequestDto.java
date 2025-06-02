package com.likelion.likelioncrud.post.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record PostSaveRequestDto(
        @NotNull(message = "작성자입력필수")
        Long memberId,

        @NotBlank(message = "제목필수")
        @Size(min = 2, max = 10)
        String title,

        @NotBlank(message = "내용필수")
        @Size(min = 5, max = 1000)
        String contents,


        List<String> tags
) {
}
