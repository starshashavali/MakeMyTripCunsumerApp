package com.tcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcs.request.Passenger;
import com.tcs.response.Ticket;
import com.tcs.service.MakeMyTripService;

@Controller
public class MakeMyTripController {
	
	@Autowired
	private MakeMyTripService service;
	
	@GetMapping("/get-ticket")
	public String getTicket(@RequestParam Integer ticketNum,Model model) {
		
		Ticket ticketByNum = service.getTicketByNum(ticketNum);
		System.out.println(ticketByNum);
		model.addAttribute("ticket", ticketByNum);
		return "ticket-form";
	}
	
	
	@GetMapping("/ticket")
	public String getTicketForm(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "ticket-form";
	}
	@PostMapping("/book-ticket")
	public String bookTicket(@ModelAttribute("passenger") Passenger passenger,Model model) {
		System.out.println(passenger);
		Ticket ticket = service.bookTicket(passenger);
		model.addAttribute("msg", "Your Ticket booked Successfully:\r\this is your ticketNumber"+ticket);

		return "index";
	}

	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("passenger", new Passenger());
		return "index";
	}

}
