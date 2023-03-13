package com.codestates.QA.service;

import com.codestates.QA.entity.Bord;
import com.codestates.QA.repository.QuestionRepository;
import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;
import com.codestates.member.entity.Member;
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
        memberService.findVerifiedMemberandEmail(bord.getMember().getMemberId(), bord.getMember().getEmail());
        return questionRepository.save(bord);
    }
    public Bord updatedQuestion (Bord bord) {
        // 질문을 등록한 사람만 수정 가능. BordId에 있는 id와 memberid 비교
        findVerifiedMemberQuestion(bord.getBordId(), bord.getEmail());

        return null;
    }
    public Bord findVerifiedMemberQuestion(long bordId, String bordEmail) {
        Optional<Bord> optionalBord = questionRepository.findById(bordId);
        Optional<Bord> optionalEmail = questionRepository.findByEmail(bordEmail);

        Bord findBord = optionalBord.orElseThrow(() -> new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));
        Bord findMember = optionalEmail.orElseThrow(() -> new BusinessLogicException(ExceptionCode.QUESTION_INFO_ERROR));

        if (findBord.getEmail().equals(bordEmail)) {
        }
        else throw new BusinessLogicException(ExceptionCode.QUESTION_INFO_ERROR);

        return findBord;
    }
    // TODO : 여기 패치 구현.
//    public Bord verifyExistsMemberQustion()

}
