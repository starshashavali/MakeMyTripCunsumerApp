package com.tcs.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tcs.request.Passenger;
import com.tcs.response.Ticket;

@Service // @Service is used to represent java class as springbean
public class MakeMyTripServiceImpl implements MakeMyTripService {
	private String BOOK_TICKET_URL="http://13.232.253.164:8080/ticket";

	
	//private String BOOK_TICKET_URL = "http://13.232.253.164:8080/ticketNum";
//used map post request
	private String GET_TICKET_URL="http://13.232.253.164:8080/ticket/{ticketNum}";

	//private String GET_TICKET_URL = "http://13.232.253.164:8080/ticketNum";

//used map get request
	@Override
	public Ticket bookTicket(Passenger passenger) {
		RestTemplate r = new RestTemplate();
		// this class is responsible to send response to given url
		ResponseEntity<Ticket> postForEntity = r.postForEntity(BOOK_TICKET_URL, passenger, Ticket.class);
		// url,input data as passenger,Store that response to Ticket class
		Ticket ticket = postForEntity.getBody();
		return ticket;
	}

	@Override
	public Ticket getTicketByNum(Integer ticketNum) {
		RestTemplate r = new RestTemplate();
		ResponseEntity<Ticket> entity = r.getForEntity(GET_TICKET_URL, Ticket.class, ticketNum);
		Ticket ticket = entity.getBody();
		return ticket;
	}

}
