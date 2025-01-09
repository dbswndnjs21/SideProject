package com.sideproject.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.Iterator;

@ResponseBody
@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iter = authorities.iterator();
        GrantedAuthority auth = iter.next();
        String role = auth.getAuthority();

        Authentication authentication2 = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Is authenticated: " + authentication2.isAuthenticated());
        System.out.println("Principal: " + authentication2.getPrincipal());
        System.out.println("Authorities: " + authentication2.getAuthorities());


        return "main page " + name + " " + role;
    }
}
