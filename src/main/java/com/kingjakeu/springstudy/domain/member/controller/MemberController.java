package com.kingjakeu.springstudy.domain.member.controller;

import com.kingjakeu.springstudy.domain.member.dao.MemberRepository;
import com.kingjakeu.springstudy.domain.member.dto.MemberSignUpRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;


    @PostMapping("/signup")
    public void signUpMember(@RequestBody MemberSignUpRequestDto dto){
        this.memberRepository.save(dto.toEntity());
    }
}
