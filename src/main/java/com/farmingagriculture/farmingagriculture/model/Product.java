package com.farmingagriculture.farmingagriculture.model;
public class Product {

    private String productId;
    private String productName;
    private String productType;
    private String productImage;
    private String productQty;
    private String productCost;
    private String productAddedBy;
    private String productAddedById;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

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

    public String getProductAddedBy() {
        return productAddedBy;
    }

    public void setProductAddedBy(String productAddedBy) {
        this.productAddedBy = productAddedBy;
    }

    public String getProductAddedById() {
        return productAddedById;
    }

    public void setProductAddedById(String productAddedById) {
        this.productAddedById = productAddedById;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productQty='" + productQty + '\'' +
                ", productCost='" + productCost + '\'' +
                ", productAddedBy='" + productAddedBy + '\'' +
                ", productAddedById='" + productAddedById + '\'' +
                '}';
    }
}