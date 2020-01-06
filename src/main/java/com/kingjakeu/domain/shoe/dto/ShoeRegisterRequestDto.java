package com.kingjakeu.domain.shoe.dto;

import com.kingjakeu.domain.shoe.domain.Shoe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ShoeRegisterRequestDto {

    private String name;
    private String brand;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime releaseDate;


    public Shoe toEntity(){
        return Shoe.builder()
                .name(name)
                .brand(brand)
                .releaseDateTime(releaseDate)
                .build();
    }
}
