package com.example.heyc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PayDto {

	@XmlElement(name="pay_id")
	private Long payId;
	
	@XmlElement(name="pay_order_no")
	private String payOrderNo;
	
	@XmlElement(name="sign")
	private String sign;
	
}

