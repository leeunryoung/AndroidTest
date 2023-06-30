package j230530;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url= "jdbc:oracle:thin: @localhost:1521/xe";
	String user= "C##himedia";
	String password= "himedia";
	
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	public ArrayList<MemberVo> list(){
		ArrayList<MemberVo> list = new ArrayList <MemberVo>();
		
		try {
			connDB();
			
			String query= "SELECT*FROM emp";
			rs=stmt.executeQuery(query);
			while(rs.next()) {
				String empno= rs.getString("empno");
				String ename=rs.getString("ename");
				int sal= rs.getInt("sal");
				
				MemberVo data = new MemberVo (empno, ename, sal);
				list.add(data);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
public void connDB() {
	try {
		Class.forName(driver);
		System.out.println("jdbc driver loading success.");
		con=DriverManager.getConnection(url,user, password);
		System.out.println("oracle connection success.");
		stmt= con.createStatement();
		System.out.println("stratement create success.");
	}catch(Exception e) {
		e.printStackTrace();
	}
}	
}