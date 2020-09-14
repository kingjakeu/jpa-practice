package com.kingjakeu.springstudy.domain.member.controller;

import com.kingjakeu.springstudy.common.util.S3Uploader;
import com.kingjakeu.springstudy.domain.member.dao.MemberRepository;
import com.kingjakeu.springstudy.domain.member.dto.MemberSignUpRequestDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;
    private final S3Uploader s3Uploader;

    @PostMapping("{memberId}/profile-pic")
    public void postProfilePic(@PathVariable Long memberId,
                               @RequestParam(value = "profilePic") MultipartFile profilePic) throws IOException {
        // 회원 아이디 값을 파일 이름으로 사용
        this.s3Uploader.postFile("", String.valueOf(memberId), profilePic);
    }

    @PostMapping("/signup")
    @ApiOperation(value = "회원 가입")
    public void signUpMember(@RequestBody MemberSignUpRequestDto dto){
        this.memberRepository.save(dto.toEntity());
    }


}
