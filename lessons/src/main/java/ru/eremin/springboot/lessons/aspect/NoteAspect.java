package ru.eremin.springboot.lessons.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @autor Eremin Artem on 20.01.2019.
 */

@Aspect
@Component
public class NoteAspect {
    @Pointcut("execution(* ru.eremin.springboot.lessons.repository.NoteRepository.*(..))")
    public void getName() {

    }

    @Before("getName()")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println(joinPoint);
    }

    @Around("getName()")
    public Object monitor(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        final long time = System.nanoTime();
        final Object object = proceedingJoinPoint.proceed();
        System.out.println(System.nanoTime() - time + " Method work time");
        return object;
    }
}
