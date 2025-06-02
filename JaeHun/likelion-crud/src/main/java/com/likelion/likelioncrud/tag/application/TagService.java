package com.likelion.likelioncrud.tag.application;

import com.likelion.likelioncrud.tag.api.dto.request.TagSaveRequestDto;
import com.likelion.likelioncrud.tag.api.dto.request.TagUpdateRequestDto;
import com.likelion.likelioncrud.tag.api.dto.response.TagInfoResponseDto;
import com.likelion.likelioncrud.tag.api.dto.response.TagListResponseDto;
import com.likelion.likelioncrud.tag.domain.Tag;
import com.likelion.likelioncrud.tag.domain.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    @Transactional
    public void saveTag(TagSaveRequestDto requestDto) {
        Tag tag = Tag.builder().name(requestDto.name()).build();
        tagRepository.save(tag);
    }

    @Transactional(readOnly = true)
    public List<TagListResponseDto> findAllTags() {
        return tagRepository.findAll().stream()
                .map(TagListResponseDto::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public TagInfoResponseDto findTag(Long id) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tag 찾을 수 없음"));
        return TagInfoResponseDto.from(tag);
    }

    @Transactional
    public void updateTag(Long id, TagUpdateRequestDto requestDto) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tag 찾을 수 없음"));
        tag.update(requestDto);
    }

    @Transactional
    public void deleteTag(Long id) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tag 찾을 수 없음"));

        tagRepository.delete(tag);
    }


}



