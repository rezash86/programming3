package com.jac.mvc.controller;

import com.jac.mvc.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoScopeController {

    private final Coach coach;

    @Autowired
    public DemoScopeController(@Qualifier("karateCoach") final Coach coach1,
                               @Qualifier("karateCoach") final Coach coach2){
        this.coach = coach1;
        System.out.println(coach1.toString());
        System.out.println(coach2.toString());
    }

}
