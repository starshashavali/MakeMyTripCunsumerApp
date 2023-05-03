package com.tcs.service;

import com.tcs.request.Passenger;
import com.tcs.response.Ticket;

public interface MakeMyTripService {
	
	public Ticket bookTicket(Passenger passenger);
	public Ticket getTicketByNum(Integer ticketNum);

}
