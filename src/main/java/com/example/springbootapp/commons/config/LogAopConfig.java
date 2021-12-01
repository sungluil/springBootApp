package com.example.springbootapp.commons.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

@Configuration
@Aspect
@Slf4j
public class LogAopConfig {

    @Around("@annotation(com.example.springbootapp.commons.annotation.LogAspect)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        log.info("************************** AOP START **************************");
        log.info("packageName            : {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("methodName             : {}", joinPoint.getSignature().getName());
        log.info("toShortString          : {}", joinPoint.getSignature().toShortString());
        log.info("signature              : {}", signature);
        log.info("method                 : {}", method);
        log.info("returnType             : {}", signature.getReturnType());
        for (int i = 0; i < args.length; i++) {
            log.info("args               : {}", args[i]);
        }
        log.info("=================================================================");

        Object proceed = joinPoint.proceed();


        stopWatch.stop();
        log.info("************************** AOP END **************************");
        log.info(stopWatch.prettyPrint());
        log.info("=================================================================");




        return proceed;

    }
}
