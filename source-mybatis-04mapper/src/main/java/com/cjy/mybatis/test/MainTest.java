package com.cjy.mybatis.test;

import java.lang.reflect.Method;

import com.cjy.mybatis.entity.Employee;

public class MainTest {

	
	public static void main(String[] args) {
		classMethod();
	}
	public static void classMethod(){
		Class<?> currentClass = Employee.class;
		Method[] methods = currentClass.getMethods();
		
		for (Method currentMethod : methods) {
		      if (!currentMethod.isBridge()) {
		          String signature = getSignature(currentMethod);
		          // check to see if the method is already known
		          // if it is known, then an extended class must have
		          // overridden a method
		          //if (!uniqueMethods.containsKey(signature)) {
		            //if (canAccessPrivateMethods()) {
		              try {
		                currentMethod.setAccessible(true);
		              } catch (Exception e) {
		                // Ignored. This is only a final precaution, nothing we can do.
		              }
		              System.out.println("----->  "+signature);
		            }

		            //uniqueMethods.put(signature, currentMethod);
		          //}
		        //}
		}
		
	}
	
	  private static String getSignature(Method method) {
		    StringBuilder sb = new StringBuilder();
		    //方法返回值类型
		    Class<?> returnType = method.getReturnType();
		    if (returnType != null) {
		      sb.append(returnType.getName()).append('#');
		    }
		    //方法名
		    sb.append(method.getName());
		    //方法参数类型
		    Class<?>[] parameters = method.getParameterTypes();
		    for (int i = 0; i < parameters.length; i++) {
		      if (i == 0) {
		        sb.append(':');
		      } else {
		        sb.append(',');
		      }
		      sb.append(parameters[i].getName());
		    }
		    return sb.toString();
		  }

}
