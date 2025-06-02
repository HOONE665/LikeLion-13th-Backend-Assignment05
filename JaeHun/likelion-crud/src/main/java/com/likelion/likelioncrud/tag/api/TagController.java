package com.likelion.likelioncrud.tag.api;

import com.likelion.likelioncrud.tag.api.dto.request.TagSaveRequestDto;
import com.likelion.likelioncrud.tag.api.dto.request.TagUpdateRequestDto;
import com.likelion.likelioncrud.tag.api.dto.response.TagInfoResponseDto;
import com.likelion.likelioncrud.tag.api.dto.response.TagListResponseDto;
import com.likelion.likelioncrud.tag.application.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @PostMapping
    public void saveTag(@RequestBody TagSaveRequestDto requestDto) {
        tagService.saveTag(requestDto);
    }

    @GetMapping
    public List<TagListResponseDto> findAllTags() {
        return tagService.findAllTags();
    }

    @GetMapping("/{id}")
    public TagInfoResponseDto findTag(@PathVariable Long id) {
        return tagService.findTag(id);
    }

    @PutMapping("/{id}")
    public void updateTag(@PathVariable Long id, @RequestBody TagUpdateRequestDto requestDto) {
        tagService.updateTag(id, requestDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody TagUpdateRequestDto requestDto) {
        tagService.updateTag(id, requestDto);
        return new ResponseEntity<>("태그 수정 성공.", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
    }
}
