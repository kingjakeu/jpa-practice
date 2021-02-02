package com.kingjakeu.springstudy.domain.member.service;

import com.kingjakeu.springstudy.domain.member.annotation.LogExecutionTime;
import com.kingjakeu.springstudy.domain.member.annotation.MemberStatusLog;
import com.kingjakeu.springstudy.domain.member.domain.Member;
import com.kingjakeu.springstudy.domain.member.dto.MemberSignUpRequestDto;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @LogExecutionTime
    public String getMember(){
        return "Hello World";
    }

    @MemberStatusLog
    public void changeStatus(Member member){
        if(member.getUserName().equals("Jake")){
            throw new RuntimeException();
        }
    }
}
