package com.kin.finalprojec.services;

//import JavaBeansclasses.Category;

import com.kin.finalprojec.beans.Category;
import com.kin.finalprojec.beans.Coupon;
import com.kin.finalprojec.beans.Customer;
//import com.kin.finalprojec.beans.customersVsCoupons;
import com.kin.finalprojec.dao.CompanyRepo;
import com.kin.finalprojec.dao.CouponRepo;
import com.kin.finalprojec.dao.CustomerRepo;
//import com.kin.finalprojec.dao.customersVsCouponsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServices extends CllientFacade {
    @Autowired
    CouponRepo repo;
    @Autowired
    CustomerRepo customerRepo;

    private int customerID = 1;
    public boolean login(String email, String password) {
        Customer customer = customerRepo.findByEmailAndPassword(email,password);
        if(customer != null)
        {
            customerID = customer.getId();
            return true;
        }
        return false;
    }


    public void purchaseCoupon(int customerId, int couponId) {

        Optional<Customer> customer = customerRepo.findById(customerId);
        Optional<Coupon> coupon = repo.findById(couponId);
        if(coupon.get().getAmount() > 0)
        {
            customer.get().getCoupons().add(coupon.get());
            customerRepo.save(customer.get());
            System.out.printf("Coupon successfully purchased\n");
            coupon.get().setAmount(coupon.get().getAmount()-1);
            repo.save(coupon.get());
        }else System.out.printf("Out of stock coupon not purchased");

    }

    public List<Coupon> getCustomerCoupons(){
        return customerRepo.findById(this.customerID).get().getCoupons();
    }


    public  List<Coupon> getCustomerCoupons(Category category) {
        List<Coupon> coupons = customerRepo.findById(this.customerID).get().getCoupons();
        return coupons.stream()
                .filter(coupon -> coupon.getCategory() == category)
                .collect(Collectors.toList());
    }


    public  List<Coupon> getCustomerCoupons(double maxPrice) {
        List<Coupon> coupons = getCustomerCoupons();
        coupons.removeIf(coupon -> coupon.getPrice() > maxPrice);
        return coupons;
    }

    public Customer getCustomerDetails() {
        return customerRepo.findById(this.customerID).orElse(null);
    }



}
