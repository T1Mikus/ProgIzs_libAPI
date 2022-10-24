package com.sj.libAPI.controllers;

import com.sj.libAPI.models.DTO.auth.SignInReq;
import com.sj.libAPI.models.DTO.auth.SignUpReq;
import com.sj.libAPI.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService _authService;

    @PostMapping("/signin")
    public boolean singIn(@RequestBody SignInReq rq){
        return _authService.signIn(rq);
    }

    @PostMapping("/signup")
    public boolean singUp(@RequestBody SignUpReq rq){
        return _authService.signUp(rq);
    }

}
