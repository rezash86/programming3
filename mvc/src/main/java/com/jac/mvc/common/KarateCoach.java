package com.jac.mvc.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class KarateCoach implements Coach{

    public KarateCoach(){
        System.out.println("I am initialized " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Do Kata";
    }
}
