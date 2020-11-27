package com.kingjakeu.springstudy.domain.member.controller;

import com.kingjakeu.springstudy.domain.member.dao.MemberRepository;
import com.kingjakeu.springstudy.domain.member.dto.MemberSignUpRequestDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @PostMapping("/signup")
    @ApiOperation(value = "회원 가입")
    public void signUpMember(@RequestBody MemberSignUpRequestDto dto){
        this.memberRepository.save(dto.toEntity());
    }

    @GetMapping("/")
    public String getMember(){
        return "hello";
    }
}
