package com.study.querydsl.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {

    private String username;
    private int age;

    @QueryProjection        // Q객체로 만들어짐, but, 아키택쳐로서 방법이 좋지 않음
    public MemberDto(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
