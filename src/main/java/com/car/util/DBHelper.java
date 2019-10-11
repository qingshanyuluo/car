package com.car.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;
import javax.sql.DataSource;

public final class DBHelper {

	// 此方法为获取数据库连接

	public static Connection getConnection() {

		Connection conn = null;

		try {

			Context context=new InitialContext();
			DataSource source=(DataSource) context.lookup("java:comp/env/jdbc/echargeconn");
			

			if (null == conn) {

				conn=source.getConnection();

			}

		} catch (NamingException e) {

			System.out.println("Sorry,can't find the Driver!");

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return conn;

	}

	/**
	 * 
	 * 增删改【Add、Del、Update】
	 * 
	 * 
	 * 
	 * @param sql
	 * 
	 * @return int
	 */

	public static int executeNonQuery(String sql) {

		int result = 0;

		Connection conn = null;

		Statement stmt = null;

		try {

			conn = getConnection();

			stmt = conn.createStatement();

			result = stmt.executeUpdate(sql);

		} catch (SQLException err) {

			err.printStackTrace();

			free(null, stmt, conn);

		} finally {

			free(null, stmt, conn);

		}

		return result;

	}

	/**
	 * 
	 * 增删改【Add、Delete、Update】
	 * 
	 * 
	 * 
	 * @param sql
	 * 
	 * @param obj
	 * 
	 * @return int
	 */

	public static int executeNonQuery(String sql, Object... obj) {

		int result = 0;

		Connection conn = null;

		PreparedStatement pstmt = null;

		try {

			conn = getConnection();

			pstmt = conn.prepareStatement(sql);

			for (int i = 0; i < obj.length; i++) {

				pstmt.setObject(i + 1, obj[i]);

			}

			result = pstmt.executeUpdate();

		} catch (SQLException err) {

			err.printStackTrace();

			free(null, pstmt, conn);

		} finally {

			free(null, pstmt, conn);

		}

		return result;

	}
	

	public static int myupdate(String sql,Object...obj){
		int result = 0;
		int rtnKey = -1;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			for(int i=0;i<obj.length;i++){
				pstmt.setObject(i+1, obj[i]);
			}
			result = pstmt.executeUpdate();
			rs=pstmt.getGeneratedKeys();
			if(rs.next()){
				rtnKey=rs.getInt(1);
			}
		} catch (SQLException err) {

			err.printStackTrace();

			free(rs, pstmt, conn);

		} finally {

			free(rs, pstmt, conn);

		}
		return rtnKey;
	}

	/**
	 * 
	 * 查【Query】
	 * 
	 * 
	 * 
	 * @param sql
	 * 
	 * @return ResultSet
	 */

	public static Result executeQuery_new(String sql) {

		Connection conn = null;
		Statement stmt = null;
		Result result=null;
		ResultSet rs = null;

		try {

			conn = getConnection();

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);
			result=ResultSupport.toResult(rs);  //一定要在关闭数据库之前完成转换   

		} catch (SQLException err) {

			err.printStackTrace();

			free(rs, stmt, conn);

		}finally {

			free(rs, stmt, conn);

		}

		return result;

	}

	/**
	 * 
	 * 查【Query】
	 * 
	 * 
	 * 
	 * @param sql
	 * 
	 * @param obj
	 * 
	 * @return ResultSet
	 */

	public static Result executeQuery_new(String sql, Object... obj) {

		Connection conn = null;

		PreparedStatement pstmt = null;

		Result result=null;
		ResultSet rs = null;

		try {

			conn = getConnection();

			pstmt = conn.prepareStatement(sql);

			//System.out.println(conn);
			
			for (int i = 0; i < obj.length; i++) {

				pstmt.setObject(i + 1, obj[i]);

			}
			
			rs = pstmt.executeQuery();
			
			
			result=ResultSupport.toResult(rs);  //一定要在关闭数据库之前完成转换  

		} catch (Exception err) {

			err.printStackTrace();

			free(rs, pstmt, conn);

		}finally {

			free(rs, pstmt, conn);

		}

		return result;

	}

	/**
	 * 
	 * 判断记录是否存在
	 * 
	 * 
	 * 
	 * @param sql
	 * 
	 * @return Boolean
	 */

	public static Boolean isExist_new(String sql) {

		//ResultSet rs = null;
		Result rs=null;
			rs = executeQuery_new(sql);

				int count = rs.getRowCount();  
			    if (count > 0) {

				    return true;

			    } else {

			     	return false;
			    }
	}

	/**
	 * 
	 * 判断记录是否存在
	 * 
	 * 
	 * 
	 * @param sql
	 * 
	 * @return Boolean
	 */

	public static Boolean isExist_new(String sql, Object... obj) {

		Result rs=null;
		rs = executeQuery_new(sql, obj);
		int count = rs.getRowCount(); 

			if (count > 0) {

				return true;

			} else {

				return false;

			}
	}

	/**
	 * 
	 * 获取查询记录的总行数
	 * 
	 * 
	 * 
	 * @param sql
	 * 
	 * @return int
	 */

	public static int getCount_new(String sql) {

		int result = 0;

		Result rs=null;

			rs = executeQuery_new(sql);
		    result = rs.getRowCount(); 

		return result;

	}

	/**
	 * 
	 * 获取查询记录的总行数
	 * 
	 * 
	 * 
	 * @param sql
	 * 
	 * @param obj
	 * 
	 * @return int
	 */

	public static int getCount_new(String sql, Object... obj) {

	      int result = 0;
		  Result rs=null;
	      rs = executeQuery_new(sql, obj);
	      result = rs.getRowCount(); 

     	return result;
	}

	/**
	 * 
	 * 释放【ResultSet】资源
	 * 
	 * 
	 * 
	 * @param rs
	 */

	public static void free(ResultSet rs) {

		try {

			if (rs != null) {

				rs.close();

			}

		} catch (SQLException err) {

			err.printStackTrace();

		}

	}

	/**
	 * 
	 * 释放【Statement】资源
	 * 
	 * 
	 * 
	 * @param st
	 */

	public static void free(Statement st) {

		try {

			if (st != null) {

				st.close();

			}

		} catch (SQLException err) {

			err.printStackTrace();

		}

	}

	/**
	 * 
	 * 释放【Connection】资源
	 * 
	 * 
	 * 
	 * @param conn
	 */

	public static void free(Connection conn) {

		try {

			if (conn != null) {

				conn.close();

			}

		} catch (SQLException err) {

			err.printStackTrace();

		}

	}

	/**
	 * 
	 * 释放所有数据资源
	 * 
	 * 
	 * 
	 * @param rs
	 * 
	 * @param st
	 * 
	 * @param conn
	 */

	public static void free(ResultSet rs, Statement st, Connection conn) {

		free(rs);

		free(st);

		free(conn);

	}
	

}
