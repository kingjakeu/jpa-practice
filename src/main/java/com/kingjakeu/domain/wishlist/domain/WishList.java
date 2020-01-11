package com.kingjakeu.domain.wishlist.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    private String updatedDateTime;
}
