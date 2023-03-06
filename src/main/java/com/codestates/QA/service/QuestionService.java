package com.codestates.QA.service;

import com.codestates.QA.entity.Bord;
import com.codestates.member.service.MemberService;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private final MemberService memberService;

    public QuestionService(MemberService memberService) {
        this.memberService = memberService;
    }

    public Bord createdQuestion (Bord bord) {
        memberService.verifyExistsEmail(bord.getMember().getEmail());
        // TODO : 여기서부터.
        return null;
    }
}
