package com.example.demo.responses;

import com.example.demo.user.User;

import java.util.List;

public class GetAllEmployeesResponse extends HTTPResponse {
    List<User> employees;
    public GetAllEmployeesResponse(List<User> employees) {
        super("");
        if(employees == null) {
            message = "There are no employees";
        }
        else {
            message = "Retrieved successfully";
            this.employees = employees;
        }
    }
}
