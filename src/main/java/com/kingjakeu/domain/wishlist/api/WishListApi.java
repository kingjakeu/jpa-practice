package com.kingjakeu.domain.wishlist.api;

import com.kingjakeu.domain.wishlist.dao.WishListRepository;
import com.kingjakeu.domain.wishlist.dto.WishListRegisterRequestDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/wishlist")
@AllArgsConstructor
public class WishListApi {

    private WishListRepository wishListRepository;

    @PostMapping("/register")
    public void registerWishList(@RequestBody WishListRegisterRequestDto dto, Model model){
        wishListRepository.save(dto.toEntity());
    }

}
