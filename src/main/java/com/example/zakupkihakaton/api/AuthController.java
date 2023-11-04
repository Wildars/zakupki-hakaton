package com.example.zakupkihakaton.api;

import com.example.zakupkihakaton.model.request.AuthenticationRequest;
import com.example.zakupkihakaton.model.response.AuthenticationResponse;
import com.example.zakupkihakaton.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthController {
    AuthenticationService authenticationService;

    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @Operation(description = "Авторизация по логину и паролю")
    public AuthenticationResponse generateToken(@Valid @RequestBody AuthenticationRequest authRequest, HttpServletResponse response) {
        return authenticationService.generateToken(authRequest, response);
    }
}
