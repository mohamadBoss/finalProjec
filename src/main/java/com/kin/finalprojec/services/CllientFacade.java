package com.kin.finalprojec.services;

import java.sql.SQLException;

public abstract class CllientFacade {
    public abstract boolean login(String email, String password);
}
