package com.farmingagriculture.farmingagriculture.db;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Table(name = "address")
@Entity
//@Data
public class UserAddress {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long addressId;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "pin_code")
    private String pinCode;
    @Column(name = "state_ut")
    private String stateUt;
    @Column(name = "land_mark")
    private String landMark;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private Users user;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getStateUt() {
        return stateUt;
    }

    public void setStateUt(String stateUt) {
        this.stateUt = stateUt;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
