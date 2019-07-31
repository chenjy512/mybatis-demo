package com.cjy.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

@MappedJdbcTypes(JdbcType.VARCHAR)  //数据库类型
@MappedTypes({List.class})			//java数据类型
public class ListTypeHandler implements TypeHandler<List<String>>{

	private Logger logger = Logger.getLogger(ListTypeHandler.class);
	
	@Override
	public void setParameter(PreparedStatement ps, int i,
			List<String> parameter, JdbcType jdbcType) throws SQLException {
		//logger.info("method ====>>> setParameter");
        String hobbys = dealListToOneStr(parameter);
        ps.setString(i , hobbys);
	}

	/**
	 * 集合拼接字符串
	 * @param parameter
	 * @return
	 */
	private String dealListToOneStr(List<String> parameter){
		if(parameter == null || parameter.size() <=0)
			return null;
		String res = "";
		for (int i = 0 ;i < parameter.size(); i++) {
			if(i == parameter.size()-1){
				res+=parameter.get(i);
				return res;
			}
			res+=parameter.get(i)+",";
		}
		return null;
	}
	
	//数据加载处理函数
	@Override
	public List<String> getResult(ResultSet rs, String columnName)
			throws SQLException {
		//logger.info("method ====>>> getResult(ResultSet rs, String columnName)");
		return Arrays.asList(rs.getString(columnName).split(","));
	}

	@Override
	public List<String> getResult(ResultSet rs, int columnIndex)
			throws SQLException {
		//logger.info("method ====>>> getResult(ResultSet rs, int columnIndex)");
		  return Arrays.asList(rs.getString(columnIndex).split(","));
	}

	@Override
	public List<String> getResult(CallableStatement cs, int columnIndex) throws SQLException{
		//logger.info("method ====>>> getResult(CallableStatement cs, int columnIndex)");
	    String hobbys = cs.getString(columnIndex);
	    return Arrays.asList(hobbys.split(","));
	}

}
