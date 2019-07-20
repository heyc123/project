package com.example.heyc.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;
@Data
public class UserInfoDto {

	private String userName;
	
	private Integer age;
	
	private Double sum;
	
	private Date time;
	
	private SubClass clazz;
	
	private List<String> datas;
	
	private List<SubClass> subs;
	
	
	
	
}
