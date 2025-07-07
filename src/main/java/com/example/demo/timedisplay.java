package com.example.demo;



import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

@Component


public class timedisplay {

    private static final Logger logger = (Logger) LoggerFactory.getLogger(timedisplay.class);

    @Scheduled(cron = "* * * * * *")
    public void cronfunc(){    
        logger.warn("Ran it...");
    }   
}
