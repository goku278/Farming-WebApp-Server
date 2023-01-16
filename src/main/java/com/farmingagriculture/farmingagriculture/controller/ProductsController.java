package com.farmingagriculture.farmingagriculture.controller;

import com.farmingagriculture.farmingagriculture.model.Product;
import com.farmingagriculture.farmingagriculture.model.Status;
import com.farmingagriculture.farmingagriculture.repo.ProductsRepo;
import com.farmingagriculture.farmingagriculture.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farm/api/users/")
@CrossOrigin(origins = "*")
public class ProductsController {
    @Autowired
    ProductServices ps;
    @Autowired
    private ProductsRepo productsRepo;

    @PostMapping("addProducts/")
    public Status addProducts(@RequestBody Product products) {
        return ps.addProducts(products);
    }

    @GetMapping("allProducts/{userType}/")
    public List<Product> getAllProductItems(@PathVariable String userType) {
        System.out.println("userType ::" + userType);
        return ps.getAllProductItems(userType.trim());
    }

    @GetMapping("products/{userId}/")
    public List<Product> getAllProductsByUserId(@PathVariable String userId) {
        return ps.getAllProductItemsByUserId(userId.trim());
    }
}