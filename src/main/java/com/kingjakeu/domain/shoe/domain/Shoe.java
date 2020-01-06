package com.kingjakeu.domain.shoe.domain;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@ToString(of = {"uuid", "name", "brand", "releaseDateTime"})
public class Shoe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uuid", updatable = false)
    private Long uuid;

    @Column(name = "brand", length = 50, nullable = false)
    private String brand;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "release_dt", nullable = false)
    private LocalDateTime releaseDateTime;

    @CreationTimestamp
    @Column(name = "create_dt", nullable = false)
    private LocalDateTime creationDateTime;

    @UpdateTimestamp
    @Column(name = "update_dt", nullable = false)
    private LocalDateTime updatedDateTime;

    @Builder
    public Shoe(String name, String brand, LocalDateTime releaseDateTime){
        this.name = name;
        this.brand = brand;
        this.releaseDateTime = releaseDateTime;
    }
}
