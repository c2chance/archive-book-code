package com.aop.source;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Auther: wangbo
 * @Description:aop
 */


@Aspect
@Component
public class SimpleAspect {

    /**
     * 切点表达式:
     * ..两个点表明多个，*代表一个
     * 表达式代表切入com..service包下的所有类的所有方法，方法参数不限，返回类型不限
     * 第一个*代表返回类型不限，第二个*表示所有类，第三个*表示所有方法，..两个点表示方法里的参数不限
     */
    private final String POINT_CUT = "execution(* com..service.*.*(..))";

    /**
     * 切点
     * pointCut 切点名称
     */
    @Pointcut(POINT_CUT)
    public void pointCut(){}


    /**
     * 在切点方法之前执行
     * @param joinPoint
     */
    @Before(value="pointCut()")
    public void doBefore(JoinPoint joinPoint){
        System.out.println("@Before注解触发：切点方法之前执行...");
    }

    
    /**
     * 在切点方法之后执行
     * @param joinPoint
     */
    @After(value="pointCut()")
    public void doAfter(JoinPoint joinPoint){
        System.out.println("@After注解触发：切点方法之后执行...");
    }

    
    
    /**
    * 切点方法返回后执行
    *    若第一个参数为JoinPoint，则第二个参数为返回值的信息
    *    若第一个参数非JoinPoint，则第一个参数为returning中对应的参数
    *    returning：限定了后置返回通知的执行条件，当目标方法返回值与通知方法参数类型匹配的时候，才执行
    */
    @AfterReturning(value = "pointCut()",returning = "result")
    public void doAfterReturn(JoinPoint joinPoint,Object result){
        System.out.println("@AfterReturning注解触发：切点方法返回后执行...");
        System.out.println("返回值："+result);
    }
    
    /**
     * 切点方法抛异常执行
     * 定义一个变量，该变量用于匹配异常通知，当目标方法抛出异常返回后，把该异常传递给通知方法
     * throwing:限定了后置异常通知的执行条件，当目标方法抛出的异常与通知方法异常参数类型匹配的时候，才执行
     * @param joinPoint
     * @param exception
     */
     @AfterThrowing(value = "pointCut()",throwing = "exception")
     public void doAfterThrowing(JoinPoint joinPoint,Throwable exception){
         System.out.println("@afterThrowing注解触发：切点方法抛异常执行...");
     }
     
     
     /**
      * 
      * 属于环绕增强，能控制切点的执行前，执行后等
      * 
      * JoinPoint：表示目标类连接点对象
      * getThis()：获取代理对象
      * getArgs()：获取连接点方法运行时的入参列表
      * getTarget()：获取连接点所在的目标对象
      * @param pj
      * @return Object
      * @throws Throwable 
      */
     @Around(value="pointCut()")
     public Object doAround(ProceedingJoinPoint pj) throws Throwable{
         System.out.println("@Around注解触发：切点方法环绕start...");
         Object[] args = pj.getArgs();
         Object o = pj.proceed(args);
         System.out.println("@Around注解触发：切点方法环绕end...");
         return o;
     }

}