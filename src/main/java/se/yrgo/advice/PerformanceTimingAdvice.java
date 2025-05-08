package se.yrgo.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTimingAdvice {
    
    public Object performanceTimingMeasurement(ProceedingJoinPoint method) throws Throwable {
        long start = System.currentTimeMillis();
        try {
            return method.proceed();
        } finally {
            long end = System.currentTimeMillis();
            long result = end - start;
            System.out.println("Time taken for the method " + method.getSignature().getName() + 
                " from the class " + method.getSignature().getDeclaringTypeName() + " took " + result + "ms");
        }
    }
}
