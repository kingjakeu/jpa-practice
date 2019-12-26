package com.kingjakeu.domain.member.api;

import com.kingjakeu.domain.member.dao.MemberRepository;
import com.kingjakeu.domain.member.dto.MemberSignUpRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MemberApi {

    private MemberRepository memberRepository;


    @GetMapping("/hello")
    public String hello(){
        return "Hello world";
    }

    @PostMapping("/signup")
    public void signUpMember(@RequestBody MemberSignUpRequestDto dto){
        memberRepository.save(dto.toEntity());
    }
}
