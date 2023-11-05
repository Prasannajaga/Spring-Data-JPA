package com.example.demo;

 import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import com.example.demo.customTemplate.PostgreSqlTemplate;

import lombok.Data;

 
public class Test {
	
//	String name = "Prasanna";
	Integer age = 22;

	
	 Object getPropertyValue(String fieldName) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Field field = this.getClass().getDeclaredField(fieldName);
		return field.get(this);
	}
	 
	 <T> void getInstanceOf(T d) {
			System.err.println(d instanceof List<?>);
			System.err.println( d instanceof String);
	 }
	
	public static void main(String[] args) {
		
		Test t  = new Test();
		t.<List<String>>getInstanceOf(List.of("prasa","prsa"));
		
		try {
			System.err.println(t.getPropertyValue("name")); 
			
		} catch (Exception e) {
//			System.err.println(e instanceof NoSuchFieldException );
 		}
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("1", "prasanna");
		map.put("2", "jagadesh");
//		map.put, null

		for(Entry<String, String> en : map.entrySet()) {
			System.err.println(en.getKey());
			System.out.println(en.getValue()); 
		}
		
		
 	}
 
}
 