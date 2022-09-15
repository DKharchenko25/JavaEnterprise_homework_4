package com.dkharchenko_hillel.homework4.services;


import com.dkharchenko_hillel.homework4.dtos.ProductDto;
import com.dkharchenko_hillel.homework4.models.Product;

import java.util.List;

public interface ProductService {
    Long addProduct(ProductDto dto);

    Long removeProductById(Long id);

    Product getProductById(Long id);

    List<Product> getAllProducts();

    Long updateProductNameById(Long id, ProductDto dto);

    Long updateProductPriceById(Long id, ProductDto dto);
}
