package com.service;

import com.dao.TicketDao;

public class TicketManagement {

	TicketDao ticket;

	public TicketDao getTck() {
		return ticket;
	}

	public void setTck(TicketDao ticket) {
		this.ticket = ticket;
	}
	
	public void login(String unm,String pwd) throws Exception
	{
		ticket.login(unm, pwd);
	}
	public void bookTicket(int trainno) throws Exception
	{
		ticket.bookTicket(trainno);
	}
}
