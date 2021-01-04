package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import com.utility.ConnectionProvider;

public class TicketDao {

	
	Connection con=null;
	ResultSet rs=null;
	PreparedStatement pstmt;
	public void login(String unm,String pwd) throws Exception
	{
		
		String query="select * from admin_login where unm=? and pwd=?";
		con=ConnectionProvider.getConnection();
		pstmt=con.prepareStatement(query);
		pstmt.setString(1, unm);
		pstmt.setString(2, pwd);
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			showTrains();
		}
		else
		{
			new Exception("Invalid Username/Password");
		}
	}
	public void showTrains() throws Exception
	{
		String query="select * from train_details";
		con=ConnectionProvider.getConnection();
		pstmt=con.prepareStatement(query);
		rs=pstmt.executeQuery();
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
			System.out.println(rs.getInt(5));
		}
	}
	public void bookTicket(int trainno) throws Exception
	{
		String query="select max(ticketid) from ticket_details";
		con=ConnectionProvider.getConnection();
		pstmt=con.prepareStatement(query);
		rs=pstmt.executeQuery();
		rs.next();
		int max=rs.getInt(1);
		Scanner sc=new Scanner(System.in);
		String query2="select tno from train_details where tno=?";
		PreparedStatement pstmt2=con.prepareStatement(query2);
		pstmt2.setInt(1, trainno);
		ResultSet rs1=pstmt2.executeQuery();
		if(rs1.next())
		{
			String s="select source,destination,fare from train_details where tno=?";
			PreparedStatement pstmt4=con.prepareStatement(s);
			pstmt4.setInt(1, trainno);
			ResultSet rs3=pstmt4.executeQuery();
			rs3.next();
			int fare=rs3.getInt(3);
			String clas;
			System.out.println("For Sleeper Enter SL");
			System.out.println("For AC enter AC");
			clas=sc.next();
			System.out.println("Enter no. of passengers");
			int psg=sc.nextInt();
			if(clas.equals("AC"))
			{
				fare+=200;
			}
			fare=fare*psg;
			String query1="insert into ticket_details values(?,?,?,?,?,?,?)";
			PreparedStatement pstmt1=con.prepareStatement(query1);
			pstmt1.setInt(1, max+1);
			pstmt1.setString(2,clas);
			pstmt1.setString(3, rs3.getString(1) );
			pstmt1.setString(4, rs3.getString(2) );
			pstmt1.setInt(5,psg);
			pstmt1.setInt(6,fare);
			pstmt1.setInt(7, trainno);
			int rs2=pstmt1.executeUpdate();
			if(rs2>0)
			{
				System.out.println("Ticket Booked");
			}
			else
			{
				System.out.println("Error");
			}
		}
		else
		{
			System.out.println("Not avaiable");
		}
		
	}
	
}
