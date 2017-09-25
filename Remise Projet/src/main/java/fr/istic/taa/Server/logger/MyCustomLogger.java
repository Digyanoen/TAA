package fr.istic.taa.Server.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Aspect Logger
 *
 */
@Aspect
@Component
public class MyCustomLogger {

    /**
     * Before Returning the function, print its name for log purpose
     * @param joinPoint the joinpoint
     */

    @AfterReturning("execution(* fr.istic.taa.Server.controller.*.*(..))")
    public void logAfter(JoinPoint joinPoint){
        Logger.getGlobal().info("Sortie de la méthode "+joinPoint.getSignature().getName());
    }


}
