package com.kin.finalprojec.controller;

//import JavaBeansclasses.Category;
import com.kin.finalprojec.beans.Coupon;
import com.kin.finalprojec.services.CompanyServices;
import com.kin.finalprojec.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    CompanyServices services;
    @Autowired
    CustomerServices services2;



    @PostMapping("/companies/addCoupon")
    public void addCoupon(@RequestBody Coupon coupon) {
        services.addCoupon(coupon);
    }

    /////////////////////////////////
    @PutMapping("/companies/UpdateCoupon")
    public void UpdateCoupon(@RequestBody Coupon coupon) {
        services.UpdateCoupon(coupon);
    }

    @DeleteMapping("/companies/deleteCoupon")
    public void DeleteCoupon(@RequestParam(name = "id") int couponID) {
        services.DeleteCoupon(couponID);
    }

    @GetMapping("/companies/getAllCoupon")
    public List<Coupon> getAllCoupons() {
        return services.getAllCoupon();
    }

    @GetMapping("/companies/getOneCoupon")
    public Coupon getOneCoupon(@RequestParam(name = "id") int couponID) {
        return services.getOneCoupon(couponID);
    }

    @GetMapping("/companies/getCompanyCoupon")
    public List<Coupon> getCompanyCoupon() {
        return services.getCompanyCoupon();
    }

//    @GetMapping("/companies/getCompanyCouponCategory")
//    public List<Coupon> getCompanyCoupon(@RequestParam(name = "category") Category category) {
//        return services.getCompanyCoupon();
//    }

    @GetMapping("/companies/getCompanyCouponPrice")
    public List<Coupon> getCompanyCoupon(@RequestParam(name = "maxPrice") double maxPrice) {
        return services.getCompanyCoupon(maxPrice);
    }

}
