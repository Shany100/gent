package com.gent.action;

import java.lang.reflect.Field;

import com.gent.bean.Event;

public class MyTest {
	public static void main(String[] args) {
		System.out.print("MyTest class is here.");
		Field[] fields = Event.class.getDeclaredFields();
		System.out.println(fields.length);
		for(int i=0, len = fields.length; i < len; i++){
			System.out.println(fields[i].getName());
		}
	}
}
