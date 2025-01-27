package com.sideproject.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class LoggingAdvisor {
    @Pointcut("execution(* com.sideproject.service.*.*(..))")
    public void pointcut() {}

    @Around("pointcut()")
    public void advice(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();

        log.info("Starting method: {}, {}", methodName, className);

        joinPoint.proceed();

        log.info("Ending method: {}, {}", methodName, className);
    }
}
