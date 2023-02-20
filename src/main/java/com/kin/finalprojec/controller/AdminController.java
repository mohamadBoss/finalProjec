package com.kin.finalprojec.controller;

import com.kin.finalprojec.beans.Company;
import com.kin.finalprojec.beans.Customer;
import com.kin.finalprojec.services.AdminServices;
import com.kin.finalprojec.services.CompanyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    AdminServices services;

    @Autowired
    CompanyServices companyServices;
    @PostMapping("/companies/addCompany")
    public void addCompany(@RequestBody Company company) {
        services.addCompany(company);
    }

    @PutMapping("/companies/updateCompany")
    public void updateCompany(@RequestBody Company company) {
        services.UpdateCompany(company);
    }

    @DeleteMapping("/companies/DeleteCompany")
    public void DeleteCompany(@RequestParam(name = "id") int companyID) {
        services.DeleteCompany(companyID);
    }

    @GetMapping("/companies/getAllCompany")
    public List<Company> getAllCompanies() {
        return services.getAllCompany();
    }

    @GetMapping("/companies/getOneCompany")
    public Company getOneCompany(@RequestParam(name = "id") int companyID) {
        return services.getOneCompany(companyID);
    }

    @GetMapping("/companies/getCompanyDetails")
    public Company getCompanyDetails() {
        return companyServices.getCompanyDetails();
    }

    @PostMapping("/companies/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return services.addCustomer(customer);
    }

    @GetMapping("/companies/getAllCustomers")
    public List<Customer> getAllCustomers() {
        return services.getAllCustomers();
    }

    @PutMapping("/companies/updateCustomer")
    public void updateCustomer(@RequestBody Customer customer) {
        services.updateCustomer(customer);
    }

    @DeleteMapping("/companies/DeleteCustomer")
    public void DeleteCustomer(@RequestParam(name = "id") int customerID) {
        services.DeleteCustomer(customerID);
    }

    @GetMapping(("/companies/getOneCustomer"))
    public Customer getOneCustomer(@RequestParam(name = "id") int customerID) {
        return services.getOneCustomer(customerID);
    }


}
