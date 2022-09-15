package com.dkharchenko_hillel.homework4.services;

import com.dkharchenko_hillel.homework4.NotFoundException;
import com.dkharchenko_hillel.homework4.models.Shop;
import com.dkharchenko_hillel.homework4.reposiroties.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    public ShopServiceImpl(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public Long addShop(String name) {
        return shopRepository.save(new Shop(name)).getId();
    }

    @Override
    public Long removeShopById(Long id) {
        if (shopRepository.existsById(id)) {
            shopRepository.deleteById(id);
            return id;
        }
        try {
            throw new NotFoundException("Shop with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Shop getShopById(Long id) {
        if (shopRepository.findById(id).isPresent()) {
            return shopRepository.findById(id).get();
        }
        try {
            throw new NotFoundException("Shop with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public List<Shop> getAllShops() {
        return (List<Shop>) shopRepository.findAll();
    }

    @Override
    public Long updateShopNameById(Long id, String name) {
        if (shopRepository.existsById(id)) {
            return Long.valueOf(shopRepository.updateNameById(id, name));
        }
        try {
            throw new NotFoundException("Shop with ID #" + id + " is not found");
        } catch (NotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
