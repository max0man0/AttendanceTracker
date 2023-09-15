package com.example.demo.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{
    UserRepository userRepository;
    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public void updateUserDetails(User user) {
        return;
    }

    @Override
    public User createEmployee(User user) {
        userRepository.save(user);
        return null;
    }

    @Override
    public User getEmployee(String phoneNumber) {
        return userRepository.findByPhoneNumber(phoneNumber).orElse(null);
    }

    @Override
    public List<User> getAllEmployee() {
        return null;
    }

    @Override
    public User deleteEmployee(Long id) {
        return null;
    }
}
