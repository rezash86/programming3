package com.jac.mvc.configuration;

import com.jac.mvc.common.BasketBallCoach;
import com.jac.mvc.common.Coach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportsConfig {

    @Bean
    public Coach basketBallCoach1(){
        return new BasketBallCoach();
    }
}
