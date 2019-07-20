package com.example.heyc.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BaseServiceImpl implements BaseService {

	@RequestMapping(value = "{url}/get", method = RequestMethod.GET)
	@Override
	public void get(String id) {
		log.info("终于请求到通用的crud方法,入参id={}", id);

	}

}
