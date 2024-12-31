package com.sideproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
public class AdminController {

    @GetMapping("/admin")
    public String home() {
        return "admin page";
    }
}
