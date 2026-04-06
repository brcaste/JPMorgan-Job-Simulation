package com.jpmc.midascore.controller;

import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.foundation.Balance;
import com.jpmc.midascore.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/balance")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;

    }
    @GetMapping
    public Balance getUserCurrentBalance(@RequestParam("userId") Long userId){
        Optional<UserRecord> user = userRepository.findById(userId);
        return user.map(userRecord -> new Balance(userRecord.getBalance())).orElseGet(() -> new Balance(0.0F));
    }
}
