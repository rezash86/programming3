package com.jac.mvc.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("cricket")
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In constructor " + getClass().getSimpleName());
    }

    @PostConstruct
    public void doSomeStartupStuff(){
        System.out.println("Custom start " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "do something";
    }

    @PreDestroy
    public void doDestroyStuff(){
        System.out.println("destroy in " + getClass().getSimpleName());
    }
}
