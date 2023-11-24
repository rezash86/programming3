package com.jac.mvc.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary // giving priority for the concrete class
public class SwimmingCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Go and come back 1000 time in the pool";
    }
}
