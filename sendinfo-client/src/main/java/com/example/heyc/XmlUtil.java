package com.example.heyc;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Unmarshaller.Listener;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

public class XmlUtil{
	
	public static String objToXml(PayDto pay) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(pay.getClass());
		Marshaller marshaller = context.createMarshaller();
		StringWriter writer = new StringWriter();
		marshaller.marshal(pay, writer);
		String xml = new String(writer.getBuffer());
		System.out.println(xml);
		return xml;
	}
	
	public static<T> void xmlToObj(String xml, Class<T> clazz) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(clazz);
		Unmarshaller unmarshaller = context.createUnmarshaller();
	
		unmarshaller.setListener(new Listener() {
			@Override
			public void beforeUnmarshal(Object target, Object parent) {
				super.beforeUnmarshal(target, parent);
				System.out.println("解析之前");
			}
			
			@Override
			public void afterUnmarshal(Object target, Object parent) {
				super.afterUnmarshal(target, parent);
				System.out.println("解析之后");
			}
		});
		T t = (T) unmarshaller.unmarshal(new StringReader(xml));
		System.out.println(t+"===");
	}
	
	public static void main(String[] args) throws JAXBException {
		PayDto dto = new PayDto();
		dto.setPayId(1L);
		dto.setPayOrderNo("123456789");
		dto.setSign("11111111");
		String xml = objToXml(dto);
		xmlToObj(xml, PayDto.class);
	}
	
}