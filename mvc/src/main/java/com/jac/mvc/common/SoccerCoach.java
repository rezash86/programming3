package com.jac.mvc.common;

import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Shoot 200 times into the net";
    }
}
