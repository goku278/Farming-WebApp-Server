package com.farmingagriculture.farmingagriculture.services;

import com.farmingagriculture.farmingagriculture.db.Products;
import com.farmingagriculture.farmingagriculture.model.Product;
import com.farmingagriculture.farmingagriculture.model.Status;
import com.farmingagriculture.farmingagriculture.repo.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServices {
    @Autowired
    ProductsRepo productsRepo;

    public Status addProducts(Product products) {
        Products p = new Products();
        p.setProductAddedBy(products.getProductAddedBy());
        p.setProductAddedById(products.getProductAddedById());
        p.setProductCost(products.getProductCost());
        p.setProductName(products.getProductName());
        p.setProductType(products.getProductType());
        p.setProductImage(products.getProductImage());
        p.setProductCost(products.getProductCost());
        p.setProductQty(products.getProductQty());
        productsRepo.save(p);
        return new Status("200", "Product added successfully!", "", "");
    }

    public List<Product> getAllProductItems(String userType) {
        String originalUserType = userType;
        if (userType.equalsIgnoreCase("FARMER")) {
            userType = "SUPPLIER";
        } else if (userType.equalsIgnoreCase("WHOLE SELLER")) {
            userType = "FARMER";
        } else if (userType.equalsIgnoreCase("SHOP KEEPER") || userType.equalsIgnoreCase("SHOPKEEPER")) {
            userType = "FARMER";
        } else if (userType.equalsIgnoreCase("CONSUMER")) {
            userType = "FARMER";
        }
        List<Products> getAllProductItemsByUserType = productsRepo.getAllProductItemsByUserType(userType);
        List<Product> product = new ArrayList<>();
        double cost[] = new double[4];
        cost[0] = 50d;
        cost[1] = 75d;
        cost[2] = 100d;
        for (Products p : getAllProductItemsByUserType) {
            Product p1 = new Product();
            double c = 1d;
            p1.setProductId(String.valueOf(p.getProductId()));
            p1.setProductName(p.getProductName());
            p1.setProductType(p.getProductType());
            p1.setProductImage(p.getProductImage());
            p1.setProductQty(p.getProductQty());
            if (originalUserType.equals("WHOLE SELLER")) {
                c = c * cost[0];
            } else if (originalUserType.equals("SHOP KEEPER") || originalUserType.equals("SHOPKEEPER")) {
                c = c * cost[1];
            } else if (originalUserType.equals("CONSUMER")) {
                c = c * cost[2];
            }
            if (p.getProductCost() != null) {
                double t = c * Double.parseDouble(p.getProductCost());
                p1.setProductCost(t + "");
            }
            p1.setProductAddedBy(p.getProductAddedBy());
            p1.setProductAddedById(p.getProductAddedById());
            product.add(p1);
        }
        return product;
    }
    public List<Product> getAllProductItemsByUserId(String userId) {
        System.out.println("userId :::: " + userId);
        List<Products> getAllProductItemsByUserId = productsRepo.getAllProductItemsByUserId(userId);
        System.out.println("getAllProductItemsByUserId ::::" + getAllProductItemsByUserId);
        List<Product> product = new ArrayList<>();
        for (Products p : getAllProductItemsByUserId) {
            Product p1 = new Product();
            p1.setProductName(p.getProductName());
            p1.setProductType(p.getProductType());
            p1.setProductImage(p.getProductImage());
            p1.setProductQty(p.getProductQty());
            p1.setProductCost(p.getProductCost());
            p1.setProductAddedBy(p.getProductAddedBy());
            p1.setProductAddedById(p.getProductAddedById());
            product.add(p1);
        }
        return product;
    }
}