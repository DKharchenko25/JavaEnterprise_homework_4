package com.dkharchenko_hillel.homework4.controllers;

import com.dkharchenko_hillel.homework4.models.Shop;
import com.dkharchenko_hillel.homework4.services.ShopService;
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
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Long> addShop(@RequestBody String name) {
        return new ResponseEntity<>(shopService.addShop(name), HttpStatus.OK);
    }

    @DeleteMapping(value = "/remove")
    @Transactional
    public ResponseEntity<Long> removeShopById(@RequestParam Long id) {
        return new ResponseEntity<>(shopService.removeShopById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/shop")
    public ResponseEntity<Shop> getShopById(@RequestParam Long id) {
        return new ResponseEntity<>(shopService.getShopById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Shop>> getAllShops() {
        return new ResponseEntity<>(shopService.getAllShops(), HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    @Transactional
    public ResponseEntity<Long> updateShopNameById(@RequestParam Long id, @RequestBody String name) {
        return new ResponseEntity<>(shopService.updateShopNameById(id, name), HttpStatus.OK);
    }
}
