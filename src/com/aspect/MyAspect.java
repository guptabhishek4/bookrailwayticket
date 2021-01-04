package com.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {

	@Pointcut("execution(public void com.dao.TicketDao.showAll(..)")
	public void allMethod(){}
	
	
	 @Before("allMethod()")
		public void log(JoinPoint joinPoint) throws Throwable
		{
		 System.out.println("Trains avaiable");
		}
	 @After("allMethod()")
		public void log1(JoinPoint joinPoint) throws Throwable
		{
		 System.out.println("done");
		}
	 @AfterThrowing("execution(public void login()")
	 public void afterThrowing()
	 {
		 System.out.println("invlid UserName/Password");
	 }
	 @Pointcut("execution(public void bookTicket(..)")
		public void allMethod1(){}
		
		
		 @Before("allMethod1()")
			public void log2(JoinPoint joinPoint) throws Throwable
			{
			 System.out.println("book the ticket");
			}
		 @After("allMethod1()")
			public void log3(JoinPoint joinPoint) throws Throwable
			{
			 System.out.println("Done");
			}
}
