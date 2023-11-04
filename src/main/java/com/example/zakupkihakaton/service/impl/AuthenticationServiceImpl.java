package com.example.zakupkihakaton.service.impl;


import com.example.zakupkihakaton.convert.UserMapper;
import com.example.zakupkihakaton.entity.User;
import com.example.zakupkihakaton.exception.ApplicationException;
import com.example.zakupkihakaton.exception.CustomException;
import com.example.zakupkihakaton.model.request.AuthenticationRequest;
import com.example.zakupkihakaton.model.response.AuthenticationResponse;
import com.example.zakupkihakaton.model.response.UserAuthResponse;
import com.example.zakupkihakaton.repository.UserRepository;
import com.example.zakupkihakaton.service.AuthenticationService;
import com.example.zakupkihakaton.util.JwtUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    JwtUtil jwtUtil;
    AuthenticationManager authenticationManager;
    UserRepository userRepository;
    UserMapper userMapper;

    @Override
    @Transactional(readOnly = true)
    public AuthenticationResponse generateToken(AuthenticationRequest authRequest, HttpServletResponse response) {
        List<User> users = userRepository.findByPIN(authRequest.getPin());

        if (users.isEmpty()) {
            CustomException exception = new CustomException(ApplicationException.AUTHENTICATION_FAILED);
            log.error(exception.getReason(), exception);
            throw exception;
        }

        String jwt = null;
        UserAuthResponse authResponse = null;
        boolean find = false;

        for (User user : users) {
            try {
                var result = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getId(), authRequest.getPassword()));
                jwt = jwtUtil.generateToken(user.getId());
                authResponse = userMapper.entityToAuthResponse(user);

                if (result != null) {
                    find = true;
                    break;
                }
            } catch (AuthenticationException ignored) {
            }
        }

        if (!find) {
            CustomException exception = new CustomException(ApplicationException.AUTHENTICATION_FAILED);
            log.error(exception.getReason(), exception);
            throw exception;
        }

        return new AuthenticationResponse(authResponse, jwt);
    }
}
