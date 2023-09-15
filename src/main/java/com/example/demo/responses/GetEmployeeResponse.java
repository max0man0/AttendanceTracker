package com.example.demo.responses;

import com.example.demo.user.User;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class GetEmployeeResponse {
    private final User employee;
    private final String message;
    public GetEmployeeResponse(User employee) {
        message = (employee == null)? "Employee Not Found": null;
        this.employee = employee;
    }
}
