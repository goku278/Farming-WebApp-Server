package com.farmingagriculture.farmingagriculture.services;

import com.farmingagriculture.farmingagriculture.db.Orders;
import com.farmingagriculture.farmingagriculture.db.Products;
import com.farmingagriculture.farmingagriculture.db.UserAddress;
import com.farmingagriculture.farmingagriculture.db.Users;
import com.farmingagriculture.farmingagriculture.model.MyOrders;
import com.farmingagriculture.farmingagriculture.model.Orderr;
import com.farmingagriculture.farmingagriculture.model.Status;
import com.farmingagriculture.farmingagriculture.repo.OrdersRepo;
import com.farmingagriculture.farmingagriculture.repo.ProductsRepo;
import com.farmingagriculture.farmingagriculture.repo.UsersRepo;
import com.farmingagriculture.farmingagriculture.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrdersServices {
    @Autowired
    OrdersRepo ordersRepo;
    @Autowired
    ProductsRepo productsRepo;
    @Autowired
    UsersRepo usersRepo;

    public Status placeOrder(Orderr order, String type) {
        String data = AppUtils.checkNull(order);
        if (!data.equals("")) {
            return new Status("500", data, "", "");
        } else {
            Orders o = new Orders();
            if (type.equalsIgnoreCase("order")) {
                o.setOrderStatus("Order is placed successfully");
                o.setCartStatus("");
            } else if (type.equalsIgnoreCase("cart")) {
                o.setCartId(UUID.randomUUID().toString());
                o.setCartStatus("Added To Cart");
                o.setOrderStatus("");
            }
            String buyerRole = usersRepo.findRoleById(order.getBuyerId());
            String sellerRole = usersRepo.findRoleById(order.getSellerId());

            o.setBuyerId(Long.parseLong(order.getBuyerId()));
            o.setBuyerType(buyerRole);
            o.setSellerId(Long.valueOf(order.getSellerId()));
            o.setSellerType(sellerRole);
            o.setpId(Long.parseLong(order.getProductId()));

            Products p = productsRepo.findById(Long.valueOf(order.getProductId())).orElse(null);
            if (p == null) {
                return new Status("500", "Product with id " + order.getProductId() + " not found", "", "");
            }
            Set<Products> productsSet = new LinkedHashSet<>();
            productsSet.add(p);
            o.setProducts(productsSet);
            ordersRepo.save(o);
            String msg = "";
            if (type.equalsIgnoreCase("order")) {
                msg = "Order placed successfully!";
            } else if (type.equalsIgnoreCase("cart")) {
                msg = "Added To Cart!";
            }
            return new Status("200", msg, "", "");
        }
    }
    public Set<MyOrders> myOrders(Long id, String type) {
        List<Orders> o = new ArrayList<>();
        if (type.equalsIgnoreCase("order")) {
            o = ordersRepo.findOrderById(id, "");
        }
        else if (type.equalsIgnoreCase("cart")) {
            o = ordersRepo.findOrderById(id, "Order is placed successfully");
        }
        Users u = usersRepo.findById(id).orElse(null);
        String address = "", pName = "", pImage = "", pCost = "";
        Set<MyOrders> myOrders = new LinkedHashSet<>();
        if (u != null) {
            UserAddress ua = u.getAddress();
            address = ua.getLandMark() + ", " + ua.getPinCode() + ", " + ua.getStreetName();
            for (Orders o1: o) {
                MyOrders mo = new MyOrders();
                long productId = Long.MIN_VALUE;
                if (o1.getpId() != null) {
                    productId = o1.getpId();
                    Products p = productsRepo.findById(productId).orElse(null);
                    pName = p.getProductName();
                    pImage = p.getProductImage();
                    pCost = p.getProductCost();
                }
                mo.setOrderId(o1.getOrderId()+"");
                mo.setProductName(pName);
                mo.setProductImage(pImage);
                mo.setProductCost(pCost);
                mo.setUserAddress(address);
                myOrders.add(mo);
            }
        }
        return myOrders;
    }
}