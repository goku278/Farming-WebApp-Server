package com.farmingagriculture.farmingagriculture.model;

public class SignUp {
    private String name;
    private String email;
    private String role;
    private String mobile;
    private String streetName;
    private String pinCode;
    private String state;
    private String landMark;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    @Override
    public String toString() {
        return "SignUp{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", mobile='" + mobile + '\'' +
                ", streetName='" + streetName + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", state='" + state + '\'' +
                ", landMark='" + landMark + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}