package com.likelion.likelioncrud.tag.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TagUpdateRequestDto(

        @NotBlank(message = "이름은 필수")
        @Size(min = 1, max = 20, message = "1~20자 사이")
        String name

) {}