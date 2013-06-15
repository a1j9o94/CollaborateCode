package com.team8.magiceightball;

import java.util.Random;

public class ResponseGenerator {
	private Random rand = new Random();
	private int choice;
	// Array of possible responses, taken from Wikipedia.
	private String[] responses = { "It is certain", "It is decidedly so",
			"Without a doubt", "Yes definitely", "You may rely on it",
			"As I see it yes", "Most likely", "Outlook good", "Yes",
			"Signs point to yes", "Reply hazy try again", "Ask again later",
			"Better not tell you now", "Cannot predict now",
			"Concentrate and ask again", "Don't count on it", "My reply is no",
			"My sources say no", "Outlook not so good", "Very doubtful" };

	public ResponseGenerator() {
		choice = rand.nextInt(responses.length);
	}

	public String getResponse() {
		return responses[choice];
	}
}
