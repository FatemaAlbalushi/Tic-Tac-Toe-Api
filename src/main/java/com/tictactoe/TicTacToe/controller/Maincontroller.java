package com.tictactoe.TicTacToe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Maincontroller {
    @GetMapping(path = "/api/hw")
    public String getHome(){
        return "Hello World!";
    }

}
