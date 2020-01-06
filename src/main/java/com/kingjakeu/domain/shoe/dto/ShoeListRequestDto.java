package com.kingjakeu.domain.shoe.dto;

import com.kingjakeu.domain.shoe.domain.Shoe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShoeListRequestDto {

    private String brand;
    private String name;

    public Shoe toEntity(){
        return Shoe.builder()
                .brand(brand)
                .name(name)
                .build();
    }
}
