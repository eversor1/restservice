package com.example.restservice;

public class Greeting {

	private final long id;
	private final String content;
	private final String ipaddress;
	private final String hostname;

	public Greeting(long id, String content, String ipaddress, String hostname) {
		this.id = id;
		this.content = content;
		this.ipaddress = ipaddress;
		this.hostname = hostname;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public String getHostname() {
		return hostname;
	}
}
