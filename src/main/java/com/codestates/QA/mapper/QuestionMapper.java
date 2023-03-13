package com.codestates.QA.mapper;

import com.codestates.QA.dto.QuestionPatchDto;
import com.codestates.QA.dto.QuestionPostDto;
import com.codestates.QA.entity.Bord;
import com.codestates.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    default Bord QuestionPostDtoToBord (QuestionPostDto questionPostDto) {
        Bord bord = new Bord();
        bord.setTitle(questionPostDto.getTitle());
        bord.setDetail(questionPostDto.getDetail());

        Member member = new Member();
        member.setMemberId(questionPostDto.getMemberId());
        member.setEmail(questionPostDto.getMemberEmail());
        bord.setMember(member);
        bord.setEmail(questionPostDto.getMemberEmail());

        return bord;
    }
    Bord QuestionPatchDtoToBord (QuestionPatchDto questionPatchDto);
}
