package com.security.security.service;

import com.security.security.domain.User;
import com.security.security.repo.UserRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Transactional
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User saveUser(User user){
        return userRepo.save(user);
    }

    public Collection<User> getAllUsers(){
        return userRepo.findAll();
    }

}
