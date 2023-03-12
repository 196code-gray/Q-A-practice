package com.codestates.QA.dto;

import lombok.Getter;

import javax.validation.constraints.*;

@Getter
public class QuestionPostDto {
//    @NotBlank
//    @Email
//    private String memberEmail;
    @NotNull
    private long memberId;

    @NotBlank
    private String title;

    @NotBlank
    private String detail;
}
