package com.cjy.mybatis.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cjy.mybatis.entity.Person;

public interface PersonMapper {
	
	/**
	 * 数据查询
	 * @param id
	 * @return
	 */
	public Person queryPersonById(Integer id);
	public Person queryPersonByIdAndLikeNamesToVo(Person person);
	public Person queryPersonByIdAndLikeNames(@Param("id") Integer id ,@Param("userName") String userName);
	public Person queryPersonByIdAndLikeNamesToMap(Map<String,Object> map);
	/**
	 * 数据新增
	 * @param person
	 * @return
	 */
	public int savePersonInfo(Person person);
	public int savePersonInfoLoadKey(Person person);
	public int savePersonInfoCreateAndLoadKey(Person person);
	
	/**
	 * 数据修改
	 */
	public int updatePersonInfoById(Person person);
	
	/**
	 * 数据移除
	 */
	public int removePersonInfoById(Integer id);

}
