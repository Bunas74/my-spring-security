package org.example.myspringsecurity.service;

import org.example.myspringsecurity.dto.AuthDTO;

public interface AuthService {

    void registration(AuthDTO authDTO);
}