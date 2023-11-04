package com.example.zakupkihakaton.service;


import com.example.zakupkihakaton.model.request.AuthenticationRequest;
import com.example.zakupkihakaton.model.response.AuthenticationResponse;

import javax.servlet.http.HttpServletResponse;

public interface AuthenticationService {
    AuthenticationResponse generateToken(AuthenticationRequest authRequest, HttpServletResponse response);
}
