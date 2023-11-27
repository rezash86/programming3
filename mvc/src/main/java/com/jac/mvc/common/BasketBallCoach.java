package com.jac.mvc.common;

// THERE IS NO ANNOTATION such as Component or service ... !!!
public class BasketBallCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "throw !!!!";
    }
}
