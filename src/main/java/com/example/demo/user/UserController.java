package com.example.demo.user;

import com.example.demo.responses.HTTPResponse;
import com.example.demo.responses.CreateEmployeeResponse;
import com.example.demo.responses.GetEmployeeResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    // TODO: sign-in mapping (after learning about the tokens)

    @GetMapping("/employee")
    /**
     * TODO: DOCUMENT STUFF YOU IDIOT
     */
    public ResponseEntity<GetEmployeeResponse> getEmployee (@Valid @RequestBody String phoneNumber) {
        User newEmployee = userService.getEmployee(phoneNumber);
        GetEmployeeResponse res = new GetEmployeeResponse(newEmployee);
        HttpStatus responseStatus = (newEmployee==null)?HttpStatus.NOT_FOUND:HttpStatus.OK;
        return ResponseEntity.status(responseStatus).body(res);
    }

    @GetMapping("/employee")
    public ResponseEntity<List<User>> getAllEmployees () {
        List<User> employees = userService.getAllEmployee();
        System.out.println("employees: " + employees);
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @PostMapping("/employee/create")
    public ResponseEntity<HTTPResponse> newEmployee (@Valid @RequestBody User user) {
        User newEmployee = userService.createEmployee(user);
        CreateEmployeeResponse res = new CreateEmployeeResponse("Employee created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @DeleteMapping("/employee/delete/{id}")
    public ResponseEntity<String> deleteEmployee (@Valid @PathVariable Long id) {
        User newEmployee = userService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Message: Unimplemented Method");
    }

    @PutMapping("/user/edit")
    public ResponseEntity<String> editUserDetails (@Valid @RequestBody User user) {
        userService.updateUserDetails(user);
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Message: Unimplemented Method");
    }

}