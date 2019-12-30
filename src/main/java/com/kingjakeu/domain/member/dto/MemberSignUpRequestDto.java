package com.kingjakeu.domain.member.dto;

import com.kingjakeu.domain.member.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberSignUpRequestDto {

    private String email;
    private String password;
    private String userName;

    public Member toEntity(){
        return Member.builder()
                .email(email)
                .password(password)
                .userName(userName)
                .build();
    }
}
