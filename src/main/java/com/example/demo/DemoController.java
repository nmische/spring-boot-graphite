package com.example.demo;

import java.util.concurrent.TimeUnit;
import java.lang.IllegalArgumentException;
import java.lang.InterruptedException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
public class DemoController {

	@GetMapping("/echo-get")
	public ResponseEntity<String> getGet(
		@RequestParam(value = "msg", defaultValue = "Hello World!") String msg,
		@RequestParam(value = "status", defaultValue = "200") String status,
		@RequestParam(value = "latency", defaultValue = "0") String latency
		) {
		
		// simulate delay
		int latencyValue = Integer.parseInt(latency);
		try {
			TimeUnit.MILLISECONDS.sleep(latencyValue);
		} catch (InterruptedException e) {
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// generate response
		int statusValue = Integer.parseInt(status);
		try {
			HttpStatus code = HttpStatus.valueOf(statusValue);
			return new ResponseEntity<>(msg, code);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/echo-post")
	public ResponseEntity<String> getPost(
		@RequestParam(value = "msg", defaultValue = "Hello World!") String msg,
		@RequestParam(value = "status", defaultValue = "200") String status,
		@RequestParam(value = "latency", defaultValue = "0") String latency
		) {
		
		// simulate delay
		int latencyValue = Integer.parseInt(latency);
		try {
			TimeUnit.MILLISECONDS.sleep(latencyValue);
		} catch (InterruptedException e) {
			return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		// generate response
		int statusValue = Integer.parseInt(status);
		try {
			HttpStatus code = HttpStatus.valueOf(statusValue);
			return new ResponseEntity<>(msg, code);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
		}
	}
}
