package com.kingjakeu.springstudy.domain.member.dto;

import com.kingjakeu.springstudy.domain.member.domain.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberSignUpRequestDto {
    private String userName;
    private String password;

    public Member toEntity(){
        return Member.builder()
                .userName(this.userName)
                .password(this.password)
                .build();
    }
}
