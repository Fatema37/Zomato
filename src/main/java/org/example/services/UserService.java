package org.example.services;

import org.example.models.User;
import org.example.repositories.RestaurantRepo;
import org.example.repositories.UserRepo;

import java.util.Optional;

public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo){

        this.userRepo = userRepo;
    }

    public User registerUser(String email, String password, String name, String phoneNo){
        Optional<User> userOptional = userRepo.findByEmail(email);
        if(userOptional.isPresent()){
            throw new RuntimeException("User already exists");
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        user.setPhoneNo(phoneNo);
       userRepo.save(user);
       System.out.println(user);
       return user;
    }

    public User loginUser(String email, String password){
        Optional<User> userOptional = userRepo.findByEmail(email);
        if(userOptional.isEmpty()){
            throw new RuntimeException("User does not exist");
        }

        User user = userOptional.get();
        if(user.getPassword().equals(password)){
            System.out.println("User is logged in");
            return user;
        }
        else{
            throw new RuntimeException("Invalid Password");
        }
    }

}
