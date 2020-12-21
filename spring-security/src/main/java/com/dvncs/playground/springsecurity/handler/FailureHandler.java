package com.dvncs.playground.springsecurity.handler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class FailureHandler implements AuthenticationFailureHandler {

    private String redirectUrl;

    public FailureHandler(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
        AuthenticationException exception) throws IOException, ServletException {
        response.sendRedirect(redirectUrl);
    }
}
