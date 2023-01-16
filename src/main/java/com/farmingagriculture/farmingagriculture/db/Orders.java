package com.farmingagriculture.farmingagriculture.db;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Table(name = "orders")
@Entity
//@Data
public class Orders {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long orderId;
    @Column(name = "buyer_id")
    private Long buyerId;
    @Column(name = "buyer_type")
    private String buyerType;
    @Column(name = "seller_id")
    private Long sellerId;
    @Column(name = "seller_type")
    private String sellerType;
    @Column(name = "productt_id")
    private Long pId;
    @Column(name = "order_status")
    private String orderStatus; // for ex. order_placed, order_cancelled, order-shipped by the seller, etc...
    @Column(name = "cart_status")
    private String cartStatus; // A message if user has added any item to the cart.
    @Column(name = "cart_id")
    private String cartId;
    @ManyToMany(mappedBy = "orders")
    Set<Products> products;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerType() {
        return buyerType;
    }

    public void setBuyerType(String buyerType) {
        this.buyerType = buyerType;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerType() {
        return sellerType;
    }

    public void setSellerType(String sellerType) {
        this.sellerType = sellerType;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(String cartStatus) {
        this.cartStatus = cartStatus;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Set<Products> getProducts() {
        return products;
    }

    public void setProducts(Set<Products> products) {
        this.products = products;
    }
}