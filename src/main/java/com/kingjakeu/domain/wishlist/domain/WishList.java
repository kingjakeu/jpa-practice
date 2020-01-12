package com.kingjakeu.domain.wishlist.domain;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uuid", updatable = false)
    private Long uuid;

    private Long memberUuid;

    private Long shoeUuid;

    private String status;

    @CreationTimestamp
    @Column(name = "create_dt", nullable = false)
    private LocalDateTime creationDateTime;

    @UpdateTimestamp
    @Column(name = "update_dt", nullable = false)
    private LocalDateTime updatedDateTime;

    @Builder
    public WishList(Long memberUuid, Long shoeUuid){
        this.memberUuid = memberUuid;
        this.shoeUuid = shoeUuid;
    }
}
