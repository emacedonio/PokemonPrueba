package com.pokeapi.elias.service;

import com.pokeapi.elias.service.interfaces.ILoginService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService {

    @Value("${login.username}")
    private String validUsername;

    @Value("${login.password}")
    private String validPassword;

    @Override
    public boolean login(String username, String password) {
        return validUsername.equals(username) && validPassword.equals(password);
    }
}