package com.kingjakeu.domain.shoe.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Shoe {

    @Id
    private Long uuid;

    private String brand;

    private String name;

    @UpdateTimestamp
    @Column(name = "release_dt", nullable = false)
    private LocalDateTime releasedDateTime;

    @CreationTimestamp
    @Column(name = "create_dt", nullable = false)
    private LocalDateTime creationDateTime;

    @UpdateTimestamp
    @Column(name = "update_dt", nullable = false)
    private LocalDateTime updatedDateTime;

    @Builder
    public Shoe(String name, String brand){
        this.name = name;
        this.brand = brand;
    }
}
