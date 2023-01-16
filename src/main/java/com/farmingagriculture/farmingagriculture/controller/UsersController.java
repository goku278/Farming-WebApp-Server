package com.farmingagriculture.farmingagriculture.controller;

import com.farmingagriculture.farmingagriculture.model.SignIn;
import com.farmingagriculture.farmingagriculture.model.SignUp;
import com.farmingagriculture.farmingagriculture.model.Status;
import com.farmingagriculture.farmingagriculture.model.User;
import com.farmingagriculture.farmingagriculture.repo.UsersRepo;
import com.farmingagriculture.farmingagriculture.services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/farm/api/users/")
@CrossOrigin(origins = "*")
public class UsersController {
    @Autowired
    UsersServices usersServices;
    @Autowired
    private UsersRepo usersRepo;

    @PutMapping("signUp/")
    public String signUp(@RequestBody SignUp signUp) {
        System.out.println("SignUp model =====> " + signUp);
        return usersServices.signUp(signUp);
    }

    @PostMapping("signIn/")
    public Status signIn(@RequestBody SignIn signIn) {
        System.out.println("SignIn ====> " + signIn);
        return usersServices.signIn(signIn);
    }

    @GetMapping("profile/{userId}/")
    public User getProfileDetails(@PathVariable Long userId) {
        return usersServices.getUserProfileDetails(userId);
    }

    @GetMapping("logout/{userId}/")
    public Status logOut(@PathVariable Long userId) {
        return usersServices.logOut(userId);
    }

    @GetMapping("customers/{id}/")
    public Set<Status> customers(@PathVariable Long id) {
        return usersServices.customers(id);
    }
}