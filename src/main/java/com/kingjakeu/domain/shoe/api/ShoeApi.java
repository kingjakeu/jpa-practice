package com.kingjakeu.domain.shoe.api;

import com.kingjakeu.domain.shoe.dto.ShoeRegisterDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/shoe")
@AllArgsConstructor
public class ShoeApi {

    @PostMapping("/registration")
    public void registerShoe(@RequestBody ShoeRegisterDto dto){

    }
}
