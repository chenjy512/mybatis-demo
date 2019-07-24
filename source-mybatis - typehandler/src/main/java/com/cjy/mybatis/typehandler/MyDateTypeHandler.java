package com.cjy.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

@MappedJdbcTypes({JdbcType.VARCHAR})  //对应数据库类型
@MappedTypes({Date.class})			  //java数据类型
public class MyDateTypeHandler implements TypeHandler<Date>{

	private Logger logger = Logger.getLogger(MyDateTypeHandler.class);
	
	//入库前的类型转换
	@Override
	public void setParameter(PreparedStatement ps, int i, Date parameter,
			JdbcType jdbcType) throws SQLException {
		logger.info("setParameter(PreparedStatement ps, int i, Date parameter,JdbcType jdbcType)....");
		ps.setString(i, String.valueOf(parameter.getTime()));
	}
	//查询后的数据处理
	@Override
	public Date getResult(ResultSet rs, String columnName) throws SQLException {
		logger.info("getResult(ResultSet rs, String columnName)....");
		return new Date(rs.getLong(columnName));
	}
	@Override
	public Date getResult(ResultSet rs, int columnIndex) throws SQLException {
		logger.info("getResult(ResultSet rs, int columnIndex)....");
		return new Date(rs.getLong(columnIndex));
	}
	@Override
	public Date getResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		logger.info("getResult(CallableStatement cs, int columnIndex)....");
		return cs.getDate(columnIndex);
	}

}
