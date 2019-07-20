package com.example.heyc.controller;

import java.util.function.Predicate;

public class FileUtil {
	
	public static void main(String[] args) {
		Predicate<String> t = Predicate.isEqual("a");
		System.out.println(t.test("a"));
	}
}
