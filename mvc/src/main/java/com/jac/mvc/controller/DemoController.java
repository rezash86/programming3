package com.jac.mvc.controller;

import com.jac.mvc.common.Coach;
import com.jac.mvc.common.SoccerCoach;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequiredArgsConstructor
public class DemoController {
    private final Coach coach;

    //dependency injection by constructor
    @Autowired
    public DemoController(Coach coach){
        this.coach = coach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout(){
        return this.coach.getDailyWorkout();
    }
}
