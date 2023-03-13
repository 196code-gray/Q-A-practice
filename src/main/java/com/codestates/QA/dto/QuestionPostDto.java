package com.codestates.QA.dto;

import lombok.Getter;

import javax.validation.constraints.*;

@Getter
public class QuestionPostDto {
    @NotNull
    private long memberId;

    @NotBlank
    @Email
    private String memberEmail;

    @NotBlank
    private String title;

    @NotBlank
    private String detail;
}
