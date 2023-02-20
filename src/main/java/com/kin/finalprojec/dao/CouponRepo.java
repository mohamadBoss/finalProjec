package com.kin.finalprojec.dao;

//import JavaBeansclasses.Category;
//import com.kin.finalprojec.beans.Categories;
import com.kin.finalprojec.beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CouponRepo extends JpaRepository<Coupon,Integer> {
    Coupon findByTitle(String title);

    List<Coupon> findAllByCompanyID(int companyID);

    @Query("SELECT c FROM Coupon c WHERE c.price <= :maxPrice")
    List<Coupon> findAllByMaxPrice(double maxPrice);


//    Optional<Coupon> findAllByCategory(Category category);

}
