package com.kingjakeu.domain.member.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString(of = {"uuid", "email", "userName"})
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uuid", updatable = false)
    private Long uuid;

    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "user_name", length = 30, nullable = false)
    private String userName;

    @Column(length = 10, nullable = false)
    private String memberStatus;

    @CreationTimestamp
    @Column(name = "create_dt", nullable = false)
    private LocalDateTime creationDateTime;

    @UpdateTimestamp
    @Column(name = "update_dt", nullable = false)
    private LocalDateTime updatedDateTime;

    @Builder
    public Member(String email, String password, String userName){
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.memberStatus = "Normal";
    }

}
