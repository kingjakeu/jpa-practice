package com.kingjakeu.domain.member.api;

import com.kingjakeu.domain.member.dao.MemberRepository;
import com.kingjakeu.domain.member.domain.Member;
import com.kingjakeu.domain.member.dto.MemberSignUpRequestDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/member")
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
        List<Member> memberList = memberRepository.findAll();
        Member member = memberList.get(0);
        log.info(member.toString());
    }
}
