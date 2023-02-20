package com.kin.finalprojec.services;

import com.kin.finalprojec.beans.Company;
import com.kin.finalprojec.beans.Coupon;
import com.kin.finalprojec.beans.Customer;
//import com.kin.finalprojec.beans.customersVsCoupons;
import com.kin.finalprojec.dao.CompanyRepo;
import com.kin.finalprojec.dao.CustomerRepo;
//import com.kin.finalprojec.dao.customersVsCouponsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServices {
    @Autowired
    CompanyRepo repo;
    @Autowired
    CustomerRepo repo2;

    public void addCompany(Company company) {
        Company company1 = repo.findByEmailOrName(company.getEmail(), company.getName());
        if (company1 == null) {
            repo.save(company);
            System.out.printf("add company is successfully");
        } else
            System.out.printf("can't add company");

    }

    public void UpdateCompany(Company company) {
        Company com = (Company) repo.findById(company.getId()).orElse(null);
        if (com != null) {
            if (company.getEmail() != null)
                com.setEmail(company.getEmail());
            if (company.getPassword() != null)
                com.setPassword(company.getPassword());
            repo.save(com);
            System.out.printf("update successfully");
        } else
            System.out.printf("can't update ");
    }

    public void DeleteCompany(int companyID) {
        Company company = repo.findById(companyID).orElse(null);
        if (company != null) {
            repo.deleteById(companyID);
            System.out.println("deleting the company is successful");
        } else
            System.out.println("can't delete the company");

    }

    public List<Company> getAllCompany() {
        return repo.findAll();
    }

    public Company getOneCompany(int companyID) {
        return (Company) repo.findById(companyID).orElse(null);
    }

    public Customer addCustomer(Customer customer) {
        Customer customer1 = repo2.findByEmail(customer.getEmail());
        if (customer1 == null) {
            System.out.println("Adding a customer is successful");
            return repo2.save(customer);
        } else {
            System.out.println("Can't add the customer");
        }
        return null;
    }

    public List<Customer> getAllCustomers() {
        return repo2.findAll();
    }

    public void updateCustomer(Customer customer) {
        Customer cust = (Customer) repo2.findById(customer.getId()).orElse(null);
        if (cust != null) {
            if (customer.getFirstName() != null)
                cust.setFirstName(customer.getFirstName());
            if (customer.getLastName() != null)
                cust.setLastName(customer.getLastName());
            if (customer.getEmail() != null)
                cust.setEmail(customer.getEmail());
            if (customer.getPassword() != null)
                cust.setPassword(customer.getPassword());
            repo2.save(cust);
            System.out.println("Update the customer is successful");
        } else {
            System.out.println("can't update the customer");
        }
    }

    public void DeleteCustomer(int customerID) {
//        Optional<Customer> customer = repo2.findById(customerID);
//        System.out.printf(customer.toString());
//        repo2.deleteById(customerID);
//        Optional<customersVsCoupons> couponID = repo3.findByCustomerId(customerID);
//        System.out.printf(couponID.toString());
//        repo3.deleteById(couponID.get().getCoupon().getId());

        Customer customer = repo2.findById(customerID).orElse(null);
        if (customer != null) {
            repo2.deleteById(customerID);
            System.out.println("deleting the customer is successful");
        } else {
            System.out.println("can't delete the customer check if you are trying to delete the correct company");
        }

    }

    public Customer getOneCustomer(int customerID) {
        return (Customer) repo2.findById(customerID).orElse(null);
    }

}
