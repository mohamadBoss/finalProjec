package com.kin.finalprojec.services;

import com.kin.finalprojec.beans.ClientType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class LoginManagerServices {

    private static LoginManagerServices instance;

    private LoginManagerServices() {
        // Private constructor to prevent instantiation from outside the class
    }

    public static LoginManagerServices getInstance() {
        if (instance == null) {
            instance = new LoginManagerServices();
        }
        return instance;
    }

    public CllientFacade login(ClientType clientType, String email, String password) {
        try {
            switch (clientType) {
                case administrator:
                    AdminServices adminFacade = new AdminServices();
                    if (adminFacade.login(email, password)) {
                        return adminFacade;
                    }
                    return null;
                case company:
                    CompanyServices companyFacade = new CompanyServices();
                    if (companyFacade.login(email, password)) {
                        return companyFacade;
                    }
                    return null;
                case customer:
                    CustomerServices customerFacade = new CustomerServices();
                    if (customerFacade.login(email, password)) {
                        return customerFacade;
                    }
                    return null;
                default:
                    return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
