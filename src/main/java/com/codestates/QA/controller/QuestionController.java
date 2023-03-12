package com.codestates.QA.controller;

import com.codestates.QA.dto.QuestionPatchDto;
import com.codestates.QA.dto.QuestionPostDto;
import com.codestates.QA.entity.Bord;
import com.codestates.QA.mapper.QuestionMapper;
import com.codestates.QA.service.QuestionService;
import com.codestates.member.service.MemberService;
import com.codestates.utils.UriCreator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;

@RestController
@RequestMapping("/v1/questions")
@Slf4j
@Validated
public class QuestionController {
    // Todo : 관리자 이메일 등록 & 회원 확인 과정 필요.
    private final QuestionService questionService;
    private final QuestionMapper mapper;

    public QuestionController(QuestionService questionService, QuestionMapper mapper) {
        this.questionService = questionService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postQuestion (@Valid @RequestBody QuestionPostDto questionPostDto) {
        Bord bord = mapper.QuestionPostDtoToBord(questionPostDto);

        Bord created = questionService.createdQuestion(bord);
        URI location = UriCreator.createUri("/v1/questions", created.getBordId());

        return ResponseEntity.created(location).build();
    }
    @PatchMapping("/{bord-id}")
    public ResponseEntity patchQuestion (@PathVariable("bord-id") @Positive long bordId,
                                         @Valid @RequestBody QuestionPatchDto questionPatchDto) {
        questionPatchDto.setBordId(bordId);

        return null;
    }
    @GetMapping("member-Email")
    public ResponseEntity getQuestion () {
        return null;
    }
    @GetMapping
    public ResponseEntity allQuestion() {
        return null;
    }
    @DeleteMapping
    public ResponseEntity deleteQuestion() {
        return null;
    }
}
