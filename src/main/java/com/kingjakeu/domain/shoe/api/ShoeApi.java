package com.kingjakeu.domain.shoe.api;

import com.kingjakeu.domain.shoe.dao.ShoeRepository;
import com.kingjakeu.domain.shoe.domain.Shoe;
import com.kingjakeu.domain.shoe.dto.ShoeListRequestDto;
import com.kingjakeu.domain.shoe.dto.ShoeRegisterRequestDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/shoe")
@AllArgsConstructor
public class ShoeApi {

    private ShoeRepository shoeRepository;

    @PostMapping("/register")
    public void registerShoe(@RequestBody ShoeRegisterRequestDto dto){
        shoeRepository.save(dto.toEntity());
    }

    @PostMapping("/modify")
    public void modifyShoe(@RequestBody ShoeRegisterRequestDto dto){

    }

    @PostMapping("/delete")
    public void deleteShoe(@RequestBody ShoeRegisterRequestDto dto){

    }

    @PostMapping("/search")
    public void searchShoe(@RequestBody ShoeListRequestDto dto){

    }



}
