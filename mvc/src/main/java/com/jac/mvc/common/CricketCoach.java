package com.jac.mvc.common;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("cricket")
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "do something";
    }
}
