package com.farmingagriculture.farmingagriculture.mapper;

import com.farmingagriculture.farmingagriculture.db.UserAddress;
import com.farmingagriculture.farmingagriculture.db.Users;
import com.farmingagriculture.farmingagriculture.model.SignUp;
import org.springframework.stereotype.Component;

@Component
public class ModelToEntity {
    public Users signUpToUsers(SignUp signUp) {
        Users u = new Users();
        u.setUserName(signUp.getName());
        u.setUserEmail(signUp.getEmail());
        u.setUserMobile(signUp.getMobile());
        u.setUserRole(signUp.getRole());
        UserAddress ua = new UserAddress();
        ua.setStreetName(signUp.getStreetName());
        ua.setPinCode(signUp.getPinCode());
        ua.setStateUt(signUp.getState());
        ua.setLandMark(signUp.getLandMark());
        u.setAddress(ua);
        return u;
    }
}
