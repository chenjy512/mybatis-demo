package com.cjy.mybatis.objectFacotry;

import java.util.List;
import java.util.Properties;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.log4j.Logger;

import com.cjy.mybatis.entity.Employee;

public class MyObjectFactory extends DefaultObjectFactory{

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(MyObjectFactory.class);	
	
	@Override
	public void setProperties(Properties properties) {
		logger.info("定制属性：setProperties" + properties);
		super.setProperties(properties);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T create(Class<T> type) {
		logger.info("使用定制对象工厂的create方法构建单个对象  --  " + type);
		if(type == Employee.class){
			logger.info("return new Employee()  --  ");
			Employee e = new Employee();
			e.setObjectFacotry("我是自定义对象工程创建的实例对象~~~~");
			return (T) e;
		}
		return super.create(type);
	}
	
	@Override
	public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes,
			List<Object> constructorArgs) {
		logger.info("使用定制对象工厂的create方法构建列表对象  --  " + type);
		return super.create(type, constructorArgTypes, constructorArgs);
	}
	
	@Override
	public <T> boolean isCollection(Class<T> type) {
		return super.isCollection(type);
	}
	
}
