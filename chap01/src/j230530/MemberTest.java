package j230530;

import java.util.ArrayList;

public class MemberTest {

	public static void main(String[] args) {
		
	}
		MemberDAO dao = new MemberDao();
		ArrayList<MemberVo>list=dao.list();
		
		for(int i=0; i< list.size(); i++) {
			MemberVo data=(MemberVo)list.get(i);
			String empno =data.getEmpno();
			String ename= data.getEname();
			int sal = data.getSal();
			
			System.out.println(empno+ ":"+ename+":"+ sal);
		}

	}
	public class MemberVo{
	private String empno;
	private String ename;
	private int sal;
	
	
	public MemberVo() {
}
	public MemberVo(String empno, String ename, int sal) {
		this.empno=empno;
		this.ename=ename;
		this.sal=sal;
	}
	public String getEmpno() {
		return empno;
	}
	public String getEname() {
		return ename;
		}
	public String getSal() {
		return sal;
		}
	}

	
	
	
	
	
	
	
	
