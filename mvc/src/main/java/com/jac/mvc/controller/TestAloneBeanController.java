package com.jac.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test.AloneBean;

@RestController
public class TestAloneBeanController {
    private final AloneBean myBean;

    @Autowired
    public TestAloneBeanController(AloneBean myBean) {
        this.myBean = myBean;
    }

    @GetMapping("/test")
    public String check(){
        return "Bingo!";
    }
}
