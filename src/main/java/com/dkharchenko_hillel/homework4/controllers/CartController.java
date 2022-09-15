package com.dkharchenko_hillel.homework4.controllers;

import com.dkharchenko_hillel.homework4.models.Cart;
import com.dkharchenko_hillel.homework4.services.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Long> addCartByPersonId(@RequestParam Long id) {
        return new ResponseEntity<>(cartService.addCartByPersonId(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/remove")
    @Transactional
    public ResponseEntity<Long> removeCartById(@RequestParam Long id) {
        return new ResponseEntity<>(cartService.removeCartById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/cart")
    public ResponseEntity<Cart> getCartById(@RequestParam Long id) {
        return new ResponseEntity<>(cartService.getCartById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Cart>> getAllCarts() {
        return new ResponseEntity<>(cartService.getAllCarts(), HttpStatus.OK);
    }

    @PutMapping(value = "/cart-{cartId}/add-product")
    @Transactional
    public ResponseEntity<Cart> addProductByProductId(@PathVariable Long cartId, @RequestParam Long productId) {
        return new ResponseEntity<>(cartService.addProductByProductId(cartId, productId), HttpStatus.OK);
    }

    @PutMapping(value = "/cart-{cartId}/remove-product")
    @Transactional
    public ResponseEntity<Cart> removeAllProductsById(@PathVariable Long cartId, @RequestParam Long productId) {
        return new ResponseEntity<>(cartService.removeProductByProductId(cartId, productId), HttpStatus.OK);
    }

    @PutMapping(value = "/cart-{cartId}/remove-all")
    @Transactional
    public ResponseEntity<Long> removeAllProductsById(@PathVariable Long cartId) {
        return new ResponseEntity<>(cartService.removeAllProductsById(cartId), HttpStatus.OK);
    }
}
