package com.kin.finalprojec.dao;

import com.kin.finalprojec.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    Customer findByEmail(String email);

//    boolean finByEmailAndPassword(String email, String password);

//    boolean exists(String email, String password);
}
