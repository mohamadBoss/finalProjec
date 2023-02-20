package com.kin.finalprojec.controller;

import com.kin.finalprojec.beans.Category;
import com.kin.finalprojec.beans.Coupon;
import com.kin.finalprojec.beans.Customer;
import com.kin.finalprojec.services.AdminServices;
import com.kin.finalprojec.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    AdminServices services;
    @Autowired
    CustomerServices services1;
    @PostMapping("/companies/purchaseCoupon")
    public void purchaseCoupon(@RequestParam(name = "customerID") int customerID, @RequestParam(name = "couponID") int couponID) {
        services1.purchaseCoupon(customerID, couponID);
    }


    @GetMapping(("/companies/getCustomerCoupons"))
    public List<Coupon> getCustomerCoupons(){
        return services1.getCustomerCoupons();
    }

    @GetMapping(("/companies/getCustomerCouponsMaxPrice"))
    public List<Coupon> getCustomerCoupons(@RequestParam(name = "maxPrice") int maxPrice) {
        return services1.getCustomerCoupons(maxPrice);
    }
    @GetMapping(("/companies/getCustomerCouponsCategory"))
    public List<Coupon> getCustomerCoupons(@RequestParam(name = "category") Category category) {
        return services1.getCustomerCoupons(category);
    }

    @GetMapping(("/companies/getCustomerDetails"))
    public Customer getCustomerDetails() {
        return services1.getCustomerDetails();
    }



}
