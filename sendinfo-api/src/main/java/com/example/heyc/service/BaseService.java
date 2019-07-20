package com.example.heyc.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface BaseService{

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public void get(final String id);
	
	
}
