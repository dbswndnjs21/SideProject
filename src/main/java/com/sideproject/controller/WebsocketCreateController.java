package com.sideproject.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class WebsocketCreateController {


    @GetMapping("/websocketSendId")
    public String websocket(@RequestParam String id) {

        return id;
    }
}
