package com.jac.mvc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {

    @GetMapping("/hello")
    public String sayHello(Model myModel){
        myModel.addAttribute("theDate", new java.util.Date());

        return "helloworld";
    }

}
