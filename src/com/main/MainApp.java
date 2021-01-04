package com.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.TicketManagement;

public class MainApp {

	public static void main(String[] args) throws Exception {
		
		Scanner sc=new Scanner(System.in);
		ApplicationContext ctx= new ClassPathXmlApplicationContext("spring.xml");
		TicketManagement tcktmgmt=(TicketManagement) ctx.getBean("ticketm");
		do
		{
		System.out.println("1 Show Train");
	    System.out.println("2 Book Ticket"); 
		System.out.println("Enter the choice");
		
		int ch=sc.nextInt();
		switch(ch)
		{
		case 1:
			System.out.println("Enter the Username");
			String unm=sc.next();
			System.out.println("Enter the Password");
			String pwd=sc.next();
			tcktmgmt.login(unm, pwd);
			break;
		case 2:
			tcktmgmt.getTck().showTrains();
			System.out.println("enter train no.");
			int tno=sc.nextInt();
			tcktmgmt.bookTicket(tno);
			break;
		}
		
	     }while(true);
		}
	

}
