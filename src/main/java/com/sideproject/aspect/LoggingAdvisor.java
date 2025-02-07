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
    public Object advice(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();

        long startTime = System.currentTimeMillis(); // 시작 시간
        long endTime = System.currentTimeMillis(); // 메서드 끝난 시간
        long duration = endTime - startTime; // 실행 시간

        log.info("Starting method: {}, {}", methodName, className);

        Object result = joinPoint.proceed(); // 타깃 메서드 실행
//        joinPoint.proceed();

        log.info("Ending method: {}, {}", methodName, className);

        return result;
    }
}
