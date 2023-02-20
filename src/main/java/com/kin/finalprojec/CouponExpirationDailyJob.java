package com.kin.finalprojec;

import com.kin.finalprojec.beans.Coupon;
import com.kin.finalprojec.services.CompanyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CouponExpirationDailyJob {
    @Configuration
    @Scope("singleton")
    public class SchedulingConfig {
        @Autowired
        CompanyServices services;

        @Scheduled(cron = "0 0 0 * * *")// run at 12:00 AM every day
        public void run() {
            List<Coupon> coupons = services.getAllCoupon();
//           coupons.stream().filter(coupon -> coupon.getEndDate().before(new Date())).forEach(coupon -> couponsDAO.DeleteCoupon(coupon.getId()));

            List<Coupon> expiredCoupons = coupons.stream().filter(coupon -> coupon.getEndDate().before(new Date())).collect(Collectors.toList());
            expiredCoupons.forEach(coupon -> services.DeleteCoupon(coupon.getId()));
        }
    }

}