package com.kingjakeu.domain.wishlist.dto;


import com.kingjakeu.domain.wishlist.domain.WishList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WishListRegisterRequestDto {
    private Long memberUuid;
    private Long shoeUuid;

    public WishList toEntity(){
        return WishList.builder().memberUuid(memberUuid).shoeUuid(shoeUuid).build();
    }
}
