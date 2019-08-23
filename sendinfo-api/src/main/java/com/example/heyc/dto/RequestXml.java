package com.example.heyc.dto;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

//----测试更新

@Data
@XmlRootElement
public class RequestXml {

	private String name;
	
	private String age;
	
	private String sign;
	
}
