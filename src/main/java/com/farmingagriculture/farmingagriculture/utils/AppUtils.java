package com.farmingagriculture.farmingagriculture.utils;

import com.farmingagriculture.farmingagriculture.model.Orderr;

public class AppUtils {
    public static String checkNull(Orderr order) {
        if (order.getBuyerId() == null || order.getBuyerId().trim().equals("")) {
            return "Buyer Id is empty!";
        }
//        else if (order.getBuyerType() == null || order.getBuyerType().trim().equals("")) {
//            return "Buyer Type is empty!";
//        }
        else if (order.getSellerId() == null || order.getSellerId().trim().equals("")) {
            return "Seller Id is empty";
        }
//        else if (order.getSellerType() == null || order.getSellerType().trim().equals("")) {
//            return "Seller Type is empty";
//        }
        else if (order.getProductId() == null || order.getProductId().trim().equals("")) {
            return "Product Id is empty";
        }
      /*  else if (order.getProductType() == null || order.getProductType().trim().equals("")) {
            return "Product Type is empty";
        }
        else if (order.getProductImage() == null || order.getProductImage().trim().equals("")) {
            return "Product Image is empty";
        }
        else if (order.getProductQty() == null || order.getProductQty().trim().equals("")) {
            return "Product Quantity is empty";
        }
        else if (order.getProductCost() == null || order.getProductCost().trim().equals("")) {
            return "Product Cost is empty";
        }*/
        return "";
    }
}