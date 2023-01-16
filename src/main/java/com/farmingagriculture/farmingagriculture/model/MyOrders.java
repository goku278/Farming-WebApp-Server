package com.farmingagriculture.farmingagriculture.model;

public class MyOrders {
    private String orderId;
    private String productName;
    private String productImage;
    private String productCost;
    private String userAddress;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductCost() {
        return productCost;
    }

    public void setProductCost(String productCost) {
        this.productCost = productCost;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return "MyOrders{" +
                "orderId='" + orderId + '\'' +
                ", productName='" + productName + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productCost='" + productCost + '\'' +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }
}