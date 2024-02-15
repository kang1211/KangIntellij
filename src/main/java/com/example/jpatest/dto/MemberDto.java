package com.example.jpatest.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
public class MemberDto {
    private long id;

    @NotEmpty(message="이메일을 입력하세요")
    private String email;

    @NotEmpty(message="이름을 입력하세요")
    private String name;

    @NotEmpty(message="비밀번호를 입려하세요")
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-z]).{4,16}", message="영어소문자, 숫자 포함 4~16자리로 입려하세요")
    private String password;

    @NotEmpty(message="연락처를 입려가헷요.")
    private String tel;
}
