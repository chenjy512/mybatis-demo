package com.cjy.mybatis.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.util.Properties;


@Intercepts({@Signature(type = StatementHandler.class,
        method = "prepare",
        args = {Connection.class,Integer.class})
})
public class QueryLimitPlugin implements Interceptor {


    private Logger logger = Logger.getLogger(QueryLimitPlugin.class);


    private int limit;
    private String dbType;

    private static final String LMT_TABLE_NAME="limit_table_name_$$xxx";

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);

        while(metaObject.hasGetter("h")){
            Object h = metaObject.getValue("h");
            metaObject = SystemMetaObject.forObject(h);
        }

        while (metaObject.hasGetter("target")){
            Object h = metaObject.getValue("target");
            metaObject = SystemMetaObject.forObject(h);
        }

        String sql = (String) metaObject.getValue("delegate.boundSql.sql");
        logger.info("sql----------"+ sql);

        String limitSql;

        if("mysql".equals(this.dbType) && sql.indexOf(LMT_TABLE_NAME) == -1){
            sql = sql.trim();
            limitSql = "select * from ( "+sql.trim()+" ) "+ LMT_TABLE_NAME + " limit "+limit;
            metaObject.setValue("delegate.boundSql.sql",limitSql);
            logger.info("limitSql----------"+ limitSql);
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {

        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {
        this.limit = Integer.parseInt(properties.getProperty("limit"));
        this.dbType = properties.getProperty("dbType");
    }
}
