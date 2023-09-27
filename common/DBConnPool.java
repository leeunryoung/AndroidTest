package common;

import java.sql.Statement ;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.naming.Context;
import javax.sql.DataSource;

import javax.naming.InitialContext;

public class DBConnPool {
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	//기본생성자
	public DBConnPool() {
		try {
			//커넥션 풀(datasource) 얻기
			Context initCtx=new InitialContext();
			Context ctx= (Context)initCtx.lookup("java:comp/env");
			DataSource source= (DataSource)ctx.lookup("dbcp_myoracle");
			
			con=source.getConnection();
			
			System.out.println("DB 커넥션 풀 연결 성공");
		}
		catch (Exception e) {
			System.out.println("DB 커넥션 풀 연결 실패");
			e.printStackTrace();
		}
	}
//연결해제(자원반납)
	public void close() {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(psmt != null) psmt.close();
			if(con != null) con.close();
			
			System.out.println("DB 커넥션 풀 자원 반납");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}}
