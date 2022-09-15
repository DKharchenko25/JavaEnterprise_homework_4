package com.dkharchenko_hillel.homework4.services;

import com.dkharchenko_hillel.homework4.NotFoundException;
import com.dkharchenko_hillel.homework4.models.Cart;
import com.dkharchenko_hillel.homework4.models.Product;
import com.dkharchenko_hillel.homework4.reposiroties.CartRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final PersonService personService;
    private final ProductService productService;

    public CartServiceImpl(CartRepository cartRepository, PersonService personService, ProductService productService) {
        this.cartRepository = cartRepository;
        this.personService = personService;
        this.productService = productService;
    }

    @Override
    public Long addCartByPersonId(Long personId) {
        Cart cart = new Cart(personService.getPersonById(personId));
        personService.getPersonById(personId).getCarts().add(cart);
        return cartRepository.save(cart).getId();
    }

    @Override
    public Long removeCartById(Long id) {
        if (cartRepository.findById(id).isPresent()) {
            Cart cart = cartRepository.findById(id).get();
            personService.getPersonById(cart.getPerson().getId()).getCarts().remove(cart);
            cartRepository.deleteById(id);
            return id;
        }
        try {
            throw new NotFoundException("Cart with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Cart getCartById(Long id) {
        if (cartRepository.findById(id).isPresent()) {
            return cartRepository.findById(id).get();
        }
        try {
            throw new NotFoundException("Cart with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<Cart> getAllCarts() {
        return (List<Cart>) cartRepository.findAll();
    }

    @Override
    public Cart addProductByProductId(Long cartId, Long productId) {
        Cart cart = cartRepository.findById(cartId).get();
        Product product = productService.getProductById(productId);
        checkContainsProduct(cart, product);
        if (cartRepository.findById(cartId).isPresent()) {
            cart.getProducts().add(product);
            increaseAmountAndSum(cart, product);
            return cartRepository.findById(cartId).get();
        }
        try {
            throw new NotFoundException("Cart with ID #" + cartId + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Cart removeProductByProductId(Long cartId, Long productId) {
        Cart cart = cartRepository.findById(cartId).get();
        Product product = productService.getProductById(productId);
        checkNotContainsProduct(cart, product);
        if (cartRepository.findById(cartId).isPresent()) {
            cart.getProducts().remove(product);
            decreaseAmountAndSum(cart, product);
            return cartRepository.findById(cartId).get();
        }
        try {
            throw new NotFoundException("Cart with ID #" + cartId + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Long removeAllProductsById(Long id) {
        if (cartRepository.findById(id).isPresent()) {
            Cart cart = cartRepository.findById(id).get();
            cart.getProducts().clear();
            cart.setSum(new BigDecimal("0.00"));
            cart.setAmountOfProducts(0);
            return id;
        }
        try {
            throw new NotFoundException("Cart with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private void checkNotContainsProduct(Cart cart, Product product) {
        if (!cart.getProducts().contains(product)) {
            try {
                throw new NotFoundException("Cart don't contains product with ID #" + product.getId());
            } catch (NotFoundException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    private void checkContainsProduct(Cart cart, Product product) {
        if (cart.getProducts().contains(product)) {
            try {
                throw new NotFoundException("Cart is already contains product with ID #" + product.getId());
            } catch (NotFoundException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    private void increaseAmountAndSum(Cart cart, Product product) {
        cart.setAmountOfProducts(cart.getAmountOfProducts() + 1);
        cart.setSum(cart.getSum().add(BigDecimal.valueOf(product.getPrice())));
    }

    private void decreaseAmountAndSum(Cart cart, Product product) {
        if (cart.getSum().compareTo(new BigDecimal("0.00")) != 0
                && cart.getAmountOfProducts().compareTo(0) != 0) {
            cart.setAmountOfProducts(cart.getAmountOfProducts() - 1);
            cart.setSum(cart.getSum().subtract(BigDecimal.valueOf(product.getPrice())));
        } else {
            cart.setSum(new BigDecimal("0.00"));
            cart.setAmountOfProducts(0);
        }
    }
}
