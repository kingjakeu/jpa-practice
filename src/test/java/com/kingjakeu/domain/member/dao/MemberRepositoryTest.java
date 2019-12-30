package com.kingjakeu.domain.member.dao;

import com.kingjakeu.domain.member.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @After
    public void cleanup(){
        memberRepository.deleteAll();
    }

    @Test
    public void saveMember(){

    }

}