package com.kin.finalprojec.services;

import com.kin.finalprojec.beans.Category;
import com.kin.finalprojec.beans.Company;
import com.kin.finalprojec.beans.Coupon;
//import com.kin.finalprojec.beans.customersVsCoupons;
//import com.kin.finalprojec.beans.customersVsCoupons;
import com.kin.finalprojec.dao.CompanyRepo;
import com.kin.finalprojec.dao.CouponRepo;
//import com.kin.finalprojec.dao.customersVsCouponsRepo;
import com.kin.finalprojec.dao.CustomerRepo;
//import com.kin.finalprojec.dao.customersVsCouponsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServices {
    private int companyID = 1;
    @Autowired
    CouponRepo repo;
    //    @Autowired
//    customersVsCouponsRepo repo2;
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    CompanyRepo companyRepo;

    public void addCoupon(Coupon coupon) {

        Company company = companyRepo.findById(coupon.getCompanyID()).orElse(null);
        Coupon coupon1 = (Coupon) repo.findByTitle(coupon.getTitle());
        if (company != null) {
            if (coupon1 == null || coupon1 != null && coupon1.getCompanyID() != company.getId()) {
                coupon.setCompanyID(company.getId());
                repo.save(coupon);
                System.out.printf("successfully added coupon");
            }
        } else {
            System.out.println("Can't add the coupon, company does not exist");
        }
    }

    public void UpdateCoupon(Coupon coupon) {
        Coupon coupon1 = (Coupon) repo.findById(coupon.getId()).orElse(null);
        if (coupon1 != null) {
            if (coupon.getCategory() != null) coupon1.setCategory(coupon.getCategory());
            if (coupon.getTitle() != null) coupon1.setTitle(coupon.getTitle());
            if (coupon.getDescription() != null) coupon1.setDescription(coupon.getDescription());
            if (coupon.getStartDate() != null) coupon1.setStartDate(coupon.getStartDate());
            if (coupon.getEndDate() != null) coupon1.setEndDate(coupon.getEndDate());
            if (coupon.getAmount() != 0) coupon1.setAmount(coupon.getAmount());
            if (coupon.getPrice() != 0) coupon1.setPrice(coupon.getPrice());
            if (coupon.getImage() != null) coupon1.setImage(coupon.getImage());
            repo.save(coupon1);
            if (coupon.getCategory() != null || coupon.getTitle() != null || coupon.getDescription() != null || coupon.getStartDate() != null || coupon.getEndDate() != null || coupon.getAmount() != 0 || coupon.getPrice() != 0 || coupon.getImage() != null)
                System.out.println("Update the coupon is successful");
        }
    }

    public void DeleteCoupon(int couponID) {
        repo.deleteById(couponID);
    }
    /*example to shaw messages

    public void deleteCoupon(int couponID) {
    Coupon coupon = repo.findById(couponID).orElseThrow(() -> new NotFoundException("Coupon not found"));

    for (Customer customer : coupon.getCustomers()) {
        customer.getCoupons().remove(coupon);
    }

    repo.delete(coupon);
}
     */

    public List<Coupon> getAllCoupon() {
        return repo.findAll();
    }

    public Coupon getOneCoupon(int couponID) {
        return repo.findById(couponID).orElse(null);
    }

    public List<Coupon> getCompanyCoupon() {
        return repo.findAllByCompanyID(this.companyID);
    }

//    public Optional<Coupon> getCompanyCoupon(Category category) {
//        return repo.findAllByCategory(category);
//    }

    public List<Coupon> getCompanyCoupon(double maxPrice) {
        return repo.findAllByMaxPrice(maxPrice);
    }

    public Company getCompanyDetails() {
        return companyRepo.findById(this.companyID).orElse(null);
    }

//    public void deleteCouponPurchase(int customerID, int couponID){
//        repo2.deleteByCustomerIDAndCouponID(customerID,couponID);
//    }
//    public List<Coupon> getAllCustomerCoupon(int customerID){
//        return  repo2.findAllByCustomerID(customerID);
//    }
}