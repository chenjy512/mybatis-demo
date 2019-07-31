package com.cjy.mybatis.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectService {

	public void sayHello(String name){
		System.out.println("sayHello : "+name);
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Object object = Class.forName(ReflectService.class.getName()).newInstance();
		System.out.println(ReflectService.class);
		System.out.println(ReflectService.class.getName());
		System.out.println(object);
		
		Method method = object.getClass().getMethod("sayHello", String.class);
		System.out.println(object.getClass());
		System.out.println(method);
		System.out.println(ReflectService.class.getMethod("sayHello", String.class));
		method.invoke(object, "11111");
		
		
	}
}
