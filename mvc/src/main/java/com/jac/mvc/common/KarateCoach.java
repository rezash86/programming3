package com.jac.mvc.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class KarateCoach implements Coach{

    public KarateCoach(){
        System.out.println("I am initialized " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Do Kata";
    }
}
