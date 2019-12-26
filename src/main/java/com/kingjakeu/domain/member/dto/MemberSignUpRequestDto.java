package com.kingjakeu.domain.member.dto;

import com.kingjakeu.domain.member.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberSignUpRequestDto {

    private String nationCode;

    public Member toEntity(){
        return Member.builder().nationCode(nationCode).build();
    }
}
