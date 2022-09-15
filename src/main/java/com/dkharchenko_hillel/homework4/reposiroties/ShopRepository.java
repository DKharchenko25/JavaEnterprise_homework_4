package com.dkharchenko_hillel.homework4.reposiroties;

import com.dkharchenko_hillel.homework4.models.Shop;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Long> {
    @Modifying
    @Query("update Shop set name = ?2 where id = ?1")
    Integer updateNameById(Long id, String name);
}
