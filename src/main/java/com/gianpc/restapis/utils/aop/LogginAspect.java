package com.gianpc.restapis.utils.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;


// El Aspecto esta viendo antes de que tu salgas de tu casa o cuando saliste de tu casa y cuanto tiempo demoraste en regresar
@Aspect
@Component
public class LogginAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("@annotation(com.gianpc.restapis.utils.aop.LogMethodDetails)")
    public void logMethodCall(JoinPoint jp) throws Throwable {
        logger.info("Method called: " + jp.getSignature());
    }

    // El Around hace algo antes  de llamar al metodo y despues de que el metodo termino hacer algo
    @Around("@annotation(com.gianpc.restapis.utils.aop.LogMethodDetails)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        logger.info(joinPoint.getSignature() + " executed in " + executionTime + "ms" + " with params " + Arrays.toString(joinPoint.getArgs()));
        return proceed;
    }
}
