package com.codestates.QA.controller;

import com.codestates.QA.dto.QuestionPostDto;
import com.codestates.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/questions")
@Slf4j
@Validated
public class QA_Controller {
    // Todo : 관리자 이메일 등록 & 회원 확인 과정 필요.
    private final MemberService memberService;

    public QA_Controller(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity postQuestion (@Valid @RequestBody QuestionPostDto questionPostDto) {
        // TODO : 여기서부터. SERVICE 구현 해야 됨.
        return null;
    }
    @PatchMapping
    public ResponseEntity patchQuestion () {
        return null;
    }
    @GetMapping
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
