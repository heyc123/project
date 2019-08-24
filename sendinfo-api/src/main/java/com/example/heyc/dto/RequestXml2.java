package com.example.heyc.dto;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class RequestXml2 {

	private String name;
	
	private String age;
	
	private String sign;
	
}
