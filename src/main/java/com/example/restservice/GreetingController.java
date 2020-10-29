package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private static final String ipTemplate = "%s";
	private static final String hostnameTemplate = "%s";
	private final AtomicLong counter = new AtomicLong();
	private InetAddress ip;
	private String hostname;

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		try {
			ip = InetAddress.getLocalHost();
			hostname = ip.getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		return new Greeting(
			counter.incrementAndGet(), 
			String.format(template, name), 
			String.format(ipTemplate, ip), 
			String.format(hostnameTemplate, hostname)
		);
	}
}
