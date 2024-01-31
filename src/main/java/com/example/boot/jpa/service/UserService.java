package com.example.boot.jpa.service;

import com.example.boot.jpa.dao.UserRepository;
import com.example.boot.jpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> createUsers(List<User> users){
        return userRepository.saveAll(users);
    }

    public User getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User updateUser(User user){
        User oldUser = null;
        Optional<User> optUser = userRepository.findById(user.getId());
        if(optUser.isPresent()){
            oldUser = optUser.get();
            oldUser.setName(user.getName());
            oldUser.setAddress(user.getAddress());
        }
        else{
            return new User();
        }
        return oldUser;
    }

    public String deleteUser(int id){
        userRepository.deleteById(id);
        return "User got deleted";
    }



}
