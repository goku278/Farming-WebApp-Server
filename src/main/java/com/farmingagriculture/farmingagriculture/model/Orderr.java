package com.farmingagriculture.farmingagriculture.model;

public class Orderr {
    private String buyerId;
//    private String buyerType;
    private String sellerId;
//    private String sellerType;
    private String productId;
//    private String productName;
//    private String productType;
//    private String productImage;
//    private String productQty;
//    private String productCost;

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

/*    public String getBuyerType() {
        return buyerType;
    }

    public void setBuyerType(String buyerType) {
        this.buyerType = buyerType;
    }*/

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

   /* public String getSellerType() {
        return sellerType;
    }

    public void setSellerType(String sellerType) {
        this.sellerType = sellerType;
    }*/

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

/*
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductQty() {
        return productQty;
    }

    public void setProductQty(String productQty) {
        this.productQty = productQty;
    }

    public String getProductCost() {
        return productCost;
    }

    public void setProductCost(String productCost) {
        this.productCost = productCost;
    }
*/

/*    @Override
    public String toString() {
        return "Orderr{" +
                "buyerId='" + buyerId + '\'' +
                ", buyerType='" + buyerType + '\'' +
                ", sellerId='" + sellerId + '\'' +
                ", sellerType='" + sellerType + '\'' +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productQty='" + productQty + '\'' +
                ", productCost='" + productCost + '\'' +
                '}';
    }*/

  /*  @Override
    public String toString() {
        return "Orderr{" +
                "buyerId='" + buyerId + '\'' +
                ", buyerType='" + buyerType + '\'' +
                ", sellerId='" + sellerId + '\'' +
                ", sellerType='" + sellerType + '\'' +
                ", productId='" + productId + '\'' +
                '}';
    }*/

    @Override
    public String toString() {
        return "Orderr{" +
                "buyerId='" + buyerId + '\'' +
                ", sellerId='" + sellerId + '\'' +
                ", productId='" + productId + '\'' +
                '}';
    }
}