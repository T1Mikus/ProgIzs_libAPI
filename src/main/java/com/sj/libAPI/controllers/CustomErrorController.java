package com.sj.libAPI.controllers;

import com.sj.libAPI.repositories.CustomErrorInterface;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/error")
public class CustomErrorController implements CustomErrorInterface {

    @Override
    public String error(HttpServletRequest request) {
        return "<h1>Error occurred</h1>";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
