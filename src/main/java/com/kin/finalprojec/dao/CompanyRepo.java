package com.kin.finalprojec.dao;

import com.kin.finalprojec.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company,Integer> {
    Company findByEmailOrName(String email, String name);
}
