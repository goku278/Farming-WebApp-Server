package com.farmingagriculture.farmingagriculture.db;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Table(name = "users")
@Entity
//@Data
public class Users {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long userId;
    @Column(name = "name")
    private String userName;
    @Column(name = "email")
    private String userEmail;
    @Column(name = "image")
    private String profilePic;
    @Column(name = "mobile")
    private String userMobile;
    @Column(name = "role")
    private String userRole;
    @Column(name = "is_online")
    private String isOnline;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private UserAddress address;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    @JsonBackReference
    private Supplier supplier;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "farmer_id")
    @JsonBackReference
    private Farmer farmer;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "whole_seller_id")
    @JsonBackReference
    private WholeSeller wholeSeller;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "consumer_id")
    @JsonBackReference
    private Consumers consumers;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_keeper_id")
    @JsonBackReference
    private ShopKeeper shopKeeper;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(String isOnline) {
        this.isOnline = isOnline;
    }

    public UserAddress getAddress() {
        return address;
    }

    public void setAddress(UserAddress address) {
        this.address = address;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    public WholeSeller getWholeSeller() {
        return wholeSeller;
    }

    public void setWholeSeller(WholeSeller wholeSeller) {
        this.wholeSeller = wholeSeller;
    }

    public Consumers getConsumers() {
        return consumers;
    }

    public void setConsumers(Consumers consumers) {
        this.consumers = consumers;
    }

    public ShopKeeper getShopKeeper() {
        return shopKeeper;
    }

    public void setShopKeeper(ShopKeeper shopKeeper) {
        this.shopKeeper = shopKeeper;
    }
}
