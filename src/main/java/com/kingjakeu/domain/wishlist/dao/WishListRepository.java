package com.kingjakeu.domain.wishlist.dao;

import com.kingjakeu.domain.wishlist.domain.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepository extends JpaRepository<WishList, Long> {
}
