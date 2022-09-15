package com.dkharchenko_hillel.homework4.services;

import com.dkharchenko_hillel.homework4.models.Shop;

import java.util.List;

public interface ShopService {
    Long addShop(String name);

    Long removeShopById(Long id);

    Shop getShopById(Long id);

    List<Shop> getAllShops();

    Long updateShopNameById(Long id, String name);
}
