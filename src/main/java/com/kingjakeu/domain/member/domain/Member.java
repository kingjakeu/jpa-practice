package com.kingjakeu.domain.member.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString(of = {"id", "nationCode"})
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 2, nullable = false)
    private String nationCode;


    @Builder
    public Member(String nationCode){
        this.nationCode = nationCode;
    }

}
