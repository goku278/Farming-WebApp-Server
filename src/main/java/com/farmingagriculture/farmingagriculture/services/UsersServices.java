package com.farmingagriculture.farmingagriculture.services;

import com.farmingagriculture.farmingagriculture.db.*;
import com.farmingagriculture.farmingagriculture.mapper.ModelToEntity;
import com.farmingagriculture.farmingagriculture.model.SignIn;
import com.farmingagriculture.farmingagriculture.model.SignUp;
import com.farmingagriculture.farmingagriculture.model.Status;
import com.farmingagriculture.farmingagriculture.model.User;
import com.farmingagriculture.farmingagriculture.repo.AdressRepo;
import com.farmingagriculture.farmingagriculture.repo.SupplierRepo;
import com.farmingagriculture.farmingagriculture.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class UsersServices {
    @Autowired
    UsersRepo usersRepo;
    @Autowired
    AdressRepo adressRepo;
    @Autowired
    SupplierRepo supplierRepo;

    @Autowired
    ModelToEntity map;

    public String signUp(SignUp signUp) {
        Users u = new Users();
        List<Users> u1 = usersRepo.findUserByMobileAndEmail(signUp.getMobile(), signUp.getEmail());
        if (u1.size() == 0) {
            u.setUserName(signUp.getName());
            u.setUserEmail(signUp.getEmail());
            u.setUserMobile(signUp.getMobile());
            u.setUserRole(signUp.getRole());
            u.setProfilePic(signUp.getImage());
            Users savedUsers = usersRepo.save(u);
            UserAddress ua = new UserAddress();
            ua.setStreetName(signUp.getStreetName());
            ua.setPinCode(signUp.getPinCode());
            ua.setStateUt(signUp.getState());
            ua.setLandMark(signUp.getLandMark());
            ua.setUser(u);
            savedUsers.setAddress(ua);
            usersRepo.save(savedUsers);
            if (signUp.getRole().equalsIgnoreCase("SUPPLIER")) {
                Supplier s = new Supplier();
                savedUsers.setSupplier(s);
                usersRepo.save(savedUsers);
            } else if (signUp.getRole().equalsIgnoreCase("FARMER")) {
                Farmer f = new Farmer();
                savedUsers.setFarmer(f);
                usersRepo.save(savedUsers);
            } else if (signUp.getRole().equalsIgnoreCase("WHOLE SELLER")) {
                WholeSeller ws = new WholeSeller();
                savedUsers.setWholeSeller(ws);
                usersRepo.save(savedUsers);
            } else if (signUp.getRole().equalsIgnoreCase("CONSUMER")) {
                Consumers c = new Consumers();
                savedUsers.setConsumers(c);
                usersRepo.save(savedUsers);
            } else if (signUp.getRole().equalsIgnoreCase("SHOP KEEPER")) {
                ShopKeeper sk = new ShopKeeper();
                savedUsers.setShopKeeper(sk);
                usersRepo.save(savedUsers);
            }
            return "User successfully registered";
        }
        return "User with same mobile number and email already exists!";
    }

    public Status signIn(SignIn signIn) {
        String mobile = signIn.getUserId().trim();
        String email = signIn.getPassword().trim();
        List<Users> u = new ArrayList<>();
        if (mobile != null && email != null) {
            u = usersRepo.findUserByMobileAndEmail(mobile, email);
        }
        Status status = new Status();
        if (u != null && u.size() > 0) {
            Users u1 = u.get(0);
            u1.setIsOnline("YES");
            usersRepo.save(u1);
            System.out.println("user ====> " + u1);
//            return "SignIn successful!";
            status.setCode("200");
            status.setMessage("SignIn successful!");
            status.setUserId(u1.getUserId()+"");
            status.setUserRole(u1.getUserRole());
            System.out.println("status ====> " + status);
//            return new Status("200","SignIn successful!", u1.getUserId()+"",u1.getUserRole());
            return status;
        }
//        return "SignIn not successful!";
//        return new Status("500","SignIn not successful!","","");
        status.setCode("200");
        status.setMessage("SignIn not successful!");
        status.setUserId("");
        status.setUserRole("");
        return status;
    }

    public User getUserProfileDetails(Long userId) {
        Users u = usersRepo.getProfileDetailsByUserId(userId);
        UserAddress userAddress = adressRepo.getAddressByUserId(userId);
        User user = new User();
        user.setEmail(u.getUserEmail());
        user.setLandMark(userAddress.getLandMark());
        user.setPinCode(userAddress.getPinCode());
        user.setLandMark(userAddress.getLandMark());
        user.setStreetName(userAddress.getStreetName());
        user.setImageUrl(user.getImageUrl());
        user.setRole(u.getUserRole());
        user.setName(u.getUserName());
        user.setState(userAddress.getStateUt());
        return user;
    }
    public Status logOut(Long userId) {
        Users u = usersRepo.findById(userId).orElse(null);
        if (u != null) {
            if (u.getIsOnline().equalsIgnoreCase("yes")) {
                u.setIsOnline("NO");
                usersRepo.save(u);
            }
        }
//        return "User logged out successfully!";
        return new Status("200","User logged out successfully!","","");
    }
    public Set<Status> customers(Long id) {
        String role = usersRepo.findById(id).orElse(null).getUserRole();
        Set<Status> s = new LinkedHashSet<>();
        if (role != null && !role.equals("")) {
            if (role.equals("WHOLE SELLER")) {
                role = "SHOPKEEPER";
            }
            else if (role.equals("SHOP KEEPER")) {
                role = "CONSUMER";
            }
            else if (role.equals("SUPPLIER")) {
                role = "FARMER";
            }
            List<Users> u = usersRepo.findUsersByRole(role);
            if (u != null) {
                for (Users u1 : u) {
                    Status s1= new Status();
                    s1.setMessage(u1.getUserName());
                    s.add(s1);
                }
            }
        }
        return s;
    }
}