package common;

import java.sql.Statement;

import javax.servlet.ServletContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class JDBConnect {
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	//기본 생성자
	public  JDBConnect() {
		try {
			//jdbc 드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver");
			
			//DB에 연결
			String url= "jdbc:oracle:thin:@localhost:1521:xe";
			String id="c##musthave";
			String pwd="1234";
			con = DriverManager.getConnection(url, id, pwd);
			
			System.out.println("DB 연결 성공(기본 생성자)");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	public  JDBConnect(ServletContext application) {
//		try {
//			String driver= application.getInitParameter("OracleDriver");
//			Class.forName(driver);
//			
//			String url= application.getInitParameter("OracleURL");
//			String id= application.getInitParameter("OracleId");
//			String pwd= application.getInitParameter("OraclePwd");
//			con= DriverManager.getConnection(url,id,pwd);
//			
//		System.out.println("DB 연결 성공(인수 생성자 2)");
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	public JDBConnect(String driver, String url, String id, String pwd) {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, id, pwd);
			System.out.println("DB 연결 성공(인수 생성자 1)");
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public JDBConnect(ServletContext application) {
		try {
			//JDBC 드라이버 로드
			String driver= application.getInitParameter("OracleDriver");
			Class.forName(driver);
			
			//DB에 연결
			String url= application.getInitParameter("OracleURL");
			String id= application.getInitParameter("OracleId");
			String pwd= application.getInitParameter("OraclePwd");
			con=DriverManager.getConnection(url, id, pwd);
			
			System.out.println("DB 연결 성공(인수 생성자 2)");
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
	}
//연결 해제(자원 반납)
	public void close() {
		try {
			if(rs != null) rs.close();
			if(stmt != null)stmt.close();
			if(psmt != null) psmt.close();
			if(con != null) con.close();
			
			System.out.println("JDBC 자원 해제");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}









