package com.codestates.QA.dto;

import com.codestates.QA.entity.Bord;
import com.codestates.validator.NotSpace;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
public class QuestionPatchDto {
    private long bordId;

//    @NotBlank
//    private String memberEmail;

    @Pattern(regexp = "^[a-zA-Z]*$",
    message = "PUBLIC(공개글)과 SECRET(비밀글) 중에 입력해주세요.")
    private String range;
    @NotSpace
    private String title;
    @NotSpace
    private String detail;

    public void setBordId (long bordId) {
        this.bordId = bordId;
    }
}
