package com.dkharchenko_hillel.homework4.controllers;

import com.dkharchenko_hillel.homework4.dtos.ProductDto;
import com.dkharchenko_hillel.homework4.models.Product;
import com.dkharchenko_hillel.homework4.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Long> addProduct(@RequestBody ProductDto dto) {
        return new ResponseEntity<>(productService.addProduct(dto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/remove")
    @Transactional
    public ResponseEntity<Long> removeProductById(@RequestParam Long id) {
        return new ResponseEntity<>(productService.removeProductById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/product")
    public ResponseEntity<Product> getProductById(@RequestParam Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PutMapping(value = "/update-name")
    @Transactional
    public ResponseEntity<Long> updateProductNameById(@RequestParam Long id, @RequestBody ProductDto dto) {
        return new ResponseEntity<>(productService.updateProductNameById(id, dto), HttpStatus.OK);
    }

    @PutMapping(value = "/update-price")
    @Transactional
    public ResponseEntity<Long> updateProductPriceById(@RequestParam Long id, @RequestBody ProductDto dto) {
        return new ResponseEntity<>(productService.updateProductPriceById(id, dto), HttpStatus.OK);
    }
}
