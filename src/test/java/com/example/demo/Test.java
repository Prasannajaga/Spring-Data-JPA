package com.example.demo;

 import org.springframework.stereotype.Component;

import com.example.demo.customTemplate.PostgreSqlTemplate;

import lombok.Data;

 
public class Test {

	
//	private PostgreSqlTemplate<Some> template = new PostgreSqlTemplate<Some>();
	
	
	public static void main(String[] args) {
		
//		Test test = new Test();
		System.err.println();
//		Class<?> n  = test.getClass();
//		System.err.println(n.getModifiers() + n.getPackageName() +  n.descriptorString());
 	}
}

@Component
class Some{
	
	private String name;
}