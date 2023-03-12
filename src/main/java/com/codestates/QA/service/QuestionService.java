package com.codestates.QA.service;

import com.codestates.QA.entity.Bord;
import com.codestates.QA.repository.QuestionRepository;
import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;
import com.codestates.member.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {
    private final MemberService memberService;
    private final QuestionRepository questionRepository;

    public QuestionService(MemberService memberService, QuestionRepository questionRepository) {
        this.memberService = memberService;
        this.questionRepository = questionRepository;
    }

    public Bord createdQuestion (Bord bord) {
        memberService.findVerifiedMember(bord.getMember().getMemberId());

        return questionRepository.save(bord);
    }
    public Bord updatedQuestion (Bord bord) {
        // 질문을 등록한 사람만 수정 가능. BordId에 있는 id와 memberid 비교
        findVerifiedMemberQuestion(bord.getBordId());

        return null;
    }
    public Bord findVerifiedMemberQuestion(long bordId) {
        Optional<Bord> optionalBord = questionRepository.findById(bordId);
        Bord findBord = optionalBord.orElseThrow(() -> new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));
        // 질문이 없습니다. 에러
        // dto 에서 이메일 받고, 매핑하고.

        // 회원이 등록한 글이 아닙니다 에러
        return findBord;
    }
    // TODO : 여기 패치 구현.
//    public Bord verifyExistsMemberQustion()

}
