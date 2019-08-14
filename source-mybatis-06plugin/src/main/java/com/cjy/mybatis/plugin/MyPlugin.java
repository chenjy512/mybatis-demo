package com.cjy.mybatis.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.log4j.Logger;


import java.util.Properties;


@Intercepts({@Signature(type = Executor.class,
                        method = "update",
                        args = {MappedStatement.class,Object.class})})
public class MyPlugin implements Interceptor {

    private Logger logger = Logger.getLogger(MyPlugin.class);

    Properties props = null;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        logger.info("before..........");
        Object obj = invocation.proceed();
        logger.info("after..........");
        return obj;
    }

    @Override
    public Object plugin(Object target) {
        logger.info("before....plugin......");

        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {
            logger.info("setProperties-----"+properties.getProperty("dbType"));
    }
}
