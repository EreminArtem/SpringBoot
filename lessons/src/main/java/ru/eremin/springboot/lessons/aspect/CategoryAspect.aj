package ru.eremin.springboot.lessons.aspect;

/**
 @autor Eremin Artem on 20.01.2019.
 */

aspect CategoryAspect {

    pointcut publicMethodCall():
            call(public * ru.eremin.springboot.lessons.repository.CategoryRepository.*.*(..));

    before () : publicMethodCall(){
        System.out.println(thisJoinPoint);
    }
}
