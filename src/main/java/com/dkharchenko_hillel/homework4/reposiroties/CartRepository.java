package com.dkharchenko_hillel.homework4.reposiroties;

import com.dkharchenko_hillel.homework4.models.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

}
