package com.kin.finalprojec.controller;

import Fasade.ClientFacade;
import com.kin.finalprojec.beans.ClientType;
import com.kin.finalprojec.services.AdminServices;
import com.kin.finalprojec.services.CompanyServices;
import com.kin.finalprojec.services.CustomerServices;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Scope("singleton")
public class LoginManagerController {
//    @@RestController
    @RequestMapping("/api")
    public class LoginController {
        @PostMapping("/login")
        public ClientFacade login(@RequestParam ClientType clientType, @RequestParam String email, @RequestParam String password) {
            try {
                switch (clientType) {
                    case administrator:
                        AdminServices adminFacade = new AdminServices();
                        if (adminFacade.login(email, password)) {
                            return adminFacade;
                        }
                        return null;
                    case company:
                        CompanyServices companyFacade = new CompanyServices(email);
                        if (companyFacade.login(email, password)) {
                            return companyFacade;
                        }
                        return null;
                    case customer:
                        CustomerServices customerFacade = new CustomerFacade(email);
                        if (customerFacade.login(email, password)) {
                            return customerFacade;
                        }
                        return null;
                    default:
                        return null;
                }
            } catch (ClientNotExsit ex) {
                System.out.println(ex.getMessage());
                return null;
            }
        }

}
