package com.car.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


import org.apache.log4j.spi.ErrorCode;
import org.apache.log4j.spi.LoggingEvent;

public class JDBCExtAppender extends org.apache.log4j.jdbc.JDBCAppender {
	 public JDBCExtAppender() {
	        super();
	    }
	 
	    /**
	     * 重载JDBCAppender的getConnection()方法
	     */
	    protected Connection getConnection() throws SQLException {

	    		
	            try{
	            Context initCtx = new InitialContext();

	            DataSource ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/echargeconn");
	            if (ds != null)
	                this.connection = ds.getConnection();
	            }catch(NamingException namingex){
	                namingex.printStackTrace();
	                throw new SQLException("-datapool init error ");
	            }
	       
	        return this.connection; 
	    } 
	    
	    
	    
	    /**
	     * 重载getLogStatement()方法，
	     * 在SQL字符串最后添加用户ID等信息
	     */
	     protected String getLogStatement(LoggingEvent event) {
	         StringBuffer stringBuffer = new StringBuffer(); 
	         stringBuffer.append(layout.format(event)); 
	         
	         if (event.getMessage() instanceof ParameterizedMessage) {
	             
	             //检测SQL的最后一个字符是不是逗号，如果不是，则在这里补上
	             if(stringBuffer.charAt(stringBuffer.length()-1)!=',')
	                 stringBuffer.append(",");
	             
	             Object[] params = ((ParameterizedMessage) event.getMessage()).getParameters();   
	             for (int i = 1; i < params.length; i++) { 
	                     stringBuffer.append(params[i]);
	                     stringBuffer.append(",");  
	             }   
	             
	             stringBuffer.deleteCharAt(stringBuffer.length()-1);
	             stringBuffer.append(")");
	         }   
	        return stringBuffer.toString();
	    }
	     
	    
	    /**
	     * 重载JDBCAppender的方法，取消与数据库的连接
	     */
	    protected void closeConnection(Connection con) {
	        
	        try {
	            if (connection != null && !connection.isClosed())
	                connection.close();
	        } catch (SQLException e) {
	            errorHandler.error("Error closing connection", e,
	                    ErrorCode.GENERIC_FAILURE);
	        }

	    }
	    public interface ParameterizedMessage extends Serializable {   
	    	   
	        /**  
	         * 获取参数列表  
	         * @return 返回参数列表  
	         */  
	        public Object[] getParameters();   
	           
	        /**  
	         * 获取指定索引位置的参数  
	         * @param index 索引位置  
	         * @return 返回参数列表中指定索引位置的参数值  
	         * @throws IndexOutOfBoundsException 当index >= 参数列表个数时，抛出此异常  
	         * @see getParameterCount()  
	         */  
	        public Object getParameter(int index) throws IndexOutOfBoundsException;   
	           
	        /**  
	         * 获取参数个数  
	         * @return 返回参数个数  
	         */  
	        public int getParameterCount();   
	           
	    }   
	    
	    
	    public class JDBCLogMessage implements ParameterizedMessage {
	        private static final long serialVersionUID = 1709063421963292637L;
	        private Object[] params;

	        public JDBCLogMessage(Object... params) {
	            this.params = params;
	        }

	        public Object[] getParameters() {
	            return this.params;
	        }

	        public Object getParameter(int index) throws IndexOutOfBoundsException {
	            return this.params[index];
	        }

	        public int getParameterCount() {
	            return this.params.length;
	        }

	        @Override
	        public String toString() {
	            return Arrays.toString(this.params);
	        }
	    }
}
