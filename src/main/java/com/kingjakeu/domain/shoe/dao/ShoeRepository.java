package com.kingjakeu.domain.shoe.dao;

import com.kingjakeu.domain.shoe.domain.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoeRepository extends JpaRepository<Shoe, Long> {

    List<Shoe> findByName(String name);
}
