package com.codestates.QA.dto;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
@Getter
public class QuestionPostDto {
    @NotBlank
    @Email
    private String memberEmail;

    @NotBlank
    private String title;

    @NotBlank
    private String detail;

//    @NotBlank
//    @Pattern(regexp = "^[a-zA-Z]*$",
//    message = "PUBLIC(공개글)과 SECRET(비밀글) 중에 입력해주세요.")
//    private String range;  todo : 설정 되야하는 것이지 입력은 아니기 때문에 애매. 일단 보류
}
