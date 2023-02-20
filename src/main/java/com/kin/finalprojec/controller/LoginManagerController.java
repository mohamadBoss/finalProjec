package com.kin.finalprojec.controller;

import com.kin.finalprojec.beans.ClientType;
import com.kin.finalprojec.services.*;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*@Scope("singleton")*/
@RestController
@RequestMapping("/api")
public class LoginManagerController {
    //    @@RestController
    private LoginManagerServices loginManagerController;

    public LoginManagerController() {
        this.loginManagerController = LoginManagerServices.getInstance();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam("clientType") ClientType clientType, @RequestParam("email") String email, @RequestParam("password") String password) {
        CllientFacade clientFacade = loginManagerController.login(clientType, email, password);

        if (clientFacade == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }

        switch (clientType) {
            case administrator:
                return ResponseEntity.status(HttpStatus.OK).body("Admin dashboard");
            case company:
                return ResponseEntity.status(HttpStatus.OK).body("Company dashboard");
            case customer:
                return ResponseEntity.status(HttpStatus.OK).body("Customer dashboard");
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unknown client type");
        }
    }
}
