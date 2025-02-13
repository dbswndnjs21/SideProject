package com.sideproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
public class HomeController {

    @ResponseBody
    @GetMapping("/home")
    public ResponseEntity<Map<String, String>> home() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String role2 = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();

        String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .stream()
                .findFirst()
                .map(GrantedAuthority::getAuthority)
                .orElse("ROLE_UNKNOWN");

        Map<String, String> response = new HashMap<>();
        response.put("username", username);
        response.put("role", role);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public String homePage() {
        return "home";
    }
}
