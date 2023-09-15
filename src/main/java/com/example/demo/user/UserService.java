package com.example.demo.user;

import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    /**
     * This does .....
     * @param user
     */
    void updateUserDetails(User user);
    User createEmployee(User user);

    /**
     * This does something
     * @param phoneNumber
     * @return
     */
    User getEmployee(String phoneNumber);
    List<User> getAllEmployee();
    User deleteEmployee(Long id);
}
