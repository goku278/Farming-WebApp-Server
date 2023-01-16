package com.farmingagriculture.farmingagriculture.controller;

import com.farmingagriculture.farmingagriculture.model.MyOrders;
import com.farmingagriculture.farmingagriculture.model.Orderr;
import com.farmingagriculture.farmingagriculture.model.Status;
import com.farmingagriculture.farmingagriculture.repo.OrdersRepo;
import com.farmingagriculture.farmingagriculture.services.OrdersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.Stack;

@RestController
@RequestMapping("/farm/api/users/")
@CrossOrigin(origins = "*")
public class OrdersController {
    @Autowired
    OrdersServices ordersServices;
    @Autowired
    private OrdersRepo ordersRepo;

    @PostMapping("placeOrder/{type}/")
    public Status placeOrder(@RequestBody Orderr order, @PathVariable String type) {
        return ordersServices.placeOrder(order, type);
    }

    @GetMapping("myOrders/{id}/{type}/")
    public Set<MyOrders> myOrders(@PathVariable Long id, @PathVariable String type) {
        return ordersServices.myOrders(id, type);
    }
}