package com.iss.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/sample-1")
public class SampleController {
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/get")
	public String get() {
		String out = restTemplate.getForObject("http://sample/test/get", String.class);
		return "This is from sample-1,from sample "+out;
	}
	@GetMapping("/admin")
	public String admin() {
		
		return "Hello Admin";
	}
	
	@GetMapping("/user")
	public String user() {
		
		return "Hello user";
	}
	
	@PostMapping("/admin/post")
	public String adminPost(@RequestBody Object body) {
		return "Hello admin post";
		
	}
	
	
}
