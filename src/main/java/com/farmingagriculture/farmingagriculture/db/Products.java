package com.farmingagriculture.farmingagriculture.db;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Table(name = "products")
@Entity
//@Data
public class Products {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long productId;

    @Column(name = "p_name")
    private String productName;
    @Column(name = "p_type")
    private String productType;
    @Column(name = "p_image")
    private String productImage;
    @Column(name = "p_qty")
    private String productQty;
    @Column(name = "p_cost")
    private String productCost;
    @Column(name = "p_added_by")
    private String productAddedBy;
    @Column(name = "p_added_by_id")
    private String productAddedById;
    @ManyToMany
    @JoinTable(
            name = "consumer",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "consumer_id"))
    Set<Consumers> consumer;

    @ManyToMany
    @JoinTable(
            name = "farmers",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "farmerId"))
    Set<Farmer> farmers;

    @ManyToMany
    @JoinTable(
            name = "shopKeepers",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "shopKeeperId"))
    Set<Farmer> shopKeepers;

    @ManyToMany
    @JoinTable(
            name = "suppliers",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "supplierId"))
    Set<Supplier> suppliers;

    @ManyToMany
    @JoinTable(
            name = "wholeSellers",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "wholeSellerId"))
    Set<WholeSeller> wholeSellers;

    @ManyToMany
    @JoinTable(
            name = "order",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    Set<Orders> orders;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
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

    public Set<Consumers> getConsumer() {
        return consumer;
    }

    public void setConsumer(Set<Consumers> consumer) {
        this.consumer = consumer;
    }

    public Set<Farmer> getFarmers() {
        return farmers;
    }

    public void setFarmers(Set<Farmer> farmers) {
        this.farmers = farmers;
    }

    public Set<Farmer> getShopKeepers() {
        return shopKeepers;
    }

    public void setShopKeepers(Set<Farmer> shopKeepers) {
        this.shopKeepers = shopKeepers;
    }

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public Set<WholeSeller> getWholeSellers() {
        return wholeSellers;
    }

    public void setWholeSellers(Set<WholeSeller> wholeSellers) {
        this.wholeSellers = wholeSellers;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }
}