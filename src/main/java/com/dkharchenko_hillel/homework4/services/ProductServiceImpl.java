package com.dkharchenko_hillel.homework4.services;

import com.dkharchenko_hillel.homework4.NotFoundException;
import com.dkharchenko_hillel.homework4.dtos.ProductDto;
import com.dkharchenko_hillel.homework4.models.Product;
import com.dkharchenko_hillel.homework4.reposiroties.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ShopService shopService;

    public ProductServiceImpl(ProductRepository productRepository, ShopService shopService) {
        this.productRepository = productRepository;
        this.shopService = shopService;
    }

    @Override
    public Long addProduct(ProductDto dto) {
        Product product = new Product(dto.getName(), dto.getPrice());
        product.setShop(shopService.getShopById(dto.getShopId()));
        shopService.getShopById(dto.getShopId()).getProducts().add(product);
        return productRepository.save(product).getId();
    }

    @Override
    public Long removeProductById(Long id) {
        if (productRepository.existsById(id)) {
            shopService.getShopById(id).getProducts().remove(getProductById(id));
            productRepository.deleteById(id);
            return id;
        }
        try {
            throw new NotFoundException("Product with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Product getProductById(Long id) {
        if (productRepository.findById(id).isPresent()) {
            return productRepository.findById(id).get();
        }
        try {
            throw new NotFoundException("Product with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Long updateProductNameById(Long id, ProductDto dto) {
        if (productRepository.existsById(id)) {
            return Long.valueOf(productRepository.updateProductNameById(id, dto.getName()));
        }
        try {
            throw new NotFoundException("Product with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Long updateProductPriceById(Long id, ProductDto dto) {
        if (productRepository.existsById(id)) {
            return Long.valueOf(productRepository.updateProductSumById(id, dto.getPrice()));
        }
        try {
            throw new NotFoundException("Product with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
