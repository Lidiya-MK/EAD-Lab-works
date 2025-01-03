// Lidiya Mamo Kibret  ugr/2485/14 
package com.exam.ead;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
    @Before("execution(* com.exam.ead.BookRegistrationServlet.*(..))")
    public void logBookRegistrationServletMethods(JoinPoint joinPoint) {
        System.out.println(
                "[LOGGING ASPECT] BookRegistrationServlet method called: " + joinPoint.getSignature().getName());
    }

    @Before("execution(* com.exam.ead.DisplayBooksServlet.*(..))")
    public void logDisplayBooksServletMethods(JoinPoint joinPoint) {
        System.out.println(
                "[LOGGING ASPECT] DisplayBooksServlet method called: " +
                        joinPoint.getSignature().getName());
    }

    @Before("execution(* com.exam.ead.DeleteBookServlet.*(..))")
    public void logDeleteBookServletMethods(JoinPoint joinPoint) {
        System.out.println(
                "[LOGGING ASPECT] DeleteBookServlet method called: " +
                        joinPoint.getSignature().getName());
    }

    @Before("execution(* com.exam.ead.SearchBooksServlet.*(..))")
    public void logSearchBooksServletMethods(JoinPoint joinPoint) {
        System.out.println(
                "[LOGGING ASPECT] SearchBooksServlet method called: " +
                        joinPoint.getSignature().getName());
    }
}
