package com.tcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyTripApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyTripApplication.class, args);
	}
}
/*
=================================================================
IRCTC CLOUD API URL : http://13.232.253.164:8080/swagger-ui.html//now it is not removed
=================================================================
this is 1) RestTemplate (out dated) approach
based on provider app we can access consumer
	private String BOOK_TICKET_URL="http://13.232.253.164:8080/ticket";
	
	private String GET_TICKET_URL="http://13.232.253.164:8080/ticket/{ticketNum}";
=====================
Consumer Development
======================

=> The application which is accessing services from other applications is called as Consumer application.

=> In Spring Boot we can develop Consumer in 3 ways

			1) RestTemplate (out dated)
			
			2) WebClient ( From Spring 5.x)

			3) FeignClient (Spring Cloud)
			

=====================================================
Steps To develop Make My Trip Application (Consumer)
=====================================================

1) Create Spring Boot app with below dependencies

		a) web-starter
		b) thymeleaf-starter
		c) lombok
		d) devtools

2) Create Request and Response Binding classes

3) Create Service class with Integration Logic

4) Create Controller with Required methods

			a) GET - load form
			b) POST - Book ticket
			c) GET - Get Ticket

5) Create View Pages 

6) Run the application


============================================================================

@Service
public class MakeMyTripServiceImpl implements MakeMyTripService {
	
	private String BOOK_TICKET_URL="http://13.232.253.164:8080/ticket";
	
	private String GET_TICKET_URL="http://13.232.253.164:8080/ticket/{ticketNum}";

	@Override
	public Ticket bookTicket(Passenger passenger) {
		
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> respEntity = 
				rt.postForEntity(BOOK_TICKET_URL, passenger, Ticket.class);
		
		Ticket ticket = respEntity.getBody();
		
		return ticket;
	}

	@Override
	public Ticket getTicketByNum(Integer ticketNumber) {
		
		RestTemplate rt = new RestTemplate();
		
		ResponseEntity<Ticket> respEntity = 
				rt.getForEntity(GET_TICKET_URL, Ticket.class, ticketNumber);
		
		Ticket ticket = respEntity.getBody();
		
		return ticket;
	}

}

=================================================================================================






*/