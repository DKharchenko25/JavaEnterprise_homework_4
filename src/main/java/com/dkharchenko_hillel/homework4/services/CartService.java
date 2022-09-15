package com.dkharchenko_hillel.homework4.services;

import com.dkharchenko_hillel.homework4.models.Cart;

import java.util.List;

public interface CartService {
    Long addCartByPersonId(Long personId);

    Long removeCartById(Long id);

    Cart getCartById(Long id);

    List<Cart> getAllCarts();

    Cart addProductByProductId(Long cartId, Long productId);

    Cart removeProductByProductId(Long cartId, Long productId);

    Long removeAllProductsById(Long id);

}
