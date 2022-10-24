package com.sj.libAPI.repositories;

import javax.servlet.http.HttpServletRequest;

public interface CustomErrorInterface {
    String error(HttpServletRequest request);

    String getErrorPath();
}
