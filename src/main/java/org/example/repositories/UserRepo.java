package org.example.repositories;

import org.example.models.User;

import java.util.HashMap;
import java.util.Optional;

public class UserRepo {
    HashMap<String, User> userHashMap = new HashMap<>();
    Long id = 0L;

    public User save(User user){
        if(user.getUserId()==null){
        id++;
        user.setUserId(id.toString());
        }
        userHashMap.put(user.getUserId(), user);
        return user;
    }

    public Optional<User> findById(String id){
        if(userHashMap.containsKey(id)){
            return Optional.of(userHashMap.get(id));
        }
        else {
            return Optional.empty();
        }
    }
    public  Optional<User> findByEmail(String email){
        for(User user : userHashMap.values()){
            if(user.getEmail().equals(email)){
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }


}
